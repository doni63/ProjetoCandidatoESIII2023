package dominio;

import java.sql.SQLException;
import java.util.List;

import dao.CursoDAO;

public class Curso extends EntidadeDominio{
	private String descricao;
	
	
	public Curso(String descricao) {
		this.descricao = descricao;
	}
	
	public Curso(int id) {
		this.id = id;
	}
	
	public Curso() {}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Curso> buscarCurso() throws SQLException, ClassNotFoundException {
		CursoDAO dao = new CursoDAO();
		return dao.getCursos();
		
	}
}
