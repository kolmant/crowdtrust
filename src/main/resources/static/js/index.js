var selected = -1;

function filterByOrganization(id){
    if (selected === id) {
        showAllOrganizations();
        selected = -1;
    } else if (selected !== -1){
        showAllOrganizations();
        showOrganization(id);
    }else{
        showOrganization(id);
    }
}

function showAllOrganizations(){
    $(".project-view").css("display", "block");
}

function showOrganization(id){
    $( ".project-view" ).not( "#"+id ).css( "display", "none" );
    $( ".project-view #"+id ).css( "display", "block" );
    selected = id;
}