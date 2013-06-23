jQuery(function($){
   $(".data").mask("99/99/9999");
   $(".fone").mask("(99)9999-9999");
   $(".cpf").mask("999.999.999-99");
   $(".cep").mask("99999-999");
});


function deletar(idTexto){
	var divID = idTexto;				
	jQuery('#'+divID+'_rows').html('<td colspan="3" style="text-align:right; background:#FFEBE8; padding:5px 10px">Tem ceteza que deseja excluir o aluno <a class=\"sure\" href=\"javascript:void(0)\" rel=\"ok\">OK | </a> <a class=\"sure\" href=\"javascript:void(0)\" rel=\"cancelar\">Cancelar</a></td>');			
	jQuery('a.sure' ).click(function(){
	var decision = jQuery(this).attr('rel');
		if( decision === "ok"){
			jQuery('#'+divID+'_rows').css('background','#FFEBE8'); 		
			jQuery.ajax({
			  type: 'GET',
			  url:  '/servletsPOO/DeletaAluno',
			  data:  {idAluno:idTexto},
			  success: function(results) {
				  console.log(results);
				  if(results == true){
					  jQuery('#msg').html('<div class=\"alert alert-success\">Aluno excluído com sucesso<a class=\"close\" data-dismiss=\"alert\" href=\"#\">&times;</a></div>');
					  jQuery('#'+divID).remove();
					  jQuery('#'+divID+'_rows').html('');
				  } else {
					  jQuery('#'+divID+'_rows').html('');
					  jQuery('#msg').html('<div class=\"alert alert-error\">Erro ao excluir aluno<a class=\"close\" data-dismiss=\"alert\" href=\"#\">&times;</a></div>');
				  }
			  }
			  
			});
		} else {
			jQuery('#'+divID+'_rows').html('');
		}
	});
	return false;
}