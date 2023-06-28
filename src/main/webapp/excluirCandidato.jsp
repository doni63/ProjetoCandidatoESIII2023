<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dominio.Candidato"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
String msg = (String)request.getAttribute("mensagem");
%>
<%
	String id ="";
	String nome ="";
	String pai ="";
	String mae ="";
	String residencial ="";
	String celular ="";
	String recado ="";
	String logradouro ="";
	String numero ="";
	String cep ="";
	String cidade ="";
	String estado ="";
	String curso1 ="";
	String curso2 ="";
	String curso3 ="";
	String data = "";
	String idEndereco = "";

   if(!(request.getParameter("id")==null)){
	   id = request.getParameter("id");
   }
   
   if(!(request.getParameter("nome")==null)){
	   nome = request.getParameter("nome");
   }
   
   if(!(request.getParameter("pai")==null)){
	   pai = request.getParameter("pai");
   }
   
   if(!(request.getParameter("mae")==null)){
	   mae =request.getParameter("mae");
   }
   
   if(!(request.getParameter("residencial")==null)){
	   residencial = request.getParameter("residencial");
   }
   
   
   if(!(request.getParameter("celular")==null)){
	   celular = request.getParameter("celular");
   }
   
   
   if(!(request.getParameter("recado")==null)){
	   recado = request.getParameter("recado");
   }
   
   if(!(request.getParameter("logradouro")==null)){
	   logradouro = request.getParameter("logradouro");
   }
   
   
   if(!(request.getParameter("numero")==null)){
	   numero = request.getParameter("numero");
   }
   if(!(request.getParameter("cep")==null)){
	   cep = request.getParameter("cep");
   }
   
   if(!(request.getParameter("cidade")==null)){
	   cidade = request.getParameter("cidade");
   }
   
   if(!(request.getParameter("estado")==null)){
	   estado = request.getParameter("estado");
   }
   
   if(!(request.getParameter("curso1")==null)){
	   curso1 = request.getParameter("curso1");

   }
   
   if(!(request.getParameter("curso2")==null)){
	   curso2 = request.getParameter("curso2");
   }
   
   if(!(request.getParameter("curso3")==null)){
	   curso3 = request.getParameter("curso3");
   }
   
   if(!(request.getParameter("data")==null)){
	   data = request.getParameter("data");
   }
   
   if(!(request.getParameter("idEndereco")==null)){
	   idEndereco = request.getParameter("idEndereco");
   }
   
   // Fa�a a manipula��o do objeto conforme necess�rio
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Excluir Candidato</title>
</head>
<body>
	<h1>Excluir Candidato</h1>
	<form name="frmCandidato" action="confirmarExcluir">
		<table>
		
			<tr><td><input type="hidden" name="id" readonly="readonly" value="<%out.println(id);%>"></td></tr>
			<tr><td> </td></tr>
			<tr><td><input type="hidden" name="nomePai" readonly="readonly" value="<%out.println(pai);%>"> </td></tr>
			<tr><td><input type="hidden" name="nomeMae" readonly="readonly" value="<%out.println(mae);%>"> </td></tr>
			<tr><td><input type="hidden" name="telefoneResidencial" readonly="readonly"  value="<%out.println(residencial);%>"> </td></tr>
			<tr><td><input type="hidden" name="celular" readonly="readonly"  value="<%out.println(celular);%>"> </td></tr>
			<tr><td><input type="hidden" name="telefoneRecado" placeholder="Tel.Recado" value="<%out.println(recado);%>"> </td></tr>
			<tr><td><input type="hidden" name="logradouro" readonly="readonly"  value="<%out.println(logradouro);%>"> </td></tr>
			<tr><td><input type="hidden" name="numero" readonly="readonly"  value="<%out.println(numero);%>"> </td> </tr>
			<tr><td><input type="hidden" name="cep" readonly="readonly"  value="<%out.println(cep);%>"> </td> </tr>
			<tr><td><input type="hidden" name="cidade" readonly="readonly"  value="<%out.println(cidade);%>"> </td></tr>
			<tr><td><input type="hidden" name="CursoInteresse" readonly="readonly"  value="<%out.println(curso1);%>"> </td></tr>
			<tr><td><input type="hidden" name="estado" readonly="readonly"  value="<%out.println(estado);%>"> </td> </tr>
			<tr><td><input type="hidden" name="curso1" id="CursoInteresse" value="<%out.println(curso1);%>"></td> </tr>
			<tr><td><input type="hidden" name="curso2" id="CursoInteresse" value="<%out.println(curso2);%>"></td> </tr>
			<tr><td><input type="hidden" name="curso3" id="CursoInteresse" value="<%out.println(curso3);%>"></td> </tr>
			<tr><td><input type="hidden" name="idEndereco" readonly="readonly" value="<%out.println(idEndereco);%>"></td> </tr>
			Candidado: <input type="text" name="nomeCandidato" readonly="readonly" value="<%out.println(nome);%>"><BR>
			Tem certeza que deseja excluir?<BR><BR>
		<input type="submit" name ="operacao" value="SIM">
		<input type="submit" name ="operacao" value="NÃO">
		<%if(!(msg==null)){out.println(msg);}%>
	</form>
</body>
</html>