package core;

import java.security.NoSuchAlgorithmException;

import dominio.EntidadeDominio;

public interface ICommand {
	public String execute(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception;
		
	
}
