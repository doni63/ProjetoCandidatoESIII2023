package command;

import java.security.NoSuchAlgorithmException;

import controle.Fachada;
import core.ICommand;
import core.IFachada;
import dominio.EntidadeDominio;

public class SalvarCommand implements ICommand {

	@Override
	public String execute(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception{
		System.out.println("Passando pela comnand");
	
		Fachada fachada = new Fachada();
		
		return fachada.salvar(entidade).toString();
	}

}
