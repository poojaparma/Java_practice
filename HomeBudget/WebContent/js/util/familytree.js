$(document).ready(function() {
	
    var viewModel = new kendo.data.HierarchicalDataSource({
        transport: {
            read: {
                url: "data/familytree.json",
                dataType: "json"
            }
        },
        schema: {
            model: {
                children: "SubNodes",
            }
        }
    });
	
	var treeview = $("#familytree").kendoTreeView({
        dataSource: viewModel,
        dataTextField: ["Name"],
        loadOnDemand: false,
		expanded: true,
		template: kendo.template($("#familytreeTemplate").html()),
        /*checkboxes: {
            checkChildren: true,
            name: "checkedItems[]"
        },*/
        animation: {
            expand: {
                effects: "fadeIn expandVertical",
                duration: 100
            }
        },
		select:treeSelect
		
    }).data("kendoTreeView");
    treeview.resize(true);
	setTimeout(function(){
		$("#familytree").data("kendoTreeView").expand("li:first");
		$("#familytree").data("kendoTreeView").expand("li:first li:first");
	}, 500);
	
	function treeSelect(k){
		var root = this.dataItem(k.node);
		
		var sourceSite = root.sourceSite;
		var destinationSite = root.destinationSite;
		var protection = root.protection;
		var circuitSize = root.circuitSize;
		if(document.getElementById('familygrid')){
			if(typeof(root.sourceSite) != 'undefined'){
				document.getElementById('topologyIframe').contentWindow.showCircuit(root);
				circuitsTreeRowSelect(root.sourceSite, root.destinationSite, root.circuitSize, root.circuitType);
			}else{
				circuitsTreeRingSelect(root.ring)
			}
			
		}else{
			if(typeof(root.sourceSite) != 'undefined'){
				document.getElementById('topologyIframe').contentWindow.showCircuit(root);
			}
		}
		
	}
	
});

	