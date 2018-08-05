var selected = -1;

function filterByOrganization(id){
    if (selected !== -1) {
        $( "#filter-"+selected ).removeClass( "active" );
    }
    if (selected === id) {
        showAllOrganizations();
        selected = -1;
    } else if (selected !== -1) {
        showAllOrganizations();
        showOrganization(id);
    } else {
        showOrganization(id);
    }
}

function showAllOrganizations(){
    $(".project-view").css("display", "block");
}

function showOrganization(id){
    console.log( $("#organization-"+id).closest(".project-view"));
    $( "#filter-"+id ).addClass( "active" );
    $( ".project-view" ).each(function(index) {
        if ($(this).children("#organization-"+id).length === 0){
            $(this).css( "display", "none" );
        }else{
            $(this).css( "display", "block" );
        }
    });

    selected = id;
}