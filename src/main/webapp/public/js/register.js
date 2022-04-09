const GLOB = {
  register_button: document.getElementById("register-button"),
  input_name: document.getElementById("name"),
  input_username: document.getElementById("username"),
  input_password: document.getElementById("password"),
};

const saveUser = () => {
  ajaxCall("usersController", {
    action: "login",
    name: GLOB.input_name.value,
    username: GLOB.input_username.value,
    password: GLOB.input_password.value,
  });
};

const ajaxCall = (url, data) => {
  $.ajax({
    type: "POST",
    url: url,
    data: data,
  }).done((resp) => {
    switch (data.action) {
      case "login":
          ajaxRespLogin(resp);
        break;
    }
  });
};

const ajaxRespLogin = (resp) =>{
    resp =! "success" ? (alertify.error('No se ha logrado crear el usuario, intente nuevamente.')) : 
    (alertify.success('Se ha creado su cuenta, sera redireccionado a la pagina de login.'),setTimeout(() => {location.href('login.jsp');}, 5000))
}

GLOB.register_button.addEventListener("click", saveUser);
