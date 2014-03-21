$(function() {
    $("#sortable1, #sortable2, #sortable3").sortable({
        connectWith: ".connectedSortable",
        stop: function() {
            if ($("#sortable2").children("li").length === 2 && $("#sortable3").children("li").length === 2) {
                poolA1 = $("#sortable2").children().first().text();
                poolA2 = $("#sortable2").children().last().text();
                poolB1 = $("#sortable3").children().first().text();
                poolB2 = $("#sortable3").children().last().text();
                $.ajax({
                    url: "ResponseServer",
                    //data: JSON.stringify({'A1':poolA1,"A2":poolA2,"B1":poolB1,"B2":poolB2}),
                    data: "A1=" + poolA1 + "&A2=" + poolA2 + "&B1=" + poolB1 + "&B2=" + poolB2,
                    success: function(msg) {
                        alert(msg);
                        $("#test").text("Something happend?");
                    }
                });
            }
        }
    }).disableSelection();
});

//,"A2=" + poolA2,"B1=" +  poolB1,"B2=" +  poolB2