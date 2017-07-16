
var width = 800,
    height = 600;

var projection = d3.geo.albersUsa()
    .scale(1000)
    .translate([width / 2, height / 2]);

var path = d3.geo.path()
    .projection(projection);

var zoom = d3.behavior.zoom()
    .scaleExtent([1, 10])
    .center([width / 2, height / 2])
    .on("zoom", zoomed);

var svg = d3.select("#svgSection").append("svg")
    .attr("viewBox", "0 0 " + width + " " + height)
    .attr("preserveAspectRatio", "xMidYMid meet");

var defs = svg.append("defs");

var svgGroup = svg.append("g")
var rectGroup = svg.append('g').attr('class', 'rectgroup');

var usMap = svgGroup.append('path');
/*var zoom = d3.behavior.zoom()
	    .scale(projection.scale() * 2 * Math.PI)
	    .on("zoom", zoomed);*/


$(document).ready(function(e) {


    defs.append("filter")
        .attr("id", "blur")
        .append("feGaussianBlur")
        .attr("stdDeviation", 5);


    //draw US Map
    d3.json("data/us.json", generateUsMap); //d3.json ends for US Map generation

    //load the network data.
    d3.json("data/node.json", generateNetworkNodes);

    d3.select(self.frameElement).style("height", height + "px");

    svg.call(zoom);

});




function generateUsMap(error, us) {

    svgGroup.append('g')
        .attr("id", "land")
        .selectAll("states")
        .data(topojson.feature(us, us.objects.states).features)
        .enter().append("path")
        .attr("d", path)
}

var boxWidth = 25;
var boxHeight = 25;
var network;

function generateNetworkNodes(error, graph) {
    // Multi Links
    network = graph;
    preProcessGraph(network);
    var links = graph.links;

    links.sort(function(a, b) {
        if (a.source > b.source) {
            return 1;
        } else if (a.source < b.source) {
            return -1;
        } else {
            if (a.target > b.target) {
                return 1;
            }
            if (a.target < b.target) {
                return -1;
            } else {
                return 0;
            }
        }
    });

    for (var i = 0; i < links.length; i++) {
        if (i != 0 &&
            links[i].source == links[i - 1].source &&
            links[i].target == links[i - 1].target) {
            links[i].linknum = links[i - 1].linknum + 1;
        } else {
            links[i].linknum = 1;
        };
    };

    var nodes = graph.nodes;

    // Compute the distinct nodes from the links.
    links.forEach(function(link) {
        link.source = nodes[link.source] || (nodes[link.source] = {
            name: link.source
        });
        link.target = nodes[link.target] || (nodes[link.target] = {
            name: link.target
        });
    });


    var linePath = rectGroup.append('g').selectAll('.line')
        .data(links).enter().append('svg:path')
        .attr('class', function(d) {
            return d.type
        })
        .attr('d', createPath)

    rectGroup.append('g').selectAll('.node').data(graph.nodes).enter().append('svg:image')
        .attr('class', 'node')
        .attr("transform", function(d) {
            var axes = projection([d.y, d.x]);
            return "translate(" + [axes[0] - boxWidth / 2, axes[1] - boxHeight / 2] + ")";
        })
        .attr('d', path)
        .attr('height', boxHeight)
        .attr('width', boxWidth)
        .attr('xlink:href', function(d) {
            return 'images/' + d.icon + '.png'
        })
        .on('mouseover', showNodeInfo)
        .on('mouseout', hideNodeInfo)

    rectGroup.append('g').selectAll('.text').data(graph.nodes).enter()
        .append('text')
        .style('font-size', '8px')
        .attr('text-anchor', 'middle')
        .attr('dy', 20)
        .text(function(d) {
            return d.name
        })
        .attr("transform", function(d) {
            return "translate(" + projection([d.y, d.x]) + ")";
        });


    rectGroup.append('g').selectAll('.alarmNode').data(graph.nodes).enter().append('svg:circle')
        .attr('class', 'alarmNode')
        .filter(function(d) {
            return d.showAlert != undefined;
        })
        .attr("transform", function(d) {
            var axes = projection([d.y, d.x]);
            return "translate(" + [axes[0] - boxWidth / 2 + 4, axes[1] - boxHeight / 2] + ")";
        })
        .attr('d', path)
        .attr('fill', 'red')
        .attr('opacity', 0.5)
        .attr('r', 4)
        .call(blinkTransition, 500, false);


    //var text = rectGroup.selectAll('.text').data(graph.nodes).enter().append('text')
    //			.text(function(d){return d.name})	 				
    //Text inside rect...
    /*
		rectGroup.append('g').selectAll('.rectText').data(graph.nodes).enter().append('foreignObject')
				.attr('class', 'rectText')    
		.attr("transform", function(d) { var axes = projection([d.y,d.x]);
							return "translate(" + [axes[0]-boxWidth/2+10, axes[1]-boxHeight/3] + ")"; })
							.attr('height', boxHeight)
							.attr('width', boxWidth)
							.append("xhtml:p")
							.html(function(d){return  d.name});
 		*/

    //Text between links...
    /*rectGroup.append('g').selectAll('.linkText').data(links).enter().append('foreignObject')
				.attr('class', 'linkText')   
				.attr("transform", centerPathText)
							.attr('height', '400')
							.attr('width', boxWidth)
							.style('font-size',"10px")
							.append("xhtml:p")
							.html(function(d){return  d.distance});*/

    rectGroup.append('g').selectAll('.linkText').data(links).enter().append('text')
        .attr('class', 'linkText')
        .attr("transform", centerPathText)
        .attr('text-anchor', 'middle')
        .style('font-size', '12px')
        .attr('text-anchor', 'middle')
        .attr('dy', 10)
        .attr('fill', '#000')
        .text(function(d) {
            return d.distance
        });


}


