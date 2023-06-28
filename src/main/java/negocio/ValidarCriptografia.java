package negocio;

import RNF.CriptografarEntidade;
import core.IStrategy;
import dominio.Candidato;
import dominio.Criptografia;
import dominio.EntidadeDominio;

public class ValidarCriptografia implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder sb = new StringBuilder();

		if (entidade instanceof Candidato) {
			CriptografarEntidade ent = new CriptografarEntidade();
			try {
				ent.criptografarObjeto((Candidato) entidade);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}

}
