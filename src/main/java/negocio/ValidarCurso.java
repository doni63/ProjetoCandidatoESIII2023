package negocio;

import java.util.ArrayList;
import java.util.List;

import core.IStrategy;
import dominio.Candidato;
import dominio.Curso;
import dominio.EntidadeDominio;

public class ValidarCurso implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		Candidato candidato = (Candidato)entidade;
		
		//qtd maxima
		
		if(candidato.getCursos().size() > 3) {
				sb.append("Podem ser cadstratos apenas três cursos\n<br>");
		}
		
		//qtd minima
		if(candidato.getCursos().size() < 0 || candidato.getCursos().isEmpty()) {
			sb.append("É obrigatório cadastrar um curso\n<br>");
		}
		
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}

}
