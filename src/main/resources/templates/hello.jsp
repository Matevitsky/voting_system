<!--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    &lt;!&ndash; The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags &ndash;&gt;
    <title>Bootstrap 101 Template</title>

    &lt;!&ndash; Latest compiled and minified JavaScript &ndash;&gt;
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>


    <link rel="stylesheet" type="text/css"
          href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css" />
    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>


    <script type="text/javascript" src="jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

    &lt;!&ndash; Latest compiled and minified CSS &ndash;&gt;
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    &lt;!&ndash; Bootstrap &ndash;&gt;




    &lt;!&ndash; HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries &ndash;&gt;
    &lt;!&ndash; WARNING: Respond.js doesn't work if you view the page via file:// &ndash;&gt;
    &lt;!&ndash;[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]&ndash;&gt;
</head>
<body>
<p><br/><br/></p>
<div class="container">
    <table id="datatable" class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>name</th>
            <th>password</th>
            <th>email</th>
            <th>roles</th>
            <th>enabled</th>
        </tr>
        </thead>

        <tbody></tbody>
    </table>

</div>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<script>
    $(function(){
        $("#datatable").dataTable();
    })
</script>

&lt;!&ndash;<script>
    var ajaxUrl = "/api/users";
    $(document).ready(function(){

        jQuery.support.cors = true;

        $.ajax(
                {
                    type: "GET",
                    url: ajaxUrl,

                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    cache: false,
                    success: function (data) {

                        var trHTML = '';

                        $.each(data.name, function (i, item) {

                            trHTML += '<tr><td>' + data.name[i] + '</td><td>' + data.password[i] + '</td></tr>' + data.email[i] + '</td><td>'
                                    + data.roles[i] + '</td><td>' + data.enabled[i] + '</td><td>';
                        });

                        $('#datatable').append(trHTML);

                    },

                    error: function (msg) {

                      print(alert(msg.responseText));
                    }
                });
    })
</script>&ndash;&gt;

&lt;!&ndash; Latest compiled and minified JavaScript &ndash;&gt;
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
&lt;!&ndash; jQuery (necessary for Bootstrap's JavaScript plugins) &ndash;&gt;
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
&lt;!&ndash; Include all compiled plugins (below), or include individual files as needed &ndash;&gt;
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>



</body>
</html>
-->
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<table id="example">
    <thead>
    <tr>
        <th class="site_name">Название</th>
        <th>Адрес</th>
        <th>Тип</th>
        <th>Последние изменения</th>
    </tr>
    </thead>


</table>

<script>
    $("#example").dataTable({
        "bServerSide": true,
        "sAjaxSource": "http://demo.htmlhook.ru/javascript/data-tables/data_source.json",
        "aoColumns": [{
            "mData":"name",
            "sTitle": "Название сайта"
        },{
            "mData": "url",
            "mRender": function ( url, type, full )  {
                return  '<a href="'+url+'">' + url + '</a>';
            }
        },{
            "mData": "editor.name"
        },{
            "mData": "editor.phone"
        },{
            "mData":"editor",
            "mRender": function(data){
                return data.email.join("<br>");
            }
        }]
    });

</script>
</body>
</html>
