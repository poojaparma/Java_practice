var width = 700,
    height = 500;


var zoom = d3.behavior.zoom()
	.scaleExtent([1, 10])
    .center([width / 2, height / 2])
    .on("zoom", zoomed);
	
	
var svg ;
//= d3.select("#svgSection").append("svg")
  //  .attr("viewBox", "0 0 " + width + " " + height);
var svgGroup;//= svg.append("g");

var color = d3.scale.category20();

var boxWidth = 100;
var boxHeight = 100;


var previousScale;
var previousTranslate;
function zoomed() {
	//if(!previousScale || previousScale != d3.event.scale){
	console.log(zoom.scale());
	console.log(zoom.translate());
	svgGroup
	  .attr("transform", "translate(" + d3.event.translate + ")scale(" + d3.event.scale + ")");
	  previousScale = d3.event.scale;
 
 previousTranslate = d3.event.translate;
 
}


// Zoom Button Definition
function zoomBtn(action) {
            var currentZoom = zoom.scale();
            var currentTranslate = zoom.translate();
			
			var scale = currentZoom + (action=='out'?-1:1);
			if(scale == 0){
				scale = 1;
			}
			zoom.scale(scale);
	
	var w = width;
	var h = height;
	
		zoom.translate([w/2,h/2]);

	svgGroup
      .attr("transform",
            "translate(" + w/2 + ", " + h/2 + ") " +
            "scale(" + scale + ") " +
            "translate(" + (-w/2) + ", " + (-h/2) + ")");
	
			
}


function loadRingA(){
	d3.xml("data/physical_view_ring_a.svg", "image/svg+xml", function(xml) {
  	//document.getElementById('svgSection').appendChild(xml.documentElement);
	var documents = xml.documentElement;
  	
	console.log("Bro"+isIE());
	if(isIE()<=9){
		documents =  cloneToDoc(documents)
	}
	
	document.getElementById('svgSection').appendChild(documents);	
	
	
	svg = d3.select("#svgSection").select('svg');
	svgGroup = svg.selectAll('svg > g');
	svg.call(zoom);
});
}


function loadRingB(){
	d3.xml("data/physical_view_ring_b.svg", "image/svg+xml", function(xml) {
  	
	var documents = xml.documentElement;
  	
	console.log("Bro"+isIE());
	if(isIE()<=9){
		documents =  cloneToDoc(documents)
	}
	
	document.getElementById('svgSection').appendChild(documents);	
	
	//document.getElementById('svgSection').appendChild(xml.documentElement);
	svg = d3.select("#svgSection").select('svg');
	svgGroup = svg.selectAll('svg > g');
	svg.call(zoom);
});
}

function isIE () {
  var myNav = navigator.userAgent.toLowerCase();
  return (myNav.indexOf('msie') != -1) ? parseInt(myNav.split('msie')[1]) : false;
}

 function cloneToDoc(node,doc){
      if (!doc) doc=document;
      var clone = doc.createElementNS(node.namespaceURI,node.nodeName);
      for (var i=0,len=node.attributes.length;i<len;++i){
        var a = node.attributes[i];
        if (/^xmlns\b/.test(a.nodeName)) continue; // IE can't create these
        clone.setAttributeNS(a.namespaceURI,a.nodeName,a.nodeValue);
      }
      for (var i=0,len=node.childNodes.length;i<len;++i){
        var c = node.childNodes[i];
        clone.insertBefore(
          c.nodeType==1 ? cloneToDoc(c,doc) : doc.createTextNode(c.nodeValue),
          null
        ); }
      return clone;
    }
