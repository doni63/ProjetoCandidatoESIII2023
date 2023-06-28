package viewHelper;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.TrimSpacesOption;

import RNF.CriptografarEntidade;
import dao.CandidatoDAO;
import dominio.Candidato;
import dominio.Cidade;
import dominio.Criptografia;
import dominio.Curso;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Estado;
import dominio.Filiacao;
import dominio.Telefone;

public class CandidatoVH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Candidato candidato = new Candidato();
	CandidatoDAO dao = new CandidatoDAO();
	Criptografia cripcandidato = new Criptografia();
	Filiacao filiacao = new Filiacao();
	Estado estado = new Estado();
	Cidade cidade = new Cidade();
	Endereco endereco = new Endereco();
	Telefone telefone = new Telefone();
	Curso curso1 = new Curso();
	Curso curso2 = new Curso();
	Curso curso3 = new Curso();
	Criptografia crip = new Criptografia();
	CriptografarEntidade cripEnt = null;

	public CandidatoVH() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	

	public EntidadeDominio getEntidade(HttpServletRequest request) throws ParseException {
		// nome candidato
		candidato.setNome(request.getParameter("nomeCandidato"));

		// endereco
		estado.setDescricao(request.getParameter("estado"));
		cidade.setEstado(estado);
		cidade.setDescricao(request.getParameter("cidade"));
		endereco.setCidade(cidade);
		endereco.setLogradouro(request.getParameter("logradouro"));
		endereco.setNumero(request.getParameter("numero"));
		endereco.setCep(request.getParameter("cep"));

		if (request.getParameter("idEndereco") != null) {
			System.out.println(request.getParameter("idEndereco").trim());
			endereco.setId(Integer.parseInt(request.getParameter("idEndereco").trim()));
		}

		candidato.setEndereco(endereco);

		// filiacao
		filiacao.setPai(request.getParameter("nomePai"));
		filiacao.setMae(request.getParameter("nomeMae"));
		candidato.setFiliacao(filiacao);

		// telefone
		telefone.setResidencial(request.getParameter("telefoneResidencial"));
		telefone.setCelular(request.getParameter("celular"));
		telefone.setRecado(request.getParameter("telefoneRecado"));
		candidato.setTelefone(telefone);

		// curs
		if (request.getParameter("CursoInteresse").length()==1) {
			System.out.println((request.getParameter("CursoInteresse")));
			curso1.setId(Integer.parseInt(request.getParameter("CursoInteresse")));
			curso2.setId(Integer.parseInt(request.getParameter("curso2")));
			curso3.setId(Integer.parseInt(request.getParameter("curso3")));
			candidato.setCursos(curso1);
			candidato.setCursos(curso2);
			candidato.setCursos(curso3);			
		}
		System.out.println((request.getParameter("CursoInteresse")));

		if (!(request.getParameter("id") == null)) {
			candidato.setId(Integer.parseInt(request.getParameter("id").trim()));
		}
		

		// data
		if ((request.getParameter("dataCadastro") == null)) {
			candidato.setDataCadastro(new Date());
		} else {
			GregorianCalendar gcCandidato = new GregorianCalendar();

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); // você pode usar outras máscaras
			System.out.println(request.getParameter("dataCadastro")); // 2019-04-01
			Date dataCadastro = sdf1.parse(request.getParameter("dataCadastro"));
			candidato.setDataCadastro(dataCadastro);

		}

		candidato.setCrip(crip);
		System.out.println("Passou pela vh");
		//System.out.println("Curso de interesse" + candidato.getCursos().get(0).getDescricao());
		return candidato;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
