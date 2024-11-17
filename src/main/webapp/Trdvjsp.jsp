<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Traitement rendez-vous</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="Trdv.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body id="global">
    <div class="custom-margin ">
        <div class="row Rowup my-4">
          <div class="col-md-8 offset-md-2">
            <div class="titleF text-center d-flex align-items-center">
              <div class="card-body mt-2">
                <h1 class="card-title" style="color: white; font-family:DM Serif Display-regular ;font-size: 65px;">Check appointments</h1>
                <h5 class="card-text mt-3" style="color: white; font-family: DM Serif Display,Serif; font-size: 25px;">See your daily-weekly-monthly apointements</h5>
              </div>
            </div>
          </div>
        </div>
      </div>


      <div class="row custom-margin">
        <div class="col-2 offset-1">
            <div class="frame-1">
                <button class="back" id="btnCreerSession" value="creerSession">
                    <span class="button-text" >creer session</span>
                </button>
                <button class="back" id="btnDetail" value="detailConsultation" >
                    <span class="button-text"  >details consultation</span>
                </button>
            </div>
        </div>
 <form id="hiddenForm" action="Controller" method="get" style="display: none;">
    <input type="hidden" id="dateValue" name="dateValue">
    <input type="hidden" id="timeValue" name="timeValue">
     <input type="hidden" id="myBtn" name="myBtn">
</form>
        <div class="col-8 mx-5">
            <div   class="rectangle" >
              <div class="row" id="row1">
                <h1 class="title text-center"  style="color: white; ;font-size: 27px; margin-bottom: 30px; ">Creation de session </h1>
               <div class="col">
                <label for="date" style="color: white;">Donner le jour du session a creer</label>
                <input type="date" id="date" name="date" class="form-control" >
               </div>
                <div class="col">
                  <label for="time" style="color: white;">Donner l'horaire'du session a creer</label>
                  <input type="time" id="time" name="time" class="form-control" >
                </div>
    
              </div>*
    
              <!-- message -->
              
             <form id="hiddenForm2" action="Controller" method="get" style="display: none;">
    <input type="hidden" id="selectedValue" name="selectedValue">
     <input type="hidden" id="myBtn2" name="myBtn">
</form>
    
    
              <div class="row pt-4 mx-2" id="row2">
              </div>
              <div class="row row3 mx-2 d-flex justify-content-center align-items-center form-floating">
                <select style="color: white;"   class="form-select form-select-lg my-3" aria-label="Large select example"  id="rdv">
                  <option selected disabled value=""  style="text-align: center; font-size: 25px;">List rendez-vous</option>
                  <c:forEach var="rdv" items="${requestScope.rdvs}">
       <option class="option" value="${rdv.idRdv}">${rdv.session.date} </option>

</c:forEach>
                </select>
               
              </div>
            </div>
        </div>
    </div>

<script type="text/javascript" src="Trdv.js"></script>

</body>
</html>