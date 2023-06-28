package negocio;

import core.IStrategy;
import dominio.Candidato;
import dominio.EntidadeDominio;

public class ValidarCandidato implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		
		if(entidade instanceof Candidato) {
			Candidato candidato = (Candidato) entidade;
			
			if(candidato.getNome()==null || candidato.getNome().isEmpty()) {
			sb.append("<br>Nome é um campo obrigatório\n<br>");
			}
			
		}
		
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}

}
