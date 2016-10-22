var lunchTable = $('#lunchTable').DataTable({

    ajax: {

        url: 'api/lunches',
        dataSrc: '_embedded.lunches'
    },
    columns: [


        {
            data: '_links.lunch'
        },
        {

            data: '_links.menu'
        },

    ]
});
/*
$('#lunchTable').DataTable({
    "ajax": {
        "url": "api/lunches",
        "dataSrc": function (json) {
            var return_data = new JSON();
            for (var i = 0; i < json[0].length; i++) {
                return_data.push({
                    'name': json['_embedded.lunches'][i].name,
                    'menu': json['_embedded.lunches'][i].menu,
                    'lunch': json['_embedded.lunches'][i].lunch

                })
                console.log(json[i]);
            }
            return return_data;
        }
    }, columns: [


        {
            data: '_links.lunch'
        },
        {

            data: '_links.menu'
        },

    ]
});*/

$.getJSON("api/lunches", function (json) {
    console.log(json);

});
