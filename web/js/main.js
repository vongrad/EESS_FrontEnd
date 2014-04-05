$(function() {
    $("#sortable1, #sortable2, #sortable3").sortable({
        connectWith: ".connectedSortable",
        stop: function() {
//            poolA1 = $("#sortable2").children().first().text();
//            poolA2 = $("#sortable2").children().last().text();
//            poolB1 = $("#sortable3").children().first().text();
//            poolB2 = $("#sortable3").children().last().text();
            $.ajax({
                url: "ResponseServer",
//                data: JSON.stringify({'A1':poolA1,"A2":poolA2,"B1":poolB1,"B2":poolB2})
//                data: "A1=" + poolA1 + "&A2=" + poolA2 + "&B1=" + poolB1 + "&B2=" + poolB2,
                success: doThis()
            });
        }
    }).disableSelection();

    doThis = function() {
        $("#table").find("tr").remove();
        $("#table").append("<tr><h4><th>Student Name</th><th>Primary vote</th><th>Secondary votes</th><th>Happiness</th></h4></tr>");
        poolA1 = $("#sortable2").children().first().text();
        poolA2 = $("#sortable2").children().last().text();
        poolB1 = $("#sortable3").children().first().text();
        poolB2 = $("#sortable3").children().last().text();
        var a = $.get("ResponseServer", function(data) {
            $.each(data, function() {
                var student = this;
                student.points = 0;
                $("#sortable2, #sortable3").find("li").each(function() {
                    var subj = $(this).text();
                    if (subj === student.primary) {
                        student.points += 2;
                    } else if (subj === student.secondary) {
                        student.points += 1;
                    }
                });
                var name = student.name.toString();
                var primary = student.primary.toString();
                var secondary = student.secondary.toString();
                $("#table").append("<tr><td>" + name + "</td><td>" + primary + "</td><td>" + secondary + "</td><td class='sortnr'>" + student.points + "</td></tr>");
            });
            sortStudents();
        });
    };

    sortStudents = function() {
        var rows = $('#table').find('tr').detach();
        
        rows.sort(function(row1, row2) {
            return parseInt($(row1).find(".sortnr").text()) - parseInt($(row2).find(".sortnr").text());
        });
        
        $(rows).each(function() {
            //$(this).find("th:eq(3), td:eq(3)").remove();
            $('#table:last').append($(this));
        });
        
        total = rows.size() - 1;
        unhappy = -1; //cause we do not count the first row in OUR table
        $(rows).each(function() {
            if($(this).find(".sortnr").text() == 0){
                unhappy += 1;
            }
        });
        text = 'Unhappy students: ';
        $('#unhappy-students').text(text + (unhappy / total * 100) + '%');
    };
});