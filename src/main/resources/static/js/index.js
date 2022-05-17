// Mascaras para os inputs
$('#cpf-pesquisa').mask('000.000.000-00')
/* $('.valores').mask('R$000000'); */
$('.valores').on('keypress', function(event) {
    return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46 || event.charCode == 13;
})

// Validando se tem algum valor no campo valores, caso nao tenha ele limpa o conteúdo.
$('.valores').on('focusout', function() {
    const valor =  parseFloat(this.value)
    if (isNaN(valor) || valor === 0) {
        this.value = '';
    }    
});

// Navegador
$('li').on('click', function() {
    let id = $(this).attr('id');

    if (!$(this).hasClass('selected')) {
        // Desabilitando o conteudo do antigo selected.
        let oldSelectedID = $('.selected').attr('id');
        $('.'+oldSelectedID).prop('hidden', true)
        
        // Habilitando o conteudo do novo selected
        $('.'+id).prop('hidden', false)
        
        // Apagando a classe do antigo selecionado e adicionando ao novo.
        $('.selected').removeClass('selected');
        $(this).addClass('selected');
    }
})

//Sair
function sair() {
    window.location.href = "/logout"
}

