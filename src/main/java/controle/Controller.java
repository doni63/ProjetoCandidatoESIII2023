package controle;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AlterarCommand;
import command.ConsultarCommand;
import command.ExcluirCommand;
import command.SalvarCommand;
import core.IFachada;
import dao.CursoDAO;
import dominio.Candidato;
import dominio.Criptografia;
import dominio.Curso;
import dominio.EntidadeDominio;
import viewHelper.CandidatoVH;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Candidato candidato;
	List<EntidadeDominio> candidatos;
	IFachada fachada = new Fachada();
	String resultado;
	CandidatoVH vh = new CandidatoVH();
	SalvarCommand command = new SalvarCommand();
	ConsultarCommand commandC = new ConsultarCommand();
	AlterarCommand commandA = new AlterarCommand();
	ExcluirCommand commandExcluir = new ExcluirCommand();
	Criptografia criptoCandidato = new Criptografia();
	EntidadeDominio entidade;
	String operacao = null;

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		operacao = request.getServletPath();
		System.out.println(operacao);
		if (operacao.equals("/main")) {
			candidatoList(request, response);

		}

		if (operacao.equals("/salvarCandidato")) {
			try {
				candidato = (Candidato) vh.getEntidade(request);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				resultado = command.execute(candidato);
				System.out.println(resultado);
				request.setAttribute("mensagem", resultado);
				request.getRequestDispatcher("novoCandidato.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (operacao.equals("/excluirCandidato")) {
			try {
				candidato = (Candidato) vh.getEntidade(request);
				response.sendRedirect("excluirCandidato.jsp");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (operacao.equals("/confirmarExcluir")) {
			String operacaox = request.getParameter("operacao");
			System.out.println(operacaox);
			if (operacaox.equals("SIM")) {
				try {
					candidato = (Candidato) vh.getEntidade(request);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					resultado = commandExcluir.execute(candidato);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("CandidatoList").forward(request, response);
		}

		if (operacao.equals("/novoCandidato")) {
			request.getRequestDispatcher("novoCandidato.jsp").forward(request, response);

		}

		if (operacao.equals("/editarCandidato")) {
			try {
				candidato = (Candidato) vh.getEntidade(request);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				resultado = commandA.execute(candidato);
				System.out.println(resultado);
				request.setAttribute("mensagem", resultado);
				request.getRequestDispatcher("editarCandidato.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void candidatoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("candidato.jsp");
	}


	protected void novoCandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("novoCandidato.jsp");
	}

}
