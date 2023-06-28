package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.IDAO;
import dominio.Curso;
import dominio.EntidadeDominio;

public class CursoDAO implements IDAO{
	private Connection connection;
	
	public List<Curso> getCursos() throws SQLException, ClassNotFoundException{
		try {
			connection = Conexao.getConnectionMySQL();
			List<Curso> listCurso = new ArrayList<Curso>();
			PreparedStatement pst = connection.prepareStatement("select * from cursos");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Curso tempCurso = new Curso();
				tempCurso.setId(rs.getInt("cur_id"));
				tempCurso.setDescricao(rs.getString("cur_nome"));
				listCurso.add(tempCurso);
				tempCurso = null;
			}
			rs.close();
			pst.close();
			connection.close();
			return listCurso;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public boolean salvar(EntidadeDominio entidade) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> listarEntidade(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
