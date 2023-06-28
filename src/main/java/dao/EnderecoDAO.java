package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import core.IDAO;
import dominio.Candidato;
import dominio.Endereco;
import dominio.EntidadeDominio;

public class EnderecoDAO implements IDAO {
	private Connection connection;
	private boolean ctrlTransacao = true;
	
	public EnderecoDAO() {}
	
	public EnderecoDAO(Connection connection) {
		this.connection = connection;
	}
	@Override
	public boolean salvar(EntidadeDominio entidade) {
		boolean status = false;
		PreparedStatement pst = null;
		Endereco end = (Endereco) entidade;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into enderecos(end_logradouro, end_numero, end_cep, ");
		sql.append("end_cidade, end_estado) values(?,?,?,?,?)");
		
		try {
			if(connection == null) {
				connection = Conexao.getConnectionMySQL();
			}else {
				ctrlTransacao = false;
			}
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getLogradouro());
			pst.setString(2, end.getNumero());
			pst.setString(3, end.getCep());
			pst.setString(4, end.getCidade().getDescricao());
			pst.setString(5, end.getCidade().getEstado().getDescricao());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd = 0;
			if(rs.next()) {
				idEnd = rs.getInt(1);
			}
			end.setId(idEnd);
			connection.commit();
			status = true;
		} catch (Exception e) {
			try {
				connection.rollback();
				status = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public List<EntidadeDominio> listarEntidade(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterar(EntidadeDominio entidade) {
		boolean status = false;
		PreparedStatement pst = null;
		Endereco end = (Endereco) entidade;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("update enderecos set end_logradouro=?, end_numero=?, end_cep=?, ");
		sql.append("end_cidade = ?, end_estado = ? where end_id = ?");
		
		try {
			if(connection == null) {
				connection = Conexao.getConnectionMySQL();
			}else {
				ctrlTransacao = false;
			}
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getLogradouro());
			pst.setString(2, end.getNumero());
			pst.setString(3, end.getCep());
			pst.setString(4, end.getCidade().getDescricao());
			pst.setString(5, end.getCidade().getEstado().getDescricao());
			pst.setInt(6, end.getId());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd = 0;
			if(rs.next()) {
				idEnd = rs.getInt(1);
			}
			end.setId(idEnd);
			connection.commit();
			status = true;
		} catch (Exception e) {
			try {
				connection.rollback();
				status = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public boolean excluir(EntidadeDominio entidade) throws ClassNotFoundException {
	    String sql = "DELETE FROM Enderecos WHERE end_id = ?";
	    Candidato end = (Candidato) entidade;
	    try {
	    	connection = Conexao.getConnectionMySQL();
	    	PreparedStatement pst = connection.prepareStatement(sql); 
	        pst.setInt(1, end.getEndereco().getId());
	        pst.executeUpdate();
	        pst.close();
	        return true;
	    } catch (SQLException e) {
	        System.out.println("Erro ao delatar endereço " + e);
	        return false;
	    }
	}


}
