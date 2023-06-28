package teste;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import RNF.CriptografarEntidade;
import controle.Fachada;
import core.IFachada;
import dao.CandidatoDAO;
import dominio.Candidato;
import dominio.Cidade;
import dominio.Criptografia;
import dominio.Curso;
import dominio.Endereco;
import dominio.Estado;
import dominio.Filiacao;
import dominio.Telefone;

public class TesteFachada {
	public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
		Candidato can = new Candidato();
		Endereco end = new Endereco();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Filiacao filiacao = new Filiacao();
		Telefone tel = new Telefone();
		CandidatoDAO candidatoDao = new CandidatoDAO();
		Criptografia crip = new Criptografia();
		
		estado.setDescricao("BA");
		cidade.setEstado(estado);
		cidade.setDescricao("Salvador");
		end.setCidade(cidade);
		end.setLogradouro("Rua sete");
		end.setNumero("4561");
		end.setCep("12365498");
		
		can.setNome("Douglas");
		can.setDataCadastro(new Date());
		
		tel.setCelular("11987464578");
		tel.setResidencial("1146445484");
		tel.setRecado("4445612354");
		
		filiacao.setPai("Roberto Batista");
		filiacao.setMae("Helena Batista");
		
		
		Curso c1 = new Curso(2);
		Curso c2 = new Curso(5);
		Curso c3 = new Curso(1);
		Curso c4 = new Curso(3);
		c1.setDescricao("Meu Ovo1");
		c2.setDescricao("Meu Ovo2");
		c3.setDescricao("Meu Ovo3");
	
		crip.setCandidato(can);
		//crip.setChave(cripEnt.gerarChaveCriptografia(can));
		
		can.setCursos(c1);
		can.setCursos(c2);
		can.setCursos(c3);
		//can.setCursos(c4);
		can.setEndereco(end);
		can.setFiliacao(filiacao);
		can.setTelefone(tel);
		
		
		IFachada fachada = new Fachada();
		//System.out.println(fachada.salvar(can));
		System.out.println(fachada.alterar(can));
		//System.out.println(fachada.salvar(crip));
		//System.out.println(can.getFiliacao().getPai());
		//teste entidade curso
		
		//System.out.println(fachada.salvar(c1));
		//CriptografarEntidade c = new CriptografarEntidade();
		
		/*System.out.println("Nome Candidato: " + can.getNome());
		System.out.println("Curso 1: " + can.getCursos().get(0).getDescricao());
		System.out.println("Curso 2: " + can.getCursos().get(1).getDescricao());
		System.out.println("Curso 3: " + can.getCursos().get(2).getDescricao());
		System.out.println("Nome Mae:" + can.getFiliacao().getMae());
		System.out.println("Nome Pai:" + can.getFiliacao().getPai());
		System.out.println("Endereco: " + can.getEndereco().getLogradouro());
		c.criptografarObjeto(can);
		System.out.println("\nNome Candidato: " + can.getNome());
		System.out.println("Curso 1: " + can.getCursos().get(0).getDescricao());
		System.out.println("Curso 2: " + can.getCursos().get(1).getDescricao());
		System.out.println("Curso 3: " + can.getCursos().get(2).getDescricao());
		System.out.println("Nome Mae:" + can.getFiliacao().getMae());
		System.out.println("Nome Pai:" + can.getFiliacao().getPai());
		System.out.println("Endereco: " + can.getEndereco().getLogradouro());
		c.desCriptografarObjeto(can);
		System.out.println("\nNome Candidato: " + can.getNome());
		System.out.println("Curso 1: " + can.getCursos().get(0).getDescricao());
		System.out.println("Curso 2: " + can.getCursos().get(1).getDescricao());
		System.out.println("Curso 3: " + can.getCursos().get(2).getDescricao());
		System.out.println("Nome Mae:" + can.getFiliacao().getMae());
		System.out.println("Nome Pai:" + can.getFiliacao().getPai());
		System.out.println("Endereco: " + can.getEndereco().getLogradouro());*/
		
		
	}

}