function blinkTransition(selection, duration, isOpaque) {
    selection.transition()
        .delay(function(d, i) {
            return i * 10;
        })
        .duration(duration)
        .attr('opacity', isOpaque ? 1 : 0.1)

    setTimeout(function() {
        blinkTransition(selection, duration, !isOpaque);
    }, duration);
}


var previousScale;
var previousTranslate;

function zoomed() {
    //scale = zoom.scale();
    console.log(d3.event.translate);
    console.log(d3.event.scale);
    processZoom(d3.event.scale, d3.event.translate);


}




function createPath(d) {
    var relativeDistance = 10;
    var src = projection([d.source.y, d.source.x]);
    var tgt = projection([d.target.y, d.target.x]);
    var dx = tgt[0] - src[0],
        dy = tgt[1] - src[1],
        dr = 100 / d.linknum;

    if (d.linknum == 1) {
        return "M" + src[0] + "," + src[1] + "L" + tgt[0] + "," + tgt[1];
    } else if (d.linknum == 2) {
        return "M" + ((src[0]) + relativeDistance) + "," + ((src[1]) + relativeDistance) + "L" + ((tgt[0]) + relativeDistance) + "," + ((tgt[1]) + relativeDistance);
    } else {
        return "M" + ((src[0]) - relativeDistance) + "," + ((tgt[1]) - relativeDistance) + "L" + ((tgt[0]) - relativeDistance) + "," + ((tgt[1]) - relativeDistance);

    }
}

function centerPathText(d) {

    var src = projection([d.source.y, d.source.x]);
    var tgt = projection([d.target.y, d.target.x]);
    var dx = (tgt[0] + src[0]) / 2,
        dy = (tgt[1] + src[1]) / 2;
    return "translate(" + [dx - 10, dy] + ")";
}


var selection;

function showNodeInfo(d) {
    console.log(d);
    if (d.desc)
        $('#mapDetailSection').html(d.desc);

    console.log(d3.selectAll('svg .linkPath'));
    selection = d3.selectAll('.linkPath')
        .filter(function(data, i) {
            console.log(data);
            return data.source.name.indexOf(d.name) != -1 || data.target.name.indexOf(d.name) != -1;
        });
    console.log(selection);
    selection.attr('class', 'selectedlink');

}

function hideNodeInfo(d) {
    $('#mapDetailSection').html("");
    console.log(selection);
    clearLinksInfo();
    //selection.attr('class', 'linkPath');
}

