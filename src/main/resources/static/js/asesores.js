function modalFormat (info) {
  return `
    <!-- Modal ${info.id} -->
      <div class="modal fade" id="exampleModal_${info.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title-detalles fs-5" id="exampleModalLabel"><strong> MÁS DETALLES </strong></h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-nombre">
              <p class="modal-name fs-5" ><strong>${info.name}</strong></p>
            </div>
            <div class= "modal-body">
            <img id="imagenesAsesores" src="${info.img}" style="heigth:550px; width:250px; display: flex; align-items: center;">
            <p id="descripcionAsesor">
              Habilidad principal: ${info.habilidadesPrincipales} <br/><br/>
              Habilidades adicionales: ${info.habilidadesAdicionales} <br/><br/>
              Horario: ${info.horarios}
             </p>
            </div>
            <div class="modal-precio">
              <h4 class="modal-price fs-5" id="exampleModalLabel">${info.precio} / hora</h4>
            </div>
            <div class="modal-footer">
              <button type="button" onclick="agregarACarrito(${info.id}, '${info.name}', '${info.horarios[0]}', '${info.precio}', '${info.img}')" class="btn2 btn-secondary boton-item" data-bs-dismiss="modal">Agregar asesoría</button>
            </div>
          </div>
        </div>
      </div> <!-- Modal ${info.id} -->
    `;
}

function addItem(item) {
  const itemHTML = `<div class="card" style="width: 18rem; padding: 10px; margin-bottom: 50px; margin-right: 50px; object-fit:contain; padding:20px" 
  data-aos="flip-left">
          <img id="imagenAsesor" src="${item.img}" class="card-img-top" alt="image">
          <div class="card-body" >
              <h5 class="card-title" style="text-align: center">${item.name}</h5>
              <p class="card-text" style="text-align: center">${item.habilidadesPrincipales}</p>
              <a href="#" class="btn btn-primary" id="btn-asesores" data-bs-toggle="modal" data-bs-target="#exampleModal_${item.id}">Ver más</a>
          </div>
      </div>
      <br/>`;

  const itemsContainer = document.getElementById("list-items");
  itemsContainer.innerHTML += itemHTML;
}

function agregarACarrito(id, nombre, horario, precio, img){
  let carritoTexto = localStorage.getItem("carrito");
  let carrito;
  if(!carritoTexto){
    carrito = {asesores:[],total:0};
  }else{
    carrito = JSON.parse(localStorage.getItem("carrito"));
  }
  carrito.asesores.push({id,nombre,horario, precio, img});
  carrito.total += 1;
  localStorage.setItem("carrito",JSON.stringify(carrito));
}



///MAIN ASESORES--- NO MOVER POR FAVOR
document.addEventListener("DOMContentLoaded", function () {
  let asesoresTexto = localStorage.getItem("listaAsesores");
  let lista;
  if(!asesoresTexto){
    lista = { asesores: listaAsesores, total: listaAsesores.length};
  }else{
    lista = JSON.parse(localStorage.getItem("listaAsesores"));
  }

  lista.asesores.forEach(a => addItem(a));

  // Agrega los modales al final del documento
  const modalContainer = document.getElementById("modal-container");


  let modalContent = "";

  lista.asesores.forEach(modalInfo => {
    modalContent += modalFormat(modalInfo);
  });

  modalContainer.innerHTML = modalContent;
});
