package controle;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RNF.CriptografarEntidade;
import core.IDAO;
import core.IFachada;
import core.IStrategy;
import dao.CandidatoDAO;
import dao.CriptoDAO;
import dao.EnderecoDAO;
import dominio.Candidato;
import dominio.Criptografia;
import dominio.EntidadeDominio;
import negocio.ValidarCandidato;
import negocio.ValidarCriptografia;
import negocio.ValidarCurso;
import negocio.ValidarDataCadastro;
import negocio.ValidarEndereco;
import negocio.ValidarFiliacao;
import negocio.ValidarTelefone;

public class Fachada implements IFachada {
	// instanciando RNS
	ValidarCandidato validarCandidato = new ValidarCandidato();
	ValidarCurso validarCurso = new ValidarCurso();
	ValidarEndereco validarEndereco = new ValidarEndereco();
	ValidarFiliacao validarFiliacao = new ValidarFiliacao();
	ValidarTelefone validarTelefone = new ValidarTelefone();
	ValidarCriptografia validarCripto = new ValidarCriptografia();
	ValidarDataCadastro validarDataCadastro = new ValidarDataCadastro();

	@Override
	public String salvar(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception {
		StringBuilder sb = new StringBuilder();

		System.out.println("Passando pela fachada");
		if (entidade instanceof Criptografia) {
			IDAO dao = new CriptoDAO();
			dao.salvar(entidade);
		}

		if (entidade instanceof Candidato) {
			// executando metodo processar das strategys passando entidade Candidato
			validaNull(sb, validarCandidato.processar(entidade));
			validaNull(sb, validarCurso.processar(entidade));
			validaNull(sb, validarEndereco.processar(entidade));
			validaNull(sb, validarFiliacao.processar(entidade));
			validaNull(sb, validarTelefone.processar(entidade));
			validaNull(sb, validarCripto.processar(entidade));

			if (sb.length() == 0) {
				// criptoEnt.criptografarObjeto(entidade);
				IDAO dao = new CandidatoDAO();

				if (dao.salvar(entidade)) {
					IDAO dao2 = new CriptoDAO();
					dao2.salvar(entidade);
				}

				sb.append("<br>Cliente Salvo com sucesso!<br>");
			}
		}

		return sb.toString();
	}

	@Override
	public String alterar(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception {
		StringBuilder sb = new StringBuilder();
		if(entidade instanceof Candidato) {
			validaNull(sb, validarCandidato.processar(entidade));
			validaNull(sb, validarCurso.processar(entidade));
			validaNull(sb, validarEndereco.processar(entidade));
			validaNull(sb, validarFiliacao.processar(entidade));
			validaNull(sb, validarTelefone.processar(entidade));
			validaNull(sb, validarDataCadastro.processar(entidade));
			validaNull(sb, validarCripto.processar(entidade));
			
			if (sb.length() == 0) {
				IDAO dao = new CandidatoDAO();
				if (dao.alterar(entidade)) {
					IDAO dao2 = new CriptoDAO();
					dao2.alterar(entidade);
					sb.append("<br>Cliente Salvo com sucesso!<br>");
				}
			}

		}
		return sb.toString();
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
	    StringBuilder sb = new StringBuilder();
	    
	    if (entidade instanceof Candidato) {
	        IDAO canDao = new CandidatoDAO();
	        
	        try {
				if (canDao.excluir(entidade)) {
				    sb.append("<br>Cliente excluído com sucesso!<br>");
				} else {
				    sb.append("<br>Erro ao excluir o cliente.<br>");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    return sb.toString();
	}


	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();
		List<EntidadeDominio> listaCandidato  = new ArrayList<EntidadeDominio>();
		System.out.println("Passando pela fachada");

		if (entidade instanceof Candidato) {
			IDAO dao = new  CandidatoDAO();
			CriptografarEntidade cripEnt = new CriptografarEntidade();
			
			listaCandidato = dao.listarEntidade(entidade);
			
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
		}
		return listaCandidato;
	}

	public void validaNull(StringBuilder sb, String msg) {
		if (msg != null) {
			sb.append(msg);
		}

	}

}