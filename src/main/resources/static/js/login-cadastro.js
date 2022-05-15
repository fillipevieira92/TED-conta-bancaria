$('#cpf').mask('000.000.000-00');

// Checa se todos os campos estao preenchidos.
var nomeConfirm = false;
var cpfConfirm = false;
var senhaConfirm = false;

function validaCampos() {
    // Validando nome
    var nome = document.getElementById('nome').value;
    if (nome.length>10) {
        nomeConfirm = true;
    } else {
        nomeConfirm = false;
    }
    // Validando CPF
    var cpf = document.getElementById('cpf').value;    
    if (cpf.length == 14) {
        cpfConfirm = true;
    } else {
        cpfConfirm = false;
    }

    // Se todos os campos estiverem validados libera o botao de cadastro.
    if (nomeConfirm && cpfConfirm && senhaConfirm) {
        $('button').prop('hidden', false);
    } else {
        $('button').prop('hidden', true);
    }

}


// Valida senhas cadastro.
$('#senha').on('keyup', function() {
    $('#confirmar-senha').val('');
})
function validaSenha () {
    var senha = document.querySelector('#senha');
    var confirmarSenha = document.querySelector('#confirmar-senha');
    
    // Validaçao de tamanho da senha
    if (senha.value.length < 5 && senha.value.length != '') {
        $('#alert-caracteres').prop('hidden', false);
        $('#confirmar-senha').prop('disabled', true).val('');
        senhaConfirm = false
        
    } else {
        console.log('aqui')
        $('#alert-caracteres').prop('hidden', true);
        $(confirmarSenha).prop('disabled', false);
        senhaConfirm = false
        
    }

    // Validaçao de senhas iguais
    if (confirmarSenha.value != '' && confirmarSenha.value != senha.value) {
        $('#alert-senhas-diferentes').prop('hidden', false);
        senhaConfirm = false;
    } else if (confirmarSenha.value.length >= 5 && confirmarSenha.value === senha.value) {
        $('#alert-senhas-diferentes').prop('hidden', true);
        senhaConfirm = true;
    }

    validaCampos()    
}
