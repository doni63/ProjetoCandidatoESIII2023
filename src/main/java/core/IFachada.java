package core;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import dominio.EntidadeDominio;

public interface IFachada {
	public String salvar(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception;
	public String alterar(EntidadeDominio entidade) throws GeneralSecurityException, Exception;
	public String excluir(EntidadeDominio entidade) throws ClassNotFoundException, NoSuchAlgorithmException, Exception;
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);

}
