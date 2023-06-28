package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Candidato extends EntidadeDominio {
	private List <Curso> cursos = new ArrayList <Curso>() ;
	private Filiacao filiacao;
	private Endereco endereco;
	private Telefone telefone;
	private Date dataCadastro;
	private String nome;
	private Criptografia crip;
	
	public Criptografia getCrip() {
		return crip;
	}

	public void setCrip(Criptografia crip) {
		this.crip = crip;
	}

	public Candidato() {
		
	}

	public Candidato(int id, String nome,Telefone can_tel_celular,List<Curso> can_curso1 ) {
		
		this.cursos = can_curso1;
		this.telefone = can_tel_celular;
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setCursos(Curso cursos) {
		if(validarQuantidadeCurso()) {
			this.cursos.add(cursos);
		}
	}
	
	
	public Filiacao getFiliacao() {
		return filiacao;
	}
	
	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	//RN02 Não deve ser considerado uma candidatura a mais do que três cursos
	public boolean validarQuantidadeCurso() {
		if(cursos.size() < 3) {
			return true;
		}else {
			return false;
		}
	}
	
	//RN03 Todo candidato deve ter pelo menos um curso de interesse
	public boolean validarQtdMinima() {
		if(cursos.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//validar dados candidato
	/*public String validarDadosCandidato() {
		StringBuilder sb = new StringBuilder();
		
		if(nome == null || nome.isEmpty()) {
			sb.append("Nome é um campo obrigatório");
		}
		
		if(validarQuantidadeCurso() == false) {
			sb.append("Pode ser cadastrado apenas três cursos\n");
		}
		
		if(validarQtdMinima() == false) {
			sb.append("É necessário indicar pelo menos um curso\n");
		}
		
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}*/
	
	
}
