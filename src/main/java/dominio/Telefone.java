package dominio;

import java.util.ArrayList;
import java.util.List;

public class Telefone {
	private String residencial;
	private String celular;
	private String recado;
	
	public String getResidencial() {
		return residencial;
	}
	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getRecado() {
		return recado;
	}
	public void setRecado(String recado) {
		this.recado = recado;
	}
	
	//RN01 O sistema deve possibilitar associar até três telefones a um candidato, 
	//sendo que cada número de telefone deve ter um tipo: residencial, celular ou contato.
	/*public String validarTelefone() {
		StringBuilder sb = new StringBuilder();
		if((residencial == null || residencial.isEmpty())
				&& (celular == null || celular.isEmpty())
				&& (recado == null || recado.isEmpty())) {
			return ("Pelo menos um número de telefone deve ser informado\n");
		}else {
			return null;
		}	
	}*/
}