function clearLinksInfo() {
    d3.selectAll('g.newg').remove();
    //d3.selectAll("path.newPath.selectedRedLink").remove();
    d3.selectAll('path.selectedlink').attr('class', 'linkPath');
    d3.selectAll('path.selectedGreenLink').attr('class', 'linkPath');
    d3.selectAll('path.selectedYellowLink').attr('class', 'linkPath');
    d3.selectAll("path.selectedRedLink").attr('class', 'linkPath');
    rectGroup.selectAll('text').attr('fill', '#000');
}




// Zoom Button Definition
function zoomBtn(action) {
    var currentZoom = zoom.scale();
    var currentTranslate = zoom.translate();

    var scale = currentZoom + (action == 'out' ? -1 : 1);
    if (scale == 0) {
        scale = 1;
    }
    zoom.scale(scale);

    var w = width;
    var h = height;
    zoom.translate([w / 2, h / 2]);
    svgGroup
        .attr("transform",
            "translate(" + w / 2 + ", " + h / 2 + ") " +
            "scale(" + scale + ") " +
            "translate(" + (-w / 2) + ", " + (-h / 2) + ")");
    rectGroup
        .attr("transform",
            "translate(" + w / 2 + ", " + h / 2 + ") " +
            "scale(" + scale + ") " +
            "translate(" + (-w / 2) + ", " + (-h / 2) + ")");

}


function processZoom(scale, translate) {

   // projection
     //   .scale(scale)
      //  .translate(translate);
    //if(!previousScale || previousScale != scale){

    /*svgGroup
        .attr("transform", "translate(" + translate + ")scale(" + scale + ")");
    rectGroup
        .attr("transform", "translate(" + translate + ")scale(" + scale + ")");
    previousScale = scale;
    previousTranslate = translate;*/
	projection
        .scale(scale)
       .translate(translate);
	 var t1 = projection.translate(),
        t2 = d3.event.translate,
        t = [t2[0]-t1[0], t2[1]-t1[1]];
    svgGroup
        .attr("transform", "translate(" + t + ")scale(" + scale + ")");
    rectGroup
        .attr("transform", "translate(" + t + ")scale(" + scale + ")");
	
	
	
}




//Required for circuits view
var processedGraph = {};

function preProcessGraph(network) {
    var nodes = network.nodes;
    var links = network.links;
    for (var i = 0; i < links.length; i++) {
        var src = nodes[links[i].source];
        var target = nodes[links[i].target];
        if (processedGraph[src.name] && !has(processedGraph[src.name], target.name)) {
            processedGraph[src.name].push(target.name);
        } else {
            processedGraph[src.name] = [target.name];
        }

        if (processedGraph[target.name] && !has(processedGraph[target.name], src.name)) {
            processedGraph[target.name].push(src.name);
        } else {
            processedGraph[target.name] = [src.name];
        }
    }

    console.log(processedGraph);

}

function findAllPaths(graph, start, end) {
    var q = [];
    var temp_path = [start];
    var paths = [];
    q.push(temp_path);

    while (0 != q.length) {
        tmp_path = q.shift();
        var last_node = tmp_path[tmp_path.length - 1];
        if (last_node == end) {
            paths.push(tmp_path);
        }
        for (var i = 0; i < graph[last_node].length; i++) {
            var link_node = graph[last_node][i];
            if (!has(tmp_path, link_node)) {
                new_path = tmp_path.slice(0);
                new_path.push(link_node);
                q.push(new_path);
            }
        }
    }

    return paths;
}

function has(array, item) {
    for (var i = 0; i < array.length; i++)
        if (item == array[i])
            return true;
    return false;
}


/**

{
        "circuitName":"IMBCIN1SS01-04010401",
        "sourceSite":"IMLEUSOH101", 
        "destinationSite":"IMLEUSOH007",
        "circuitSize":"OC-3", 
        "circuitType":"STS-3c",
        "circuitStatus":"active", 
        "sourceAddress":"GIS 2nd floor,8700 Governors Hill, Cincinnati, OH 45249",
        "destinationAddress":"AT&T POP - Cincinnati, 358 Gest St, 2nd Floor, Cincinnati, OH 45249",
        "biDirectional":"Yes",
        "ituWavelength":"ITU 21 (&lambda;1560.61)",
        "protection":"UPSR"
    }

*/

