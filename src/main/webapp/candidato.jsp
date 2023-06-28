<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="dominio.Candidato"%>
<%
List<Candidato> lista = (ArrayList) request.getAttribute("candidatos");
request.setAttribute("candidatos", lista);
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Candidatos</title>
</head>
<body>
	<style>
#tabela {
	margin-top: 30px;
}

#tabela th {
	border: 1px solid black;
	text-align: center;
}

#tabela td {
	text-align: left;
}

</style>
	<h1>Candidatos</h1>
	<a href="novoCandidato">Novo Candidato</a>
	<a href="index.html">Voltar</a>
	<table id="tabela">
		<thead>
			<form name="frmCandidato" action="excluirCandidato" method="get">
			
			<tr>
				<th>Nome</th>
				<th>Celular</th>
				<th>Tel.Residencial</th>
				<th>Curso</th>
				<th>Endereço</th>
				<th>Opção</th>
			</tr>
		</thead>
		<%
		for (int i = 0; i < lista.size(); i++) {
		%>
		<tr>
			<td><input readonly="readonly" type="text" name="nomeCandidato" value="<%=lista.get(i).getNome()%>">
			</td>
			<td><input readonly="readonly" type="text" name="celular"  value="<%=lista.get(i).getTelefone().getCelular()%>"></td>
			<td><input readonly="readonly" type="text" name="telefone"  value="<%=lista.get(i).getTelefone().getResidencial() %>"></td>
			<td><input readonly="readonly" type="text" name="curso"  value="<%=lista.get(i).getCursos().get(0).getDescricao()%>"></td>
			<td><input readonly="readonly" type="text" name="endereco"  value="<%=lista.get(i).getEndereco().getLogradouro()%>"></td>
			<td>
			 
			 <a href="editarCandidato.jsp?id=<%=lista.get(i).getId()%>&nome=<%=lista.get(i).getNome()%>&pai=<%=lista.get(i).getFiliacao().getPai()%>&mae=<%=lista.get(i).getFiliacao().getMae().toString()%>&residencial=<%=lista.get(i).getTelefone().getResidencial()%>&celular=<%=lista.get(i).getTelefone().getCelular()%>&recado=<%=lista.get(i).getTelefone().getRecado()%>&logradouro=<%=lista.get(i).getEndereco().getLogradouro()%>&numero=<%=lista.get(i).getEndereco().getNumero()%>&cep=<%=lista.get(i).getEndereco().getCep()%>&cidade=<%=lista.get(i).getEndereco().getCidade().getDescricao()%>&estado=<%=lista.get(i).getEndereco().getCidade().getEstado().getDescricao()%>&data=<%=lista.get(i).getDataCadastro()%>&curso1=<%=lista.get(i).getCursos().get(0).getDescricao()%>&curso2=<%=lista.get(i).getCursos().get(1).getDescricao()%>&curso3=<%=lista.get(i).getCursos().get(2).getDescricao()%>&idEndereco=<%=lista.get(i).getEndereco().getId()%>">Editar</a>
			 <a href="excluirCandidato.jsp?id=<%=lista.get(i).getId()%>&nome=<%=lista.get(i).getNome()%>&pai=<%=lista.get(i).getFiliacao().getPai()%>&mae=<%=lista.get(i).getFiliacao().getMae().toString()%>&residencial=<%=lista.get(i).getTelefone().getResidencial()%>&celular=<%=lista.get(i).getTelefone().getCelular()%>&recado=<%=lista.get(i).getTelefone().getRecado()%>&logradouro=<%=lista.get(i).getEndereco().getLogradouro()%>&numero=<%=lista.get(i).getEndereco().getNumero()%>&cep=<%=lista.get(i).getEndereco().getCep()%>&cidade=<%=lista.get(i).getEndereco().getCidade().getDescricao()%>&estado=<%=lista.get(i).getEndereco().getCidade().getEstado().getDescricao()%>&data=<%=lista.get(i).getDataCadastro()%>&curso1=<%=lista.get(i).getCursos().get(0).getDescricao()%>&curso2=<%=lista.get(i).getCursos().get(1).getDescricao()%>&curso3=<%=lista.get(i).getCursos().get(2).getDescricao()%>&idEndereco=<%=lista.get(i).getEndereco().getId()%>">Excluir</a>
				
			</td>
			
		</tr>

		<%
		}
		%>
		<tbody>

		</tbody>
	</table>
	</form>
	<script src="script.js"></script>
</body>
</html>