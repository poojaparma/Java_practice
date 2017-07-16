$(document).ready(function() {
	
    var viewModel = new kendo.data.HierarchicalDataSource({
        transport: {
            read: {
                url: "data/physicalView.json",
                dataType: "json"
            }
        },
        schema: {
            model: {
                children: "SubNodes",
            }
        }
    });
	
	var treeview = $("#physicalView").kendoTreeView({
        dataSource: viewModel,
        dataTextField: ["Name"],
        loadOnDemand: false,
		expanded: true,
		template: kendo.template($("#physicalViewTemplate").html()),
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
		select:treeSelectPhysical
		
    }).data("kendoTreeView");
    treeview.resize(true);
		// Expand First Element
	setTimeout(function(){
		$("#physicalView").data("kendoTreeView").expand("li:first");
	}, 100);
	
});

	function treeSelectPhysical(k){
	 	var root = this.dataItem(k.node);
		var node = root.Name;
		if(node.indexOf('IM Ring A')!=-1){
			document.getElementById('topologyIframe').src= 'physical_view.html?ring=a';
		}else if(node.indexOf('IM Ring B')!=-1){
			document.getElementById('topologyIframe').src= 'physical_view.html?ring=b';
		}
	}