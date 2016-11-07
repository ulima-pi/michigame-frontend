
var celdaOnClick = function(evt){
    console.log(evt.target.id);
};

$(document).ready(function(){
    $(".celda").click(celdaOnClick);
});