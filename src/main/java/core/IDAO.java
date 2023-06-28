package core;

import java.util.List;

import dominio.EntidadeDominio;

public interface IDAO {
	public boolean salvar(EntidadeDominio entidade);
	public boolean alterar(EntidadeDominio entidade);
	public boolean excluir(EntidadeDominio entidade) throws ClassNotFoundException;
	public List<EntidadeDominio> listarEntidade(EntidadeDominio entidade);
	


}
