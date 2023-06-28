package negocio;

import core.IStrategy;
import dominio.Candidato;
import dominio.Endereco;
import dominio.EntidadeDominio;

public class ValidarEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		
		if(entidade instanceof Candidato) {
			Candidato candidato = (Candidato) entidade;
			
			//verificando estado
			if(candidato.getEndereco().getCidade().getEstado().getDescricao() == null ||
					candidato.getEndereco().getCidade().getEstado().getDescricao().isEmpty()) {
				sb.append("Estado é um campo obrigatorio<br>");
			}
			
			//verificando cidade
			if(candidato.getEndereco().getCidade().getDescricao() == null ||
					candidato.getEndereco().getCidade().getDescricao().isEmpty()) {
				sb.append("Cidade é um campo obrigatório<br>");
			}
			
			//verificando logradouro
			if(candidato.getEndereco().getLogradouro() == null || candidato.getEndereco().getLogradouro().isEmpty()) {
				sb.append("Logradouro é um campo obrigatório<br>");
			}
			
			//verificando numero
			if(candidato.getEndereco().getNumero() == null || candidato.getEndereco().getNumero().isEmpty()) {
				sb.append("Número é um campo obrigatório<br>");
			}
			
			//verificando cep
			if(candidato.getEndereco().getCep()==null || candidato.getEndereco().getCep().isEmpty() ||
					candidato.getEndereco().getCep().length() < 8) {
				sb.append("CEP inválido<br>");
			}
		}
		
		//Teste verificando apenas entidade endereco 
		if(entidade instanceof Endereco) {
			Endereco endereco = (Endereco)entidade;
			if(endereco.getCidade().getEstado().getDescricao()==null ||
					endereco.getCidade().getEstado().getDescricao().isEmpty()) {
				sb.append("Estado é um capo obrigatório de endereco\n");
			}
			
		}
		
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}

}
