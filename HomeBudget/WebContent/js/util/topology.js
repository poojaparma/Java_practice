var width = 800,
    height = 600;

var initialScale = 1070;

//Projection [lat/lng] = [x/y]
var projection = d3.geo.albersUsa()
    .scale(initialScale)
    .translate([width / 2, height / 2]);

var path = d3.geo.path()
    .projection(projection);

var zoom = d3.behavior.zoom()
    .scaleExtent([1, 10])
    .center([width / 2, height / 2])
    .on("zoom", svgZoom);

var svg = d3.select("#svgSection").append("svg")
    .attr("viewBox", "0 0 " + width + " " + height)
    .attr("preserveAspectRatio", "xMidYMid meet");

var svgGroup = svg.append("g")
var rectGroup = svg.append('g').attr('class', 'rectgroup');

//Icon height width
var nodeIconWidth = 25;
var nodeIconHeight = 25;
var network;

$(document).ready(function(e) {


    //draw US Map
    d3.json("data/us.json", generateUsMap); //d3.json ends for US Map generation

    //load the network data.
    d3.json("data/node.json", generateNetworkNodes);

    d3.select(self.frameElement).style("height", height + "px");

	//Add zoom functionality on SVG
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



function generateNetworkNodes(error, graph) {
    // Multi Links
    var links = graph.links.slice(0);
    var nodes = graph.nodes.slice(0);
    network = graph;
    preProcessGraph(network);
     
	 
	 //Sorting Links
	 
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
		

    // Compute the distinct nodes from the links.
    links.forEach(function(link) {
        link.source = nodes[link.source] || (nodes[link.source] = {
            name: link.source
        });
        link.target = nodes[link.target] || (nodes[link.target] = {
            name: link.target
        });
    });
	
	//	Draw lines between 2 nodes.
	var lines = rectGroup.append('g').selectAll('.line')
        .data(links).enter().append('svg:path')
        .attr('class', function(d) {return d.type})
		.attr('d', createPath)
	
    	
	//draw nodes
   var nodes= rectGroup.append('g').selectAll('.node').data(graph.nodes);
   nodes.enter().append('svg:image')
        .attr('class', 'node')
        .attr("transform", function(d) {
            var axes = projection([d.y, d.x]);
            return "translate(" + [axes[0] - nodeIconWidth / 2, axes[1] - nodeIconHeight / 2] + ")";
        });
		
        nodes.attr('d', path)
        .attr('height', nodeIconHeight)
        .attr('width', nodeIconWidth)
        .attr('xlink:href', function(d) {
            return 'images/' + d.icon + '.png'
        }).attr('id', function(d){return d.name});
		
        nodes.on('mouseover', showNodeInfo)
        .on('mouseout', hideNodeInfo)

	//text next to node.
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

	//alarm node.
	//Note: Check the filter function.
    rectGroup.append('g').selectAll('.alarmNode').data(graph.nodes).enter().append('svg:circle')
        .attr('class', 'alarmNode')
        .filter(function(d) {
            return d.showAlert != undefined;
        })
        .attr("transform", function(d) {
            var axes = projection([d.y, d.x]);
            return "translate(" + [axes[0] - nodeIconWidth / 2 + 4, axes[1] - nodeIconHeight / 2] + ")";
        })
        .attr('d', path)
        .attr('fill', 'red')
        .attr('opacity', 0.5)
        .attr('r', 4)
        .call(blinkTransition, 500, false);


	
	//Data on the link
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

//For creating bink icon on the node, we have to apply recursive transition
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


function svgZoom() {
	var scale = d3.event.scale;
	var translate = d3.event.translate;
	if(scale >1) {
		 projection
         .scale(scale*initialScale);
	}
	//we translate projection as well in order keep the geopath intact
	projection.translate(translate);
	         
    svgGroup
        .attr("transform", "translate(" + translate + ")scale(" + scale + ")");
    rectGroup
        .attr("transform", "translate(" + translate + ")scale(" + scale + ")");
}




function createPath(d) {
    var relativeDistance = 10;
    var src = projection([d.source.y, d.source.x]);
	var tgt = projection([d.target.y, d.target.x]);
	
	if (d.linknum==1) {
		return "M" + (src[0]-5) + "," + src[1] + "L" + (tgt[0]-5) + "," + tgt[1];
	}else{
		return "M" + (src[0]+5) + "," + src[1] + "L" + (tgt[0]+5) + "," + tgt[1];
	}
}

function centerPathText(d) {

    var src = projection([d.source.y, d.source.x]);
    var tgt = projection([d.target.y, d.target.x]);
    var dx = (tgt[0] + src[0]) / 2,
        dy = (tgt[1] + src[1]) / 2;
    return "translate(" + [dx - 10, dy] + ")";
}


function showNodeInfo(d) {
    console.log(d);
    if (d.desc)
        $('#mapDetailSection').html(d.desc);

    var selection = d3.selectAll('.linkPath')
        .filter(function(data, i) {
            console.log(data);
            return data.source.name.indexOf(d.name) != -1 || data.target.name.indexOf(d.name) != -1;
        });
    selection.attr('class', 'selectedlink');

}

function hideNodeInfo(d) {
    $('#mapDetailSection').html("");
    clearLinksInfo();
}

function clearLinksInfo() {
	//newg is the group added to show the Yello/Green lines in the circuit tab
    d3.selectAll('g.newg').remove();
    d3.selectAll('path.selectedGreenLinkCenter').attr('class', 'bluelinkPath');
	d3.selectAll('path.selectedYellowLinkCenter').attr('class', 'bluelinkPath');
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



//Required for circuits view
var processedGraph = {};

function preProcessGraph(network) {
    var nodes = network.nodes.slice(0);
    var links = network.links.slice(0);
	var index = -1;
	    for (var i = 0; i < links.length; i++) {
            if (i != 0 &&
                links[i].source == links[i - 1].source &&
                links[i].target == links[i - 1].target) {
                index = i;
            } 
        }
		
		if(index > 1){
			links.splice(index, 1);	
		}
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

      //  if((start =="IMLEUSOH101") && (end=="IMLEUSGA008")){
	 //		d3.selectAll('path.greenlinkPath').attr('class', 'selectedGreenLinkCenter');
	//		d3.selectAll('path.bluelinkPath').attr('class', 'selectedYellowLinkCenter');
	//	}
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

			console.log('Applying: ' + applyCss);
            //for protected show all paths,


        }

    } //highlight ends


function highlightPath(node1, node2, css) {
	
    selection = d3.selectAll('.linkPath')
        .filter(function(data, i) {
            return (data.source.name.indexOf(node1) != -1 && data.target.name.indexOf(node2) != -1) || (data.source.name.indexOf(node2) != -1 && data.target.name.indexOf(node1) != -1);
        }).attr('class', css);
		
		d3.select('.bluelinkPath')
        .filter(function(data, i) {
            return (data.source.name.indexOf(node1) != -1 && data.target.name.indexOf(node2) != -1) || (data.source.name.indexOf(node2) != -1 && data.target.name.indexOf(node1) != -1);
        }).attr('class', css+'Center');


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

			var src = d3.transform(d3.selectAll('.node').filter(function(d){return d.name.indexOf(node1)!=-1}).attr('transform')).translate;
			var tgt = d3.transform(d3.selectAll('.node').filter(function(d){return d.name.indexOf(node2)!=-1}).attr('transform')).translate;
            //add new line..
			var d = "M" + (tgt[0]) + "," + (tgt[1]+7) + "L" + (src[0]+7) + "," + (src[1]);

            newg.append("path")
                .attr("d", d)
                .attr('class', 'newPath selectedRedLink');
			//<use id="use" xlink:href="#c2" />
			newg.append('use').attr('xlink:href','#'+link.source.name);
			newg.append('use').attr('xlink:href','#'+link.target.name);

        } else {
            link = selection.data()[0];
            selection.attr('class', 'selectedRedLink');
        }

        
        var src = d3.transform(d3.selectAll('.node').filter(function(d){return d.name.indexOf(node1)!=-1}).attr('transform')).translate;
		var tgt = d3.transform(d3.selectAll('.node').filter(function(d){return d.name.indexOf(node2)!=-1}).attr('transform')).translate;

	    newg.append('text')
            .attr("transform", "translate(" + [src[0], src[1]] + ")")
            .style('font-size', '8px')
            .attr('text-anchor', 'middle')
            .attr('dy', 40)
			.attr('dx', 10)
            .text(link.source.name);

        newg.append('text')
            .attr("transform", "translate(" + [tgt[0], tgt[1]] + ")")
            .style('font-size', '8px')
            .attr('text-anchor', 'middle')
            .attr('dy', 40)
			.attr('dx', 10)
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