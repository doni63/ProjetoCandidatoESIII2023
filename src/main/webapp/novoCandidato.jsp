<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "dominio.Curso" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="dominio.Curso"%>
<%@ page import="viewHelper.CursoList"%>
<%
CursoList c = new CursoList();
List<Curso> lista = c.getCursos();
%>
<%
String msg = (String)request.getAttribute("mensagem");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Novo Candidato</title>
</head>
<body>
	<h1>Novo Candidato</h1>
	<a href="index.html">Home</a>
	<form name="frmCandidato" action="salvarCandidato">
		<table>
			<tr><td>Nome:<input type="text" name="nomeCandidato" placeholder="Nome"> </td></tr>
			<tr><td>Pai:<input type="text" name="nomePai" placeholder="Filiação-Pai"> </td></tr>
			<tr><td>Mãe:<input type="text" name="nomeMae" placeholder="Filiação-Mãe"> </td></tr>
			<tr><td>Residencial:<input type="tel" maxlength="15" onkeyup="handlePhone(event)" name="telefoneResidencial"placeholder="Tel. Residencial"></td></tr>
			<tr><td>Celular:<input type="tel" maxlength="15" onkeyup="handlePhone(event)" name="celular" placeholder="Celular"> </td></tr>
			<tr><td>Recado:<input type="tel" maxlength="15" onkeyup="handlePhone(event)"  name="telefoneRecado" placeholder="Tel.Recado" ></td></tr>
			<tr><td>Logradouro:<input type="text" name="logradouro" placeholder="Logradouro"></td></tr>
			<tr><td>Número:<input type="text" name="numero" placeholder="Número"> </td> </tr>
			<tr><td>CEP:<input type="text" name="cep" placeholder="CEP"> </td> </tr>
			<tr><td>Cidade:<input type="text" name="cidade" placeholder="Cidade"> </td></tr>
			<tr><td>Estado:<input type="text" name="estado" placeholder="Estado"> </td> </tr>
			
<tr>
  <td>Curso Principal:
    <select name="CursoInteresse" id="CursoInteresse">
      <option value='0'></option>
      <% 

      // Itera sobre a lista de cursos e cria as opções
      for (Curso curso : lista) { %>
        <option value="<%= curso.getId() %>"><%= curso.getDescricao() %></option>
      <%}%>
    </select>
  </td>
</tr>

<tr>
  <td>Curso Alternativa 1:
    <select name="curso2" id="curso2">
      <option value='0'></option>
      <% 

      // Itera sobre a lista de cursos e cria as opções
      for (Curso curso : lista) { %>
        <option value="<%= curso.getId() %>"><%= curso.getDescricao() %></option>
      <%}%>
    </select>
  </td>
</tr>

<tr>
  <td>Curso Alternativa 2:
    <select name="curso3" id="curso3">
      <option value='0'></option>
      <% 

      // Itera sobre a lista de cursos e cria as opções
      for (Curso curso : lista) { %>
        <option value="<%= curso.getId() %>"><%= curso.getDescricao() %></option>
      <%}%>
    </select>
  </td>
</tr>
				
		</table>
		<input type="submit" name ="operacao" value="Salvar_Candidato">
		<% if (!(msg==null)){out.println(msg);} %>
	</form>
	<script src="./script.js"></script>
</body>
</html>