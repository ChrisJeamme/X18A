function valider() 
{
	if (document.formulaire.prenom.value == "") 
	{
		alert("Veuillez entrer votre prénom !");
		valid = false;
		return valid;
	}

	if (document.formulaire.nom.value == "") 
	{
		alert("Veuillez entrer votre nom !");
		valid = false;
		return valid;
	}

	if (document.formulaire.email.value == "") 
	{
		alert("Veuillez entrer votre email !");
		valid = false;
		return valid;
	}


	if (document.formulaire.pseudo.value == "") 
	{
		alert("Veuillez entrer un pseudo !");
		valid = false;
		return valid;
	}
	
	if (document.formulaire.pass.value == "") 
	{
		alert("Veuillez entrer un mot de passe !");
		valid = false;
		return valid;
	}
}