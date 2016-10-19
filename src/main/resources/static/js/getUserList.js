var table = $('#table').DataTable({

    ajax: {
        url: 'api/users',
        dataSrc: '_embedded.users'
    },
    columns: [

        { data: 'name' },

        { data: 'email' },
        { data: 'roles' },
        { data: 'enabled' }
    ]
});


