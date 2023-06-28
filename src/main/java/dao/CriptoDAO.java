package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import core.IDAO;
import dominio.Candidato;
import dominio.Criptografia;
import dominio.Endereco;
import dominio.EntidadeDominio;

public class CriptoDAO implements IDAO{
	private Connection connection;
	private boolean ctrlTransacao = true;
	
	public CriptoDAO() {}
	
	public CriptoDAO(Connection connection) {
		this.connection = connection;
	}
	@Override
	public boolean salvar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Candidato crip = (Candidato) entidade;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into chaves(id_aluno, chave) values (?,?)");
		
		try {
			if(connection == null) {
				connection = Conexao.getConnectionMySQL();
			}else {
				ctrlTransacao = false;
			}
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setInt(1, crip.getCrip().getId());
			pst.setString(2, crip.getCrip().getChave());
			
			pst.executeUpdate();
			
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if(ctrlTransacao) {
				try {
					pst.close();
					if(ctrlTransacao)
						connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return true;

	}

	@Override
	public List<EntidadeDominio> listarEntidade(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Candidato crip = (Candidato) entidade;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("update chaves set chave = ? where id_aluno = ?");
		
		try {
			if(connection == null) {
				connection = Conexao.getConnectionMySQL();
			}else {
				ctrlTransacao = false;
			}
			connection.setAutoCommit(true);
			
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			System.out.println(crip.getCrip().getChave());
			
			pst.setString(1, crip.getCrip().getChave());
			System.err.println(crip.getCrip().getChave());
			pst.setInt(2, crip.getId());
			System.err.println(crip.getId());
			pst.executeUpdate();
			
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if(ctrlTransacao) {
				try {
					pst.close();
					if(ctrlTransacao)
						connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return true;

	}

	@Override
	public boolean excluir(EntidadeDominio entidade) throws ClassNotFoundException {
	    // Exclui a criptografia
		Candidato crip = (Candidato) entidade;
	    String sql = "DELETE FROM chaves WHERE id_aluno = ?";
	    try  {
	    	connection = Conexao.getConnectionMySQL();
	    	PreparedStatement pst = connection.prepareStatement(sql);
	        pst.setInt(1,crip.getId());
	        pst.executeUpdate();
	        pst.close();
	        return true;
	    } catch (SQLException e) {
	        System.out.println("Erro ao deletar criptografia " + e);
	        return false;
	    }
	}


}
