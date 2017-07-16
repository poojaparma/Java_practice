$(document).ready(function(e) {
    
});
function createInnerAGrid()
{
	var grid = $("#innercircuitsAGrid").kendoGrid({
        dataSource: {
            transport: {
                read: {
                    url: "data/circuitsGrid.json",
                    dataType: "json"
                }
            },
            pageSize: 10,
			filter: [
				{ field: "ring", operator: "eq", value: "ringA" }
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
        navigatable: true,
        pageable: {
            input: true,
            numeric: true
        },
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
   // grid.resize(true);

    // Place the Icon	
    function iconChange(e) {
        $('#innercircuitsAGrid .k-master-row td').each(function() {
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

function createInnerBGrid()
{
	var grid = $("#innercircuitsBGrid").kendoGrid({
        dataSource: {
            transport: {
                read: {
                    url: "data/circuitsGrid.json",
                    dataType: "json"
                }
            },
            pageSize: 10,
			filter: [
				{ field: "ring", operator: "eq", value: "ringB" }
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
        navigatable: true,
        pageable: {
            input: true,
            numeric: true
        },
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
   // grid.resize(true);

    // Place the Icon	
    function iconChange(e) {
        $('#innercircuitsBGrid .k-master-row td').each(function() {
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