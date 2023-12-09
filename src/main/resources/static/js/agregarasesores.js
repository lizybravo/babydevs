let imagen;
document.addEventListener('DOMContentLoaded', function () {
    var imagenSubida = false;

    // Cloudinary - imágenes
    var myWidget = cloudinary.createUploadWidget({
        cloudName: 'dfzy1rq7e',
        uploadPreset: 'uw_test'
    }, (error, result) => {
        if (!error && result && result.event === "success") {
            console.log('¡Hecho! Esta es la información de la imagen: ', result.info);

            // Marcar que se ha subido la imagen
            imagenSubida = true;
            imagen = result.info.url;

            // Mostrar mensaje de éxito
            mostrarExitoImagen("¡Imagen añadida exitosamente!");
            return;
        }
    });

    document.getElementById("upload_widget").addEventListener("click", function (event) {
        event.preventDefault();
        myWidget.open();
    }, false);

    document.getElementById('btnAgregar-form').addEventListener('click', function (event) {
        event.preventDefault();

        validarFormulario();
    });

    // Limpiar
    document.getElementById('btnClear-form').addEventListener('click', function (event) {
        event.preventDefault();
        limpiarFormulario();
    });

    function limpiarFormulario() {
        // Limpia formulario
        document.getElementById('formulario').reset();
        // Ocultar mensajes de validación
        document.getElementById('alertValidaciones').style.display = 'none';
        // Quitar clases de validación de Bootstrap
        document.getElementById('formulario').classList.remove('was-validated');
    }

    function validarFormulario() {
        // Nombre
        var nombre = document.getElementById('Name').value.trim();
        if (nombre === '') {
            mostrarError('Por favor, ingresa tu nombre.');
            return;
        }

        // Correo electrónico
        var email = document.getElementById('Email').value.trim();
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            mostrarError('Por favor, ingresa un correo electrónico válido.');
            return;
        }

        // Habilidad principal
        var habilidadPrincipal = document.querySelector('input[name="flexRadioDefault"]:checked');
        if (!habilidadPrincipal) {
            mostrarError('Por favor, selecciona una habilidad principal.');
            return;
        }

        // Habilidades adicionales
        var habilidadesAdicionales = document.querySelectorAll('input[id^="flexCheckCheckedAdicional"]:checked');
        if (habilidadesAdicionales.length === 0) {
            mostrarError('Por favor, selecciona al menos una habilidad adicional.');
            return;
        }

        // Horario
        var horarios = document.querySelectorAll('input[id^="flexCheckIndeterminateHorario"]:checked');
        if (horarios.length === 0) {
            mostrarError('Por favor, selecciona al menos un horario.');
            return;
        }

        // Precio
        var precio = document.querySelector('input[id^="flexRadioDefaultPrecio"]:checked');
        if (!precio) {
            mostrarError('Por favor, selecciona un precio.');
            return;
        }

        // Imagen
        if (!imagenSubida) {
            mostrarError('Por favor, sube una imagen.');
            return;
        }

        // Modal de éxito formulario
        var myModal = new bootstrap.Modal(document.getElementById('formularioValidoModal'));
        myModal.show();
    }



    function mostrarError(mensaje) {
        var alerta = document.getElementById('alertValidaciones');
        var alertaTexto = document.getElementById('alertValidacionesTexto');
        alertaTexto.textContent = mensaje;
        alerta.style.display = 'block';
    }
});

// Función para mostrar una alerta de éxito al subir la imagen
function mostrarExitoImagen(mensaje) {
    var alertaI = document.getElementById('alertVImg');
    var alertaITexto = document.getElementById('alertValImgText');
    alertaITexto.textContent = mensaje;
    alertaI.style.display = 'block';
}

    function validaHabilidad (id){
        let inputradio=document.getElementById("flexRadioDefault" + id);
        let inputchekedlist=Array.from(document.getElementsByClassName ("check-input"));
        console.log (inputchekedlist);
        inputchekedlist.forEach(e=> {
            e.disabled=false;
        })
        let inputcheked=document.getElementById("flexCheckCheckedAdicional" + id);
        inputcheked.disabled=inputradio.checked;
    }

  function enviar () {
   let name = document.getElementById("Name").value;
   let correo = document.getElementById("Email").value;
   let inputradiolist = Array.from(document.getElementsByClassName ("input-radio"));
   let inputchekedlist = Array.from(document.getElementsByClassName ("check-input"));
   let inputhorariolist = Array.from(document.getElementsByClassName ("input-horario"));
   let inputpreciolist = Array.from(document.getElementsByClassName ("input-precio"));
   let habilidadesPrincipales = inputradiolist.filter(x=>x.checked).map(y=>y.value);
   let habilidadesAdicionales = inputchekedlist.filter(x=>x.checked).map(y=>y.value);
   let horarios = inputhorariolist.filter(x=>x.checked).map(y=>y.value);
   let precio = inputpreciolist.filter(x=>x.checked).map(y=>y.value);
   let img = imagen;
   let id = -1;
   let body={
    id,
    name,
    correo,
    habilidadesPrincipales,
    habilidadesAdicionales,
    horarios,
    precio,
    img
   }
   agregarAasesores(body);
   console.log(body);
}

function agregarAasesores(body){
    let asesoresTexto = localStorage.getItem("listaAsesores");
    let lista;
    if(!asesoresTexto){
      lista = { asesores: listaAsesores, total: listaAsesores.length};
    }else{
      lista = JSON.parse(localStorage.getItem("listaAsesores"));
    }
    lista.total += 1;
    body.id = lista.total;
    lista.asesores.push(body);
    localStorage.setItem("listaAsesores",JSON.stringify(lista));
  }