package dominio;

public class Criptografia extends EntidadeDominio {
	private Candidato candidato;
	private String chave;
	
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	
	
	
	
}
