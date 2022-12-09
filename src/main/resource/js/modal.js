$(document).ready(function () {

  $('.imagen-proyecto').on('click', function () {

    var rutaImagen = $(this).attr('src');
    var modal = '<div class="modal" id="modal"><img src="'+ rutaImagen  +'" alt=""><div class="btn-cerrar" id="btnCerrar"><i class="fa fa-times" aria-hidden="true"></i></div><div class="btn-carrito" id="btnCarrito"><i class="" aria-hidden="true" >Comprar Ahora</i></div>';
    $('#proyectos').after(modal);

    $('#btnCarrito').on('click', function (){
      //$('#modal').remove();
    })
    $('#btnCerrar').on('click', function () {
      $('#modal').remove();
    })
  })

  $(document).on('keyup', function (e) {
    if (e.which==27) {
      $('#modal').remove();
    }
  })

});
