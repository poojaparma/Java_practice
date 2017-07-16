requirejs.config({
    baseUrl: 'js/',
	path:{
		util:'util/',
		kendo:'kendo/',
		theme:'theme/',
		d3:'d3/'
	}
});

// Start the main app logic.
requirejs(['util/bootstrap.min','util/functions', 'util/tab', 'util/networkTree', 'util/physicalView','util/grid'],function(functions, tab, networkTree, circuitsTree, grid) {
	//console.log(functions.height);
});
