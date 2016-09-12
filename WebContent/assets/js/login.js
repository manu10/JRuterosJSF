function validateForm_log() {
  result = true;
  var mail = document.getElementById("inputEmail").value;
  if (mail === null || mail === "") {
    document.getElementById("inputEmail_g").className += " has-error has-feedback";
    document.getElementById("inputEmail_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputEmail_g").className = "form-group";
    document.getElementById("inputEmail_error").innerHTML = "";
  }
  var pass = document.getElementById("inputPassword").value;
  if (pass === null || pass === "") {
    document.getElementById("inputPassword_g").className += " has-error has-feedback";
    document.getElementById("inputPassword_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputPassword_g").className = "form-group";
    document.getElementById("inputPassword_error").innerHTML = "";
  }
  // validar largo y tipo de caracteres
  /*
  var pass = document.getElementById("inputPassword").value;
  if (pass === null || pass === "") {
    alert("Name must be filled out");
    result = false;
   }
   */
  if (!result) {
    document.getElementById("input_error").innerHTML = "<p><strong class=\"text-danger\">Complete los campos resaltados.</strong></p>";
    document.getElementById("error_done").innerHTML = "";
  }
  return result;
}

function validateForm_reg() {
  result = true;
  var nombre = document.getElementById("inputName").value;
  if (nombre === null || nombre === "") {
    document.getElementById("inputName_g").className += " has-error has-feedback";
    document.getElementById("inputName_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputName_g").className = "form-group";
    document.getElementById("inputName_error").innerHTML = "";
  }
  var apellido = document.getElementById("inputLast").value;
  if (apellido === null || apellido === "") {
    document.getElementById("inputLast_g").className += " has-error has-feedback";
    document.getElementById("inputLast_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputLast_g").className = "form-group";
    document.getElementById("inputLast_error").innerHTML = "";
  }
  var mail = document.getElementById("inputEmail").value;
  if (mail === null || mail === "") {
    document.getElementById("inputEmail_g").className += " has-error has-feedback";
    document.getElementById("inputEmail_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputEmail_g").className = "form-group";
    document.getElementById("inputEmail_error").innerHTML = "";
  }
  var pass = document.getElementById("inputPassword").value;
  if (pass === null || pass === "") {
    document.getElementById("inputPassword_g").className += " has-error has-feedback";
    document.getElementById("inputPassword_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputPassword_g").className = "form-group";
    document.getElementById("inputPassword_error").innerHTML = "";
  }
  var pass_rep = document.getElementById("inputPassConfirm").value;
  if (pass_rep === null || pass_rep === "") {
    document.getElementById("inputPassConfirm_g").className += " has-error has-feedback";
    document.getElementById("inputPassConfirm_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputPassConfirm_g").className = "form-group";
    document.getElementById("inputPassConfirm_error").innerHTML = "";
  }
  var tel = document.getElementById("inputPhone").value;
  if (tel === null || tel === "") {
    document.getElementById("inputPhone_g").className += " has-error has-feedback";
    document.getElementById("inputPhone_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }else {
    document.getElementById("inputPhone_g").className = "form-group";
    document.getElementById("inputPhonem_error").innerHTML = "";
  }
  if (!result) {
    document.getElementById("input_error").innerHTML = "<p><strong class=\"text-danger\">Complete los campos resaltados.</strong></p>";
    document.getElementById("error_done").innerHTML = "";
  }
  return result;
}

function validateForm_rec() {
  result = true;
  var mail = document.getElementById("inputEmail").value;
  if (mail === null || mail === "") {
    document.getElementById("inputEmail_g").className += " has-error has-feedback";
    document.getElementById("inputEmail_error").innerHTML = "<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>";
    result = false;
  }
  if (!result) {
    document.getElementById("input_error").innerHTML = "<p><strong class=\"text-danger\">Complete los campos resaltados.</strong></p>";
    document.getElementById("error_done").innerHTML = "";
  }
  return result;
}
