package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.ha.authenticator.ClusterSingleSignOn;

import dao.CandidatoDAO;
import dominio.Candidato;
import dominio.Cidade;
import dominio.Curso;
import dominio.Endereco;
import dominio.Estado;
import dominio.Filiacao;
import dominio.Telefone;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException  {
		Candidato can = new Candidato();
		Endereco end = new Endereco();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Filiacao filiacao = new Filiacao();
		Telefone tel = new Telefone();
		CandidatoDAO candidatoDao = new CandidatoDAO();
		
		estado.setDescricao("RS");
		cidade.setEstado(estado);
		cidade.setDescricao("Bem para lá");
		end.setCidade(cidade);
		end.setLogradouro("onde faz frio");
		end.setNumero("-4graus");
		end.setCep("08772000");
		can.setNome("Frozen");
		can.setDataCadastro(new Date());
		
		tel.setResidencial("12365478");
		tel.setCelular("78787878");
		tel.setRecado("88888888");
		
		filiacao.setMae("Rainha do gelo");
		filiacao.setPai("Frio");
		
		can.setTelefone(tel);
		can.setFiliacao(filiacao);
		can.setEndereco(end);
		
		
		Curso curso1 = new Curso("Mat");
		Curso curso2 = new Curso("ADS");
		Curso curso3 = new Curso("Logistica");
		Curso curso4 = new Curso("AGRO");
		
		
		can.setCursos(curso1);
		can.setCursos(curso2);
		can.setCursos(curso3);
		//can.setCursos(curso4);
		//for (int i=0; i< can.getCursos().size();i++) {
		//	System.out.println(can.getCursos().get(i).getDescricao());
		//}

		
		/*Curso c = new Curso();
		List<Curso> blau = null;
		try {
			blau = c.buscarCurso();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i < blau.size();i++) {
			System.out.println("Id:" + blau.get(i).getId());
			System.out.println("Curso: " + blau.get(i).getDescricao());
		}*/
		
		/*List <String> cursosNome = new ArrayList<String>();
		cursosNome.add("ADS");
		cursosNome.add("RH");
		cursosNome.add("Geografia");
		cursosNome.add("Matemática");*/
		
		//can.setCursos(c);

		/*for(int i = 0; i<blau.size();i++) {
			if (cursosNome.contains(blau.get(i).getDescricao())) {
				can.setCursos(blau.get(i));
			}
		}*/
		
			/*if (can.validarQtdMinima()){
				//candidatoDao.salvar(can);
			}else{
				System.out.println("selecione pelo menos 1 curso seu imbecil");
			}*/
		
		
			

	}

}
