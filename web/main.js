$(function() {
    $("#sortable1, #sortable2, #sortable3").sortable({
        connectWith: ".connectedSortable",
        stop: function(){
            alert('Something will happen here one day, I promise')
        }
    }).disableSelection();
});