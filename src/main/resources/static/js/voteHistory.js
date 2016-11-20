var table;
$(document).ready(function () {

    table = $('#historyTable').DataTable({
        "ajax": {
            "url": "ajax/lunches/history",
            "dataSrc": ""

        },
        "columns": [
            {
                "data": "restaurantName",
                "title": "Restaurant Name"
            },
            {
                "data": "date",
                "title": "Date",

            },
        ],
    });
});


function renderVoteBtn(data, type, row) {
    if (type == 'display') {

        return '<a class="btn btn-xs btn-danger" onclick="vote(this);">Vote</a>';
    }

}

function vote(row) {
    var _tr = $(row).closest('tr');
    var restaurantName = $(_tr).find('td:eq(0)').text();
    var lunchName = $(_tr).find('td:eq(1)').text();
    $.ajax({
        url: '/ajax/lunches',

        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            restaurantName: restaurantName,
            lunchName: lunchName
        }),

        success: function () {

            successNoty('Voted');
        }
    });
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
