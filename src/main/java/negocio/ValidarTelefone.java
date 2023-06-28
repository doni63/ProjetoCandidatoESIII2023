package negocio;

import core.IStrategy;
import dominio.Candidato;
import dominio.EntidadeDominio;

public class ValidarTelefone implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		Candidato candidato = (Candidato)entidade;
		
			if(candidato.getTelefone().getResidencial()==null ||
					candidato.getTelefone().getResidencial().isEmpty()) {
				
				if(candidato.getTelefone().getCelular()==null ||
						candidato.getTelefone().getCelular().isEmpty()) {
					
					if(candidato.getTelefone().getRecado()==null ||
							candidato.getTelefone().getRecado().isEmpty()) {
						
						sb.append("É necessário cadastrar pelo menos um telefone<br>");
					}
				}
			}
			
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}

}
