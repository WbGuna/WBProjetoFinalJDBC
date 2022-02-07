<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">

	 <head>
	     <meta charset="UTF-8">
	     <meta http-equiv="X-UA-Compatible" content="IE=edge">
	     <meta name="viewport" content="width=device-width, initial-scale=1.0">
	     <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	     <title>Projeto Final JDB</title>
	 </head>

	<body>
		<header>
		    <div class="d-flex flex-column wrapper">
		        <nav class="navbar navbar-expand-lg navbar-dark bg-primary border-bottom shadow-sm mb-3">
		            <div class="container">
		                <a class="navbar-brand" href="index.jsp"><b>WB-Online</b></a>
		                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		                    data-bs-target=".navbar-collapse">
		                    <span class="navbar-toggler-icon"></span>
		                </button>
		                <div class="collapse navbar-collapse">
		                    <ul class="navbar-nav flex-grow-1">
		                        <li class="nav-item">
		                            <a class="nav-link text-white" href="index.jsp">Contatos</a>
		                        </li>
		                    </ul>
		                </div>
		            </div>
		        </nav>
    		</div>
		</header>
	
		<div class="container mt-5">
			<div class="row">
		  		<div class="col-md-5 mx-auto border text-center">
		    		<h3>Adicionar Usuario</h3>
		    			<form method="post" action="ServletPF">
		      				<input type="hidden" name="id" value="${user.id}" />
								
							<div class="form-group" style="text-align-last: left;">
								<label for="nome" class="form-label">Nome:</label>
								<input type="text" class="form-control" id="nome" name="nome" value="${user.nome}" required>
							</div>
		
		
							<div class="form-group" style="text-align-last: left;">
								<label for="email">Email:</label>
								<input type="text" class="form-control" name="email" value="${user.email}" required>
							</div>
		
							<div class="form-group" style="text-align-last: left;">
								<label for="telefone">Telefone:</label>
								<input type="number" class="form-control" name="telefone" value="${user.telefone}" required>
							</div>
		
							<div class="form-group" style="text-align-last: left;">
								<label for="pais" class="form-label">Pais:</label>
								<input type="text" class="form-control" name="pais" value="${user.pais}" required>
							</div>
		
							<c:choose>
								<c:when test="${user == null}">
									<button type="submit" class="btn btn-primary col-2 mb-3 mt-3" name="option" value="insert">Salvar</button>
								</c:when>
								<c:otherwise>
									<button type="submit" class="btn btn-primary col-2 mb-3 mt-3" name="option" value="update">Atualizar</button>
								</c:otherwise>
							</c:choose>
		   				</form>
		    	</div>
		  	</div>
		</div>            
	</body>
</html>