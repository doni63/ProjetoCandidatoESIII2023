package viewHelper;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RNF.CriptografarEntidade;
import dao.CandidatoDAO;
import dominio.Candidato;
import dominio.EntidadeDominio;

/**
 * Servlet implementation class CandidatoList
 */
public class CandidatoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidatoDAO dao = new CandidatoDAO();
	Candidato candidato = new Candidato();
	CriptografarEntidade cripEnt = new CriptografarEntidade();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<EntidadeDominio> listaCandidato = dao.listarEntidade(candidato);
		
		for (int i = 0; i <listaCandidato.size();i++ ) {
			try {
				cripEnt.desCriptografarObjeto(listaCandidato.get(i));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Entrou candidatoList");
		request.setAttribute("candidatos", listaCandidato);
		request.getRequestDispatcher("candidato.jsp").forward(request, response);

	}
		
}
