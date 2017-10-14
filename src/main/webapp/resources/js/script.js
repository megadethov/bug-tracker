$(function () {

    let oldVal, newVal, id, field;
    let flag = false;

    $('.edit').keypress(function (e) {
        if (e.which == 13) {
            return false;
        }
    });

    $('.edit').focus(function () {
        oldVal = $(this).text();
        id = $(this).data('id');
        field = $(this).data('name');
    }).blur(function () {
        if (oldVal != newVal)
        newVal = $(this).text();
        flag = true;
    })
});

$('#update').click(function () {

     if(flag) {
         $.ajax({
             url: 'update',
             type: 'GET',
             data: {new_val: newVal, id: id, field: field},
             success: function (res) {
                 console.log(res);
             },
             error: function () {
                 alert('AJAX ERROR !');
             }
         });
         flag = false;
     }
});
