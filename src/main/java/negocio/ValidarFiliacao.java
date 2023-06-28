package negocio;

import core.IStrategy;
import dominio.Candidato;
import dominio.EntidadeDominio;
import dominio.Filiacao;

public class ValidarFiliacao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		Candidato candidato = (Candidato) entidade;
		
		//obrigatório cadastrar nome da mae
		if(candidato.getFiliacao().getMae() == null ||
					candidato.getFiliacao().getMae().isEmpty()) {
				sb.append("Obrigatório cadastrar nome da mãe<br>");
		}
		
		if(candidato.getFiliacao().getPai() == null ||
				candidato.getFiliacao().getPai().isEmpty()) {
			candidato.getFiliacao().setPai("Desconhecido");
	}

		if(sb.length()>0) {
			return sb.toString();
		}else {
			return null;
		}
	}

}
