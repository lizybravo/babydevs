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

            <p id="descripcionAsesor"> ${info.description} </p>
            </div>
            <div class="modal-precio">
              <h4 class="modal-price fs-5" id="exampleModalLabel">${info.precio}</h4>
            </div>
            <div class="modal-footer">
              <button type="button" onclick="agregarACarrito(${info.id}, '${info.name}', '${info.img}')" class="btn2 btn-secondary" data-bs-dismiss="modal">Agregar asesoría</button>
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
              <p class="card-text" style="text-align: center">${item.habilidad}</p>
              <a href="#" class="btn btn-primary" id="btn-asesores" data-bs-toggle="modal" data-bs-target="#exampleModal_${item.id}">Ver más</a>
          </div>
      </div>
      <br/>`;

  const itemsContainer = document.getElementById("list-items");
  itemsContainer.innerHTML += itemHTML;
}

function agregarACarrito(id, nombre, img){
  let carritoTexto = localStorage.getItem("carrito");
  let carrito;
  if(!carritoTexto){
    carrito = {asesores:[],total:0};
  }else{
    carrito = JSON.parse(localStorage.getItem("carrito"));
  }
  carrito.asesores.push({id,nombre,img});
  localStorage.setItem("carrito",JSON.stringify(carrito));
}



///MAIN ASESORES--- NO MOVER POR FAVOR
document.addEventListener("DOMContentLoaded", function () {

  listaAsesores.forEach(a => addItem(a));

  // Agrega los modales al final del documento
  const modalContainer = document.getElementById("modal-container");


  let modalContent = "";

  listaAsesores.forEach(modalInfo => {
    modalContent += modalFormat(modalInfo);
  });

  modalContainer.innerHTML = modalContent;
});
