$(document).ready(function() {
    createCircuitGrid("ring","circuitsGrid")
});

function createCircuitGrid(ring, gridId){
	var grid = $("#"+gridId).kendoGrid({
        dataSource: {
            transport: {
                read: {
                    url: "data/circuitsGrid.json",
                    dataType: "json"
                }
            },
            pageSize: 10,
						filter: [
				{ field: "ring", operator: "eq", value: ring }
			  ]
        },
        dataBound: iconChange,
        detailInit: detailInit,
        detailTemplate: kendo.template($("#circuitsGriddetailTemplate").html()),
        scrollable: true,
		resizable: true,
		navigatable: true,
		sortable:true,
        filterable: {
            operators: {
                string: {
                    startswith: "Starts with",
                    eq: "Is equal to",
                    neq: "Is not equal to"
                }
            }
        },
		serverFiltering: true,
        navigatable: true,
        pageable: {
            input: true,
            numeric: true
        },
		selectable:"row",
		columns:[
			{
				"field":"circuitName",
				"title":"Circuit Name"
			},
			{
				"field":"sourceSite",
				"title":"Source Site"
			},
			{
				"field":"destinationSite",
				"title":"Destination Site"
			},
			{
				"field":"circuitSize",
				"title":"Circuit Size"
			},
			{
				"field":"circuitType",
				"title":"Circuit Type"
			},
			{
				"field":"circuitStatus",
				"title":"Circuit Status"
			}
		]
    }).data("kendoGrid");
	
	grid.bind('change', selectRow)
   // grid.resize(true);

	function selectRow(e){
		//console.log(e);
		 var selectedRows = this.select();
		var dataItem = this.dataItem(selectedRows[0]);
		alert(dataItem.sourceSite +dataItem.destinationSite);
		if(document.getElementById('topologyIframe')){
			document.getElementById('topologyIframe').contentWindow.showCircuit(dataItem);
		}
	}
    // Place the Icon	
    function iconChange(e) {
        $('#circuitsGrid .k-master-row td').each(function() {
            if ($(this).text() == 'active') {
                $(this).html('<img src="images/active.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'major') {
                $(this).html('<img src="images/major.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'critical') {
                $(this).html('<img src="images/critical.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'info') {
                $(this).html('<img src="images/info.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'close') {
                $(this).html('<img src="images/close.png" class="gridIcon" />' + $(this).text());
            }
        });
		
		}

    // Collapsible method
    function detailInit(e) {
			
	}
}
function circuitsTreeRowSelect(sourceSite, destinationSite, circuitSize, circuitType){

	var grids = $('#circuitsGrid').data('kendoGrid');
	/*
	var ds = grids.dataSource;	
	var view = kendo.data.Query.process(ds.data(), {
                filter: ds.filter(),
                sort: ds.sort()
            })
            .data;
	
	var index = -1;
	// find the index of the matching dataItem
	for (var x = 0; x < view.length; x++) {
		if ((view[x].sourceSite == sourceSite) && (view[x].destinationSite == destinationSite) && (view[x].circuitSize == circuitSize)) {
			index = x;
			break;
		}
		else if(((sourceSite == "IMLEUSGA100") && (destinationSite == "IMLEUSGA008") && (circuitType == "OCHCC")) || ((sourceSite == "IMLEUSOH101") && (destinationSite == "IMLEUSOH007") && (circuitType == "OCHCC")))
		{
			index =0;
		}
		else if(((sourceSite == "IMLEUSGA100") && (destinationSite == "IMLEUSGA008") && (circuitType == "Wave")) || ((sourceSite == "IMLEUSOH101") && (destinationSite == "IMLEUSOH007") && (circuitType == "Wave")))
		{
			index =9;
		}
	}
	
	if (index === -1) {
		return;
	}
	
	
	var page = Math.floor(index / grids.dataSource.pageSize());    
	var targetIndex = index - (page * grids.dataSource.pageSize()) + 1;    
	//page is 1-based index    
	grids.dataSource.page(++page);
	//grid wants a html element. tr:eq(x) by itself searches in the first grid!    
	var row = $("#circuitsGrid").find("tr:eq(" + targetIndex + ")");
	grids.select(row);		
	
*/


	grids.dataSource.filter({
		"logic":"and",
		"filters":[
			{ field: "sourceSite", operator: "eq", value: sourceSite },
			{ field: "destinationSite", operator: "eq", value: destinationSite },
			{ field: "circuitSize", operator: "eq", value: circuitSize },
			{ field: "circuitType", operator: "eq", value: circuitType }
		]
	});
	//grids.dataSource.filter({});

}
function circuitsTreeRingSelect(ring){
	var grids = $('#circuitsGrid').data('kendoGrid');
	console.log(ring)
	if(typeof(ring)!= 'undefined'){
		grids.dataSource.filter({
			"logic":"or",
			"filters":[
				{ field: "parents", operator: "eq", value: ring },
			]
		});
	}else{
		grids.dataSource.filter({});
	}
}

function index(){
	var page = $('#index').html();
}