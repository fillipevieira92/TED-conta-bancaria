// Pegando todos os forms.
var forms = document.querySelectorAll('form');

// Adicionando EventListener em todos os forms para chamar a funçao de envio de dados.
$(forms).each(function(){
    
    var form = this

    form.addEventListener('submit', (e) =>{
        e.preventDefault(); // Previnindo o submit default.
        sendData(form);     // Enviando o submit via ajax.        
    })

})

// Pesquisando o cpf via ajax no evento keyUp.
$('#cpf_pesquisa').on('keyup', function() {

    var cpfOrigem = document.querySelector('#cpfOrigem').value;
    var data = {'cpf':this.value};

    // Se o tamanho do cpf for maior que 8 e o cpf for diferente do cpf do usuario.
    if (this.value.length > 8 && this.value != cpfOrigem) {

        // Envia o ajax.
        $.ajax({
            type:'POST',
            dataType: 'json',
            url: '/ajaxFindCpf',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(bankAccount) {
                // Se tiver dado no retorno da funçao.
                if (bankAccount.nome != null) {

                    // Alterando os campos com o nome e a conta de destino.
                    $('#conta_destino').val('Conta Destino: '+bankAccount.numConta);
                    $('#nome_destino').val('Nome Destino: '+bankAccount.nome);

                    // Liberando o botão de envio.
                    $('#btn_transfer').prop('hidden', false);

                } else { // Caso nao tenha dados no retorno
                    
                    // Alterando os campos com os valores a seguir.
                    $('#conta_destino').val('Conta Destino: ');
                    $('#nome_destino').val('Nome Destino: ');

                    // Escondendo o botao de envio.
                    $('#btn_transfer').prop('hidden', true);
                }
            }
        })

    // Se o valor do cpf for igual ao cpf do usuário
    } else if (this.value == cpfOrigem) { 
        
        // Criando alerta e texto.
        $('#alert').attr('class', 'row alert alert-danger');
        $('.alert-text').text('Insira um CPF valido!');
    
    } else {
        // Escondendo alerta.
        $('#alert').removeAttr('class');
        $('.alert-text').text('');

        // Alterando os valores dos campos.
        $('#conta_destino').val('Conta Destino: ');
        $('#nome_destino').val('Nome Destino: ');

        // Escondendo o botao.
        $('#btn_transfer').prop('hidden', true);
        
    }
})

// Função de envio de dados via ajax.
function sendData(form) {

    var saldoDisponivel = document.querySelector('#saldoDisponivel').value;

    var url = form.getAttribute('action');          // Dados da url do submit.
    var cpf = form.children[0].children[0].value;   // Dados de cpf de origem.
    var valor = form.children[0].children[2]; // Dados do valor a ser enviado no ajax.
    var cpfDestino = '';

    // Preparando o arquivo de envio.
    var data = {
        'cpf':cpf,
        'valor':valor.value,
    }

    // Se o form for o de transferencia adiciona um novo campo 
    if (form.id == 'form-transferencia'){

        cpfDestino = document.querySelector('#cpf_pesquisa');
        data['cpfDestino'] = cpfDestino.value;

    }
    
    // Checando se o saldo é insuficiente para transaçoes diferente de deposito.
    if (url != '/deposit' && parseFloat(valor.value) > parseFloat(saldoDisponivel)) {
        
        $('#alert').attr('class', 'row alert alert-danger');
        $('.alert-text').text('Saldo insuficiente!');

    } else {
        
        // Preparando o ajax
        $.ajax({
            url:url,
            type:'POST',
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function(bankAccount){
                // Enviando alerta.   
                $('#alert').attr('class', 'row alert alert-success');
                $('.alert-text').text('Transaçao efetuada com sucesso!');

                // Alterando o saldo visivel na tela.
                $('.saldo').each(function(){
                    this.value ='Saldo Disponível: R$'+bankAccount.saldo;                
                })

                // Alterando o saldo float escondido.
                $('#saldoDisponivel').val(bankAccount.saldo);

                // Limpando os campos de entrada.
                valor.value = ''
                cpfDestino.value = ''
                $('#btn_transfer').prop('hidden', true);
                document.querySelector('#nome_destino').value = 'Nome Destino: ';
                document.querySelector('#conta_destino').value = 'Conta Destino: ';

            }
        })
    }

    
}