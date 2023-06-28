package core;

import java.security.NoSuchAlgorithmException;

import dominio.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception;
}
