	
    $(document).ready(function(){
    	 $('#logradouro').attr('readonly', true);
         $('#estado').attr('readonly', true);
         $('#cidade').attr('readonly', true);
         $('#bairro').attr('readonly', true);
           
    	$("#getEndereco").click(function(){
                getEndereco($("#cep").val());
                
            }); 
         });

	function getEndereco(cep) {
    if($.trim(cep) != ""){
        $("#loadingCep").html('Pesquisando...');
        $.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+cep, function(){            
            if (resultadoCEP["resultado"] != 0) {
                $("#cidade").val(unescape(resultadoCEP["cidade"]));
                $("#estado").val(unescape(resultadoCEP["uf"]));
                $("#logradouro").val(unescape(resultadoCEP["logradouro"]));
                $("#bairro").val(unescape(resultadoCEP["bairro"]));
                $("#loadingCep").html('');
            }else{
            	$("#loadingCep").html('CEP Não Encontrado!');
            	 $("#cidade").val('');
                 $("#estado").val('');
                 $("#logradouro").val('');
                 $("#bairro").val('');
                //$("#loadingCep").html(unescape(resultadoCEP["resultado_txt"]));                
            }            
        });
    }
    else{
        $("#loadingCep").html('Informe o CEP');
        $("#cidade").val('');
        $("#estado").val('');
        $("#logradouro").val('');
        $("#bairro").val('');
    }
}	
