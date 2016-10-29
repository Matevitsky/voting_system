var table;
$(document).ready(function () {
   table = $('#lunchTable').DataTable({
        "ajax": {
            "url": "ajax/lunches",
            "dataSrc": ""

        },
        "columns": [
            {
                "data": "restaurantName",
                "title": "Restaurant Name"
            },
            {
                "data": "lunchName",
                "title": "Lunch Name"
            },
            {
                "title": "Vote",
               // "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }],
    });
});


function renderDeleteBtn(data, type, row) {
    if (type == 'display') {

        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(this);">Vote</a>';
    }
    //deleteRow(' + row.id + ')
}

function deleteRow(row) {
    var _tr =$(row).closest('tr');
    var restaurantName = $(_tr).find('td:eq(0)').text();
    var lunchName = $(_tr).find('td:eq(1)').text();
    $.ajax({
        url: '/ajax/lunches',

        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            restaurantName:restaurantName,
            lunchName:lunchName
    }),

        success: function () {

            successNoty('Voted');
        }
    });
}
function enable(checkbox, id) {
    debugger

    var enabled = checkbox.is(":checked");
    checkbox.closest('tr').css("text-decoration", enabled ? "none" : "line-through");
    $(this).closest('tr').find('input[type="checkbox"]').each(function(i, checkbox){
        console.log($(checkbox).val());
    });
   /* $.ajax({
        url: "ajax/lunches/vote" + row.get("LunchName"),
        type: 'POST',
        data: 'enabled=' + enabled,
        success: function () {
            successNoty(enabled ? 'Enabled' : 'Disabled');
        }
    });*/
}
function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}
