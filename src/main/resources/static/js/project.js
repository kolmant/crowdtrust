function aportar(id){
    $.ajax( "http://localhost:8080/donate/"+id )
        .done(function() {
            alert( "Gracias!" );
        }).always(function() {
            alert( "Gracias!" );
        });
}

function showVoucher(id){
    $("#toLoadImage").attr("src", "http://localhost:8080/images/vouchers/"+id+".jpg");
    $('#exampleModal').modal('show');
}