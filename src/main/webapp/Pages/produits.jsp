<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestion des Produits</title>
</head>
<body>

<h1>Gestion des produits</h1>
<hr/>

recherche :
<form action="searchProduct.aspx" method="post">
    ID : <input type="text" name="idProduit" value="${idProduit}" />
    <input type="submit" value="Afficher" />
</form>
<hr/>

Ajouter / Modifier :
<form action="${produitEdit != null ? 'updateProduit' : 'addProduct'}.aspx" method="post">
    <input type="hidden" name="idProduit"
           value="${produitEdit != null ? produitEdit.idProduit : ''}" />
    Nom :
    <input type="text" name="nom"
           value="${produitEdit != null ? produitEdit.nom : ''}" />
    Description :
    <input type="text" name="description"
           value="${produitEdit != null ? produitEdit.description : ''}" />
    Prix :
    <input type="text" name="prix"
           value="${produitEdit != null ? produitEdit.prix : ''}" />
    <input type="submit"
           value="${produitEdit != null ? 'Mettre a jour' : 'Ajouter'}" />
</form>
<hr/>

<table border="1" width="50%">
    <tr>
        <th>ID</th>
        <th>NOM</th>
        <th>DESCRIPTION</th>
        <th>PRIX</th>
        <th>Option</th>
    </tr>
    <c:forEach items="${listeProduit}" var="o">
        <tr>
            <td>${o.idProduit}</td>
            <td>${o.nom}</td>
            <td>${o.description}</td>
            <td>${o.prix}</td>
            <td><a href="deleteProduit.aspx?id=${o.idProduit}">supprimer</a></td>
            <td><a href="editProduit.aspx?id=${o.idProduit}">Modifier</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>