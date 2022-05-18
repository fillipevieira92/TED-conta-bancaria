var forms = document.querySelectorAll('form');

$(forms).each(function(){
    var form = this
    form.addEventListener('submit', (e) =>{
        e.preventDefault();
        sendData(form);        
    })
})

function sendData(form) {

    var url = form.getAttribute('action');
    var cpf = form.children[0].children[0].value;
    var valor = form.children[0].children[2].value;
    
    var data = {
        'cpf':cpf,
        'valor':valor,
    }

    if (form.id == 'form-transferencia'){

        var cpfDestino = document.querySelector('#cpf-pesquisa').value;
        data['cpfDestino'] = cpfDestino;

    }

    // Preparar o ajax
    $.ajax({
        url:url,
        type:'POST',
        dataType: 'json',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function(data){
            console.log(data);
            $('.saldo').each(function(){
                this.value ='R$: '+data.saldo;
            })            
        }
    })
}