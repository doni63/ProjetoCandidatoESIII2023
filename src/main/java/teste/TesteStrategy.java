package teste;

import core.IStrategy;
import dominio.Candidato;
import dominio.Cidade;
import dominio.Curso;
import dominio.Endereco;
import dominio.Estado;
import dominio.Filiacao;
import dominio.Telefone;
import negocio.ValidarEndereco;
import negocio.ValidarFiliacao;
import negocio.ValidarTelefone;

public class TesteStrategy {

	public static void main(String[] args) {
		
		
		Candidato candidato = new Candidato();
		Estado estado = new Estado();
		Cidade cid = new Cidade();
		Endereco end = new Endereco();
		Telefone tel = new Telefone();
		Filiacao fil = new Filiacao();
		Curso c1 = new Curso(2);
		Curso c2 = new Curso(5);
		Curso c3 = new Curso(3);
		
		candidato.setNome("Paulo");
		
		//estado.setDescricao("RM");
		cid.setEstado(estado);
		cid.setDescricao("Maua");
		end.setCidade(cid);
		end.setLogradouro("Americo Vespucio");
		end.setNumero("1100");
		end.setCep("12345678");
		
		candidato.setCursos(c1);
		candidato.setCursos(c2);
		candidato.setCursos(c3);
		
		tel.setCelular("123456789");
		tel.setRecado("987654321");
		tel.setRecado("74185296");
		candidato.setTelefone(tel);
		
		//fil.setPai("Adalberto");
		fil.setMae("Marta");
		candidato.setFiliacao(fil);
		
		//Testando validarCandidato
		//IStrategy strategy = new ValidarCandidato();
		//System.out.println(strategy.processar(candidato));
		
		//Testando validarEndereco
		IStrategy strategy = new ValidarEndereco();
		//System.out.println(strategy.processar(end));
		
		//testando quantidade curso
		//IStrategy strategy = new ValidarCurso();
		//System.out.println(strategy.processar(candidato));
		
		//Testando validarTelefone
		//IStrategy strategy = new ValidarTelefone();
		//System.err.println(strategy.processar(candidato));
		
		//testando validarFilicacao
		//IStrategy strategy = new ValidarFiliacao();
		//System.out.println(strategy.processar(candidato));
	
	}

}
