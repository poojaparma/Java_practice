$(document).ready(function() {
    var grid = $("#grid").kendoGrid({
        dataSource: {
            transport: {
                read: {
                    url: "data/grid.json",
                    dataType: "json"
                }
            },
            pageSize: 10,
        },
        dataBound: iconChange,
        detailInit: detailInit,
        detailTemplate: kendo.template($("#detailTemplate").html()),
        scrollable: false,
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
        }
    }).data("kendoGrid");
    grid.resize(true);

    // Place the Icon	
    function iconChange(e) {
        $('#grid .k-master-row td').each(function() {
            if ($(this).text() == 'ques') {
                $(this).html('<img src="images/ques.png" class="gridIcon" />' + $(this).text());
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
    function detailInit(e) {}


});