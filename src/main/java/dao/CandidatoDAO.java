package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import core.IDAO;
import dominio.Candidato;
import dominio.Cidade;
import dominio.Criptografia;
import dominio.Curso;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Estado;
import dominio.Filiacao;
import dominio.Telefone;

public class CandidatoDAO implements IDAO {
	private Connection connection = null;

	@Override
	public boolean salvar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Candidato candidato = (Candidato) entidade;

		try {
			connection = Conexao.getConnectionMySQL();
			connection.setAutoCommit(false);

			EnderecoDAO enderecoDao = new EnderecoDAO(connection);
			if (enderecoDao.salvar(candidato.getEndereco())) {

			}
			

			StringBuilder sql = new StringBuilder();
			sql.append("insert into candidatos(can_nome, can_pai, can_mae, ");
			sql.append("can_tel_residencial, can_tel_celular, can_tel_recado, can_end_id,");
			sql.append("can_curso1,can_curso2,can_curso3,can_data_cadastro)");
			sql.append("values(?,?,?,?,?,?,?,?,?,?,?)");

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, candidato.getNome());
			pst.setString(2, candidato.getFiliacao().getPai());
			pst.setString(3, candidato.getFiliacao().getMae());
			pst.setString(4, candidato.getTelefone().getResidencial());
			pst.setString(5, candidato.getTelefone().getCelular());
			pst.setString(6, candidato.getTelefone().getRecado());
			pst.setInt(7, candidato.getEndereco().getId());
			for (int i = 0; i < 3; i++) {
				if (i < candidato.getCursos().size()) {
					pst.setInt(8 + i, candidato.getCursos().get(i).getId());
				} else {
					pst.setNull(8 + i, i);
				}
			}
			pst.setDate(11, new Date(candidato.getDataCadastro().getTime()));

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idCan = 0;

			if (rs.next()) {
				idCan = rs.getInt(1);
			}
			candidato.getCrip().setId(idCan);
			;

			if (idCan != 0) {
				connection.commit();
			} else {
				connection.rollback();
			}

		} catch (Exception e) {
			try {
				connection.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return true;

	}

	// read
	public List<EntidadeDominio> listarEntidade(EntidadeDominio entidade) {
		List<EntidadeDominio> candidatos = new ArrayList<>();

		try {
			connection = Conexao.getConnectionMySQL();
			PreparedStatement pst = connection.prepareStatement("SELECT can_id, can_nome, can_pai, can_mae, can_tel_residencial, can_tel_celular, can_tel_recado, can_end_id, can_curso1, can_curso2, can_curso3, can_data_cadastro, chave, end_id, end_logradouro, end_numero, end_cep, end_cidade, end_estado, c.cur_nome, c2.cur_nome, c3.cur_nome, c.cur_id, c2.cur_id, c3.cur_id FROM `candidatos` inner join `chaves` on can_id = id_aluno inner JOIN `enderecos` on end_id = can_end_id inner JOIN `cursos` c on c.cur_id = can_curso1 inner JOIN `cursos` c2 on c2.cur_id = can_curso2 inner JOIN `cursos` c3 on c3.cur_id = can_curso3;");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Estado estado = new Estado();
				estado.setDescricao(rs.getString("end_estado"));

				Cidade cidade = new Cidade();
				cidade.setEstado(estado);
				cidade.setDescricao(rs.getString("end_cidade"));

				Endereco endereco = new Endereco();
				endereco.setCidade(cidade);
				endereco.setLogradouro(rs.getString("end_logradouro"));
				endereco.setNumero(rs.getString("end_numero"));
				endereco.setCep(rs.getString("end_cep"));
				endereco.setId(rs.getInt("end_id"));

				Filiacao filiacao = new Filiacao();
				filiacao.setPai(rs.getString("can_pai"));
				filiacao.setMae(rs.getString("can_mae"));
				// curso
				Curso curso = new Curso();
				Curso curso2 = new Curso();
				Curso curso3 = new Curso();
				curso.setId(rs.getInt("c.cur_id"));
				curso.setDescricao(rs.getString("c.cur_nome"));
				
				curso2.setId(rs.getInt("c2.cur_id"));
				curso2.setDescricao(rs.getString("c2.cur_nome"));
				
				curso3.setId(rs.getInt("c3.cur_id"));
				curso3.setDescricao(rs.getString("c3.cur_nome"));

				// telefone
				Telefone telefone = new Telefone();
				telefone.setResidencial(rs.getString("can_tel_residencial"));
				telefone.setCelular(rs.getString("can_tel_celular"));
				telefone.setRecado(rs.getString("can_tel_recado"));

				// Candidato
				Candidato candidato = new Candidato();
				candidato.setCursos(curso);
				candidato.setCursos(curso2);
				candidato.setCursos(curso3);
				candidato.setId(rs.getInt("can_id"));
				candidato.setNome(rs.getString("can_nome"));
				candidato.setTelefone(telefone);
				candidato.setEndereco(endereco);
				candidato.setFiliacao(filiacao);
				candidato.setDataCadastro(rs.getDate("can_data_cadastro"));
				// criptografia
				Criptografia crip = new Criptografia();
				crip.setChave(rs.getString("chave"));
				candidato.setCrip(crip);

				// populando lista candidatos
				candidatos.add(candidato);

			}
			rs.close();
			pst.close();
			connection.close();
			return candidatos;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean alterar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Candidato candidato = (Candidato) entidade;
		String sqlAlterar = "update candidatos set can_nome=?, can_pai=?, can_mae=?,"
				+ "can_tel_residencial=?, can_tel_celular=?, can_tel_recado=?,"
				+ "can_curso1=?,can_curso2=?,can_curso3=?,can_data_cadastro=? where can_id=?";

		try {
			connection = Conexao.getConnectionMySQL();
			connection.setAutoCommit(false);
			

			EnderecoDAO enderecoDao = new EnderecoDAO(connection);
			if (enderecoDao.alterar(candidato.getEndereco())) {
				
			};
			
			pst = connection.prepareStatement(sqlAlterar, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, candidato.getNome());
			pst.setString(2, candidato.getFiliacao().getPai());
			pst.setString(3, candidato.getFiliacao().getMae());
			pst.setString(4, candidato.getTelefone().getResidencial());
			pst.setString(5, candidato.getTelefone().getCelular());
			pst.setString(6, candidato.getTelefone().getRecado());
			
			for (int i = 0; i < 3; i++) {
				if (i < candidato.getCursos().size()) {
					pst.setInt(7 + i, candidato.getCursos().get(i).getId());
				} else {
					pst.setNull(7 + i, i);
				}
			}
			pst.setDate(10, new Date(candidato.getDataCadastro().getTime()));
			pst.setInt(11, candidato.getId());

			pst.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean excluir(EntidadeDominio entidade) throws ClassNotFoundException {
	    // Exclui as criptografias relacionadas ao candidato
	    CriptoDAO criptoDAO = new CriptoDAO();
	    criptoDAO.excluir(entidade);
	    
	    // Exclui o endereço relacionado ao candidato
	    EnderecoDAO enderecoDAO = new EnderecoDAO();
	    enderecoDAO.excluir(entidade);

	    // Exclui o candidato
	    String sql = "DELETE FROM Candidatos WHERE can_id = ?";
	    try {
	    	connection = Conexao.getConnectionMySQL();
	    	PreparedStatement pst = connection.prepareStatement(sql);
	        pst.setInt(1, entidade.getId());
	        pst.executeUpdate();
	        pst.close();
	        return true;
	    } catch (SQLException e) {
	        System.out.println("Erro ao deletar candidato " + e);
	        return false;
	    }
		
	}



}
