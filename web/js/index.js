var limpiar = function(){
    $("#usuario").val('');
    $("#password").val('');
};

var loginOnClick = function(evt){
    var req = {
        usuario : $("#usuario").val(),
        password : $("#password").val()
    };
    $.post('http://localhost:4567/usuarios/login', JSON.stringify(req), 
    function(data){
        if (data.msg === ''){
            // Login correcto
            location.href = 'dashboard?usuario=' + data.usuario;
        }else{
            // Login incorrecto
            $('#mensaje_error').css("display", "block");
            $('#mensaje_ok').css("display", "none");
            $('#mensaje_error').html(data.msg);
        }
        console.log(data);
    });
};

var registrarseOnClick = function(evt){
    var req = {
        usuario : $("#usuario").val(),
        password : $("#password").val()
    };
    $.post('http://localhost:4567/usuarios', JSON.stringify(req), function(data){
        console.log(data);
        if (data.msg === ''){
            // Registro correcto
            $('#mensaje_ok').css("display", "block");
            $('#mensaje_error').css("display", "none");
        }else{
            $('#mensaje_error').css("display", "block");
            $('#mensaje_error').html(data.msg);
        }
        limpiar();
    });
};

$(document).ready(function(){
    $('#but_login').click(loginOnClick);
    $('#but_registrarse').click(registrarseOnClick);
});

