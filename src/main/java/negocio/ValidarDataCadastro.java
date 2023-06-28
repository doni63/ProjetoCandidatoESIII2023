package negocio;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import core.IStrategy;
import dominio.Candidato;
import dominio.EntidadeDominio;

public class ValidarDataCadastro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception {
		StringBuilder sb = new StringBuilder();
		
		if(entidade instanceof Candidato) {
			
			int anoComparacao;
			int mesComparacao;
			int diaComparacao;
			Candidato candidato = (Candidato) entidade;

			
	        GregorianCalendar gc = new GregorianCalendar();
	        GregorianCalendar gcCandidato = new GregorianCalendar();
	        
	        gc.setTime(new Date());
	        gcCandidato.setTime(candidato.getDataCadastro());
	        
	        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
	        Date d1 = gc.getTime();
	        Date d2 = gcCandidato.getTime();
	        
	        System.out.println(sdf1.format(d1));
	        System.out.println(sdf1.format(d2));
	        
	        gc.roll(gc.YEAR, -1);
	        d1 = gc.getTime();
	        System.out.println(sdf1.format(d1));
        
	        if(!(d2.before(d1))) {
	        	sb.append("<br>Não pode alterar o candidato cujo a data cadastro não for maior que 1 ano<br>");
	        }else {
	        	candidato.setDataCadastro(new Date());
	        }
	        
	        
	        
	        
	        
			
		}
		
		if(sb.length() > 0) {
			return sb.toString();
		}else {
			return null;
		}
	}

}
