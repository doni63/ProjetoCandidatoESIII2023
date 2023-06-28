package viewHelper;

import java.sql.SQLException;
import java.util.List;

import dao.CursoDAO;
import dominio.Curso;

public class CursoList {
	CursoDAO curDao = new CursoDAO();
	Curso curso = new Curso();
	
	public List<Curso> getCursos() throws ClassNotFoundException, SQLException{
		
		List<Curso> listaCurso = curDao.getCursos();
		
		return listaCurso;
	}

}
