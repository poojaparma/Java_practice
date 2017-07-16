 $(document).ready(function () {
                  //  var crudServiceBaseUrl = "http://demos.telerik.com/kendo-ui/service",
                        dataSource = new kendo.data.DataSource({
                            transport: {
                                read:  {
                                    url: "data/alarmsGrid.json",
                    dataType: "json"
                                },
                                update: {
                                   url: "data/alarmsGrid.json",
                    dataType: "json"
                                },
                                destroy: {
                                  url: "data/alarmsGrid.json",
                    dataType: "json"
                                },
                                create: {
                                  url: "data/alarmsGrid.json",
                    dataType: "json"
                                },
                                parameterMap: function(options, operation) {
                                    if (operation !== "read" && options.models) {
                                        return {models: kendo.stringify(options.models)};
                                    }
                                }
                            },
                            batch: true,
                            pageSize: 20,
                            schema: {
                                model: {
                                    id: "dateI",
                                    fields: {
                                        dateI: { editable: true, nullable: false },
                                        DailyExpenditure: {  validation: { required: true } },
                                        MedicalExpenses: { type: "number", validation: { required: true, min: 1} },
                                        KidExpenses: {type: "boolean" },
                                        TravellingExpenses: { type: "number", validation: { min: 0, required: true } }
                                    }
                                }
                            }
                        });



$(document).ready(function() {
    var grid = $("#alarmsGrid").kendoGrid({
        dataSource: dataSource,
            pageSize: 10,
        
		toolbar: ["create"],
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
				"field":"dateI",
				"title":"Date"
			},
			{
				"field":"DailyExpenditure",
				"title":"DailyExpenditure"
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
				"field":"BillPayments",
				"title":"Bill Payments"
			},
			{
				"field":"RentEmi",
				"title":"Rent EMI"
			},
			{
				"field":"cosmeticsItems",
				"title":"cosmetics"
			},
			{
				"field":"OfficeExpenses",
				"title":"Office Expenses"
			},
			 { command: ["edit", "destroy"], title: "&nbsp;", width: "250px" }
		],
		editable: "popup"
		 
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
 });
/* function netwrokTreeRowSelect(subNodesArray){
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
			
		}*/
		
		/*filtering = true;
			 var filter = {
				logic: "and",
				filters: []
			};  
        	filter.filters.push(
            	{ field: "sourceId", operator: "eq", value: subNodesArray[i]  }
        	);
			 grids.dataSource.filter([filter]); */
		
//	}
	//grids.dataSource.filter({});
//} 
