let plantilla =(asesor) => `
    <tr>
        <td>
          <h3 id="nombreAsesor">${asesor.nombre}</h3>
        </td>
        <td>
          <img width:"100px" height="100px" id="fotoAsesor" src="${asesor.img}">
        </td>
    </tr>
`;

document.addEventListener("DOMContentLoaded", function () {

    let tablaAsesores = document.getElementById("asesores");

    let carrito =JSON.parse(localStorage.getItem("carrito"));
    let listaAsesores = carrito.asesores;
    let tablaContenido = "";
    listaAsesores.forEach(element => {
        tablaContenido+= plantilla(element);
    });
    tablaAsesores.innerHTML = tablaContenido;
  });

