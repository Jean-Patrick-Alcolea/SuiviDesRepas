<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout</title>
</head>
<body>
	<header>
		<h1>Ajout</h1>
	</header>
	<main>
		<form method="post" action="/_TPSuiviDesRepas/ServletAjoutRepas" >
			<label>date : </label>
			<input type="date" name="date">
			<br>
			<label>Time : </label>
			<input type="time" name="time">
			<br>
			<label>Repas : </label>
			<input type="text" name="aliments" pattern="^(?:[^,]+,)*[^,]+$" > 
			<br>
			<input type="submit" value="Valider">
			<button formaction="/_TPSuiviDesRepas/Accueil">Annuler</button>
		</form>
		
	</main>
</body>
</html>