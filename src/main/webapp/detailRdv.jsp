<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="detailRdv.css">
</head>
<body id="global">
    <div class="row d-flex justify-content-center mt-4">
    
        
        <diV class="rectangle mt-4">
            <div class="row">
                <div class="col-6 col1">
                    <div class="d-flex">
                        <i id="arrow"  class="bi bi-arrow-left-circle-fill"></i>
                    <h1 class="title"  style="color: white; ;font-size: 27px; margin-left: 10px; " id="date"><c:out value="${requestScope.rdv.session.date}" /></h1>
                    </div>
                   
                        
               <div id="detail">
                 <div class="circle"></div> <h1  class="title">Details Etudiant:</h1>
                 <div id="contact">
                    <div class="d-flex"><p class="text-bold">Nom:</p><p class="text"><c:out value="${requestScope.rdv.etudiant.nom}" /></p></div>
                <div class="d-flex"> <p class="text-bold">Prenom:</p><p class="text"><c:out value="${requestScope.rdv.etudiant.prenom}" /></p></div>
                 <div class="d-flex"><p class="text-bold">Email:</p><p class="text"> <c:out value="${requestScope.rdv.etudiant.email}" /></p></div>
                 <div class="d-flex"><p class="text-bold">niveau:</p><p class="text"><c:out value="${requestScope.rdv.etudiant.niveau}" /></p></div>
                 </div>
    
               </div>
                </div>
                <div class="col-6 col1">
                    <form action="Controller">
                    <h1 class="title"  style="color: white; ;font-size: 27px; ">Envoyer le lien du rendez-vous</h1>
                    <input type="text" name="lien" id="lien" name="lien"  class="form-control"  placeholder="Entrer le lien" value="<c:out value="${requestScope.rdv.lien}" />">
    
                    <div class="head">
                        <div class="circle"></div><h1  class="title">Notes</h1>
                    </div>
                    <input type="hidden" name="idRdv" value="<c:out value="${requestScope.rdv.idRdv}" />">
                    <textarea name="note" id="note" cols="45" rows="9" placeholder="WRITE YOUR NOTE"  ></textarea>
                   <h1 style="display:none;" id="h1"><c:out value="${requestScope.rdv.note}" /></h1>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-4 offset-4 d-grid ">
                    <button type="submit" class=" btn-lg custom-btn btn-block mt-4 "  id="submit" name="myBtn" value="updateRdvv"><p class="signIn-custom ">submit</p></button>
                    
                    </form>

                </div>
            </div>
        </diV>
    </div>
<script type="text/javascript" src="detailRdv.js"></script>
</body>
</html>