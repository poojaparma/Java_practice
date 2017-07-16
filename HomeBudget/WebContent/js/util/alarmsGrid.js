 $(document).ready(function () {
	 alert("hi");
                   var crudServiceBaseUrl = "http://localhost:8000/BudgetFinale/api/Budget",
				//	var crudServiceBaseUrl = "http://localhost:8000/RestClient/rest/ctc",
                        dataSource = new kendo.data.DataSource({
                            transport: {
                                read:  {
									contentType: "application/json; charset=utf-8",
            type: "GET",
            dataType: "json",
            url: crudServiceBaseUrl+"/getall",
                                 
							
                                },
								
                                update: {
								
									 type: "PUT",
									//   data: JSON.stringify(options),
                                   url: crudServiceBaseUrl+"/put",
								     dataType: "json",
									 contentType: "application/json; charset=utf-8" // content type sent to server"
                    
                                },
                                destroy: {
									type: "DELETE",
                                  url: crudServiceBaseUrl+"/delete"/* function (data) {
									
								   return crudServiceBaseUrl+"/destroy?"+data.models[0].dateI} */,
								  
                    dataType: "json",
					contentType: "application/json; charset=utf-8" // content type sent to server"
                                
								},
                               create: {
								
									 type: "POST",
									//   data: JSON.stringify(options),
                                   url: crudServiceBaseUrl+"/create",
								     dataType: "json",
									 contentType: "application/json; charset=utf-8", // content type sent to server"
                    
                                },
                                parameterMap: function(options, operation) {
                        
								  if (operation !== "read" && options.models) {
if(operation=="destroy"){
	alert(operation);
	return  JSON.stringify(options.models[0].dateI);
}
								  if(operation=='create'){
	
	var result = {};
                  for (var i = 0; i < options.models.length; i++) {
                      var order = options.models[i];
                      for (var member in order) {
                   if(order[member]!=null && order[member]!='undefined'&& order[member]!=''){
					   result[member] = order[member];
                   
				   }
					   
					  }
                  }
				
								
				
				  return JSON.stringify(result);
}                             
							 if(operation=='update' ){
				
					var result = {};
                  for (var i = 0; i < options.models.length; i++) {
                      var order = options.models[i];
                      for (var member in order) {
                   
					   result[member] = order[member];
                      }
                  }
				
				  return kendo.stringify(result);
								}
									
								
								  }
									
								
         return JSON.stringify(options.models); 							
				
				
								
									  
									  

						
							
                                }
                            },
                            batch: true,
							autosync: false,
                            pageSize: 20,
                            schema: {
								type:"json",
                                model: {
                                    id: "dateI",
                                    fields: {
                                        dateI: { editable: true, nullable: false },
                                        DailyExpenditure: {  editable: true, nullable: false },
                                        MedicalExpenses: { editable: true, nullable: false },
                                        KidExpenses: {editable: true, nullable: false },
                                        TravellingExpenses: {editable: true, nullable: false }
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
				"field":"dailyExpenditure",
				"title":"DailyExpenditure"
			},
			{
				"field":"medicalExpenses",
				"title":"Medical Expenses"
			},
			{
				"field":"kidExpenses",
				"title":"Kid Expenses"
			},
			{
				"field":"travellingExpenses",
				"title":"Outing"
			},
			{
				"field":"vehicleExpenses",
				"title":"vehicle Expenses"
			},
			{
				"field":"billPayments",
				"title":"Bill Payments"
			},
			{
				"field":"rentEmi",
				"title":"Rent EMI"
			},
			{
				"field":"cosmeticsItems",
				"title":"cosmetics"
			},
			{
				"field":"officeExpenses",
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
