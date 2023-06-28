package dominio;

public class Filiacao extends EntidadeDominio {
	private String mae = null;
	private String pai;
	
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	
	//RN05 No registro de fliação o nome da mãe é obrigatório o nome do pai pode ser registrado como DESCONHECIDO
	/*public String validarFiliacao() {
		if(mae == null || mae.isEmpty()) {
			return "Nome da mãe não foi preenchido\n";
		}else {
			return null;
		}
	}*/

}
