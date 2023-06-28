package dominio;

public class Endereco extends EntidadeDominio{
	private String logradouro;
	private String numero;
	private String cep;
	private Cidade cidade;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	/*public String validarEndereco() {
		StringBuilder sb = new StringBuilder();
		if(logradouro == null || logradouro.isEmpty()) {
			sb.append("Campo logradouro é obrigatório\n");
		}
		
		if(numero == null || numero.isEmpty()) {
			sb.append("Campo número é obrigatório\n");
		}
		
		if(cep == null || cep.isEmpty()) {
			sb.append("Cep é obrigatório\n");
		}
		
		if(cidade.getEstado().getDescricao() == null || cidade.getEstado().getDescricao().isEmpty()) {
			sb.append("Campo estado é obrigatório\n");
		}
		
		if(cidade.getDescricao() == null || cidade.getDescricao().isEmpty()) {
			sb.append("Campo Cidade é obrigatório\n");
		}
		
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}*/
}
