$(document).ready(function() {
    var hSplitter = $("#treeSplitter").kendoSplitter({
        // orientation: "horizontal",
        panes: [{
            collapsible: true,
            size: "30%",
            resizable: true
        }, {
            collapsible: true,
            size: "70%",
            resizable: true
        }]
    }).data("kendoSplitter");

    var vSplitter = $("#splitter").kendoSplitter({
        orientation: "vertical",
        panes: [{
            collapsible: true,
            size: "20%",
            resizable: true
        }, {
            collapsible: true,
            size: "40%",
            resizable: true
        }, {
            collapsible: true,
            size: "40%",
            resizable: true
        }]
    }).data("kendoSplitter");

    hSplitter.resize(true);
    vSplitter.resize(true);
});