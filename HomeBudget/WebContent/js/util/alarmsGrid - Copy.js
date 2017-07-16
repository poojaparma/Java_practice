$(document).ready(function() {
    var grid = $("#alarmsGrid").kendoGrid({
        dataSource: {
            transport: {
                read: {
                    url: "data/alarmsGrid.json",
                    dataType: "json"
                }
            },
            pageSize: 10
        },
        dataBound: iconChange,
        detailInit: detailInit,
        detailTemplate: kendo.template($("#alarmsGriddetailTemplate").html()),
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
			"field":"Date",
				"title":"Date"
		},
			{			"field":"Dailyexpenditure",
				"title":"Daliy Expenditure"
			},
			{
				"field":"MedicalExpenses",
				"title":"Medical Expenses"
			},
			{
				"field":"KidExpenses",
				"title":"Kid Expenses"
			},
			{
				"field":"TravellingExpenses",
				"title":"Outing"
			},
			{
				"field":"vehicleExpenses",
				"title":"vehicle Expenses"
			},
			{
				"field":"Billpayments",
				"title":"Bill Payments"
			},
			{
				"field":"Rent",
				"title":"Rent EMI"
			},
			{
				"field":"cosmetics",
				"title":"cosmetics"
			},
			{
				"field":"OfficeExpenses",
				"title":"Office Expenses"
			}
			
				
			
           
		]
    }).data("kendoGrid");
   // grid.resize(true);

     // Place the Icon	
    function iconChange(e) {
        $('#alarmsGrid .k-master-row td').each(function() {
            if ($(this).text() == 'Major') {
                $(this).html('<img src="images/major.png" class="gridIcon" />' + $(this).text());
            } else if ($(this).text() == 'Warning') {
                $(this).html('<img src="images/warning.png" class="gridIcon" />' + $(this).text());
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
    function detailInit(e) {}


});

function netwrokTreeRowSelect(subNodesArray){
	console.log(subNodesArray)
	var grids = $('#alarmsGrid').data('kendoGrid');
	for(var i=0; i<subNodesArray.length;i++){
		//console.log(subNodesArray[i])
		if(subNodesArray[i].indexOf('IM')!=-1){
			grids.dataSource.filter({
				"logic":"and",
				"filters":[
					{ field: "sourceId", operator: "eq", value: subNodesArray[i] }
				]
			});
			
		}
		
		/*filtering = true;
			 var filter = {
				logic: "and",
				filters: []
			};  
        	filter.filters.push(
            	{ field: "sourceId", operator: "eq", value: subNodesArray[i]  }
        	);
			 grids.dataSource.filter([filter]); */
		
	}
	//grids.dataSource.filter({});
}