function highlightPaths(circuitData) {
        clearLinksInfo();
        console.log(circuitData);
        var start = circuitData.sourceSite;
        var end = circuitData.destinationSite;
        var paths = findAllPaths(processedGraph, start, end);
        // many paths
        console.log(paths);

        //crude way of sorting an array. But it's OK for Demo! :)
        /*for(var i = 0;i < paths.length;i++) {
		for(var j = 0; j< paths.length; j ++){
			if(paths[i].length < paths[j].length){
				var t = paths[i];
				paths[i] = paths[j];
				paths[j] = t;
			}	
		}
	}*/

        //create a red thin line between src and destination
        createNewPath(start, end, circuitData.circuitSize);

        console.log(paths);
        var applyCss = 'selectedGreenLink';
        for (var i = 0; i < paths.length; i++) {
            var path = paths[i];
            //traverse through first path..
            for (var j = 0; j < path.length; j++) {
                if (j < path.length) {
                    highlightPath(path[j], path[j + 1], applyCss);
                }
            }
            //for unprotected show only shortest path.
            if (circuitData.protection.indexOf('unprotected') != -1) {
                break;
            } else {
                applyCss = 'selectedYellowLink';
            }


            //for protected show all paths,


        }

    } //highlight ends


function highlightPath(node1, node2, css) {
    selection = d3.selectAll('.linkPath')
        .filter(function(data, i) {
            return (data.source.name.indexOf(node1) != -1 && data.target.name.indexOf(node2) != -1) || (data.source.name.indexOf(node2) != -1 && data.target.name.indexOf(node1) != -1);
        });


    selection.attr('class', css);


}

function createNewPath(node1, node2, label) {
        var selection = d3.selectAll('.linkPath')
            .filter(function(data, i) {
                return (data.source.name.indexOf(node1) != -1 && data.target.name.indexOf(node2) != -1) || (data.source.name.indexOf(node2) != -1 && data.target.name.indexOf(node1) != -1);
            });

        console.log(selection);
        console.log(selection[0].length);
        //hide all the texts.
        d3.selectAll('text').attr('fill', 'none');
        var newg = rectGroup.append('g').attr('class', 'newg');
        var link;
        if (selection[0].length == 0) {
            //create path...
            link = {
                source: getFullNode(node1),
                target: getFullNode(node2),
            };

            //add new line..
            var src = projection([link.source.y, link.source.x]);
            var tgt = projection([link.target.y, link.target.x]);
            var d = "M" + (src[0] + 10) + "," + (src[1] + 10) + "L" + (tgt[0] - 10) + "," + (tgt[1] - 10);
            console.log(src + "<<<>>>>" + tgt);

            newg.append("path")
                .attr("d", d)
                .attr('class', 'newPath selectedRedLink');




        } else {
            link = selection.data()[0];
            selection.attr('class', 'selectedRedLink');
        }

        //add new line..
        var src = projection([link.source.y, link.source.x]);
        var tgt = projection([link.target.y, link.target.x]);
        newg.append('text')
            .attr("transform", "translate(" + [src[0], src[1]] + ")")
            .style('font-size', '8px')
            .attr('text-anchor', 'middle')
            .attr('dy', 20)
            .text(link.source.name);

        newg.append('text')
            .attr("transform", "translate(" + [tgt[0], tgt[1]] + ")")
            .style('font-size', '8px')
            .attr('text-anchor', 'middle')
            .attr('dy', 20)
            .text(link.target.name);

        var dx = (tgt[0] + src[0]) / 2,
            dy = (tgt[1] + src[1]) / 2;
        var textCoord = "translate(" + [dx + 2, dy - 2] + ")";

        newg.append('text')
            .attr('class', 'linkText')
            .attr("transform", textCoord)
            .attr('text-anchor', 'start')
            .attr('dx', 10)
            .style('fill', 'black')
            .text(label);

    } //create new path ends.


function getFullNode(name) {
	
    for (var i = 0; i < network.nodes.length; i++)
        if (network.nodes[i].name.indexOf(name) != -1)
            return network.nodes[i];

    return {
        name: name,
        x: 0,
        y: 0
    };
}