package command;

import java.security.NoSuchAlgorithmException;

import controle.Fachada;
import core.ICommand;
import dominio.EntidadeDominio;

public class ExcluirCommand implements ICommand {

	@Override
	public String execute(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception {
System.out.println("Passando pela comnand Excluir");
		
		Fachada fachada = new Fachada();
		
		return fachada.excluir(entidade).toString();
		
	}

}
