$(document).ready(function() {
    $("#menu").kendoMenu({
        animation: {
            close: {
                effects: "slideIn:up"
            }
        },
        dataSource: [{
            text: "Home",
            url: "dashboard.html",
            spriteCssClass: "homeIcon"

        }, {
            text: "Alarms",
            url: "#",
            spriteCssClass: "alarmsIcon"
        }, {
            text: "Circuits",
            url: "#",
            spriteCssClass: "circuitsIcon",
            items: [{
                text: "Capacitive Circuit"
            }, {
                text: "Bandwidth"
            }]
        }, {
            text: "Raise a Request",
            url: "#",
            spriteCssClass: "requestIcon"
        }, {
            text: "Reports",
            url: "#",
            //spriteCssClass: "requestIcon"  
        }]
    });
});