package proyecto_grupal_admin_hotel;

public class ReservaRestaurante {
  private String nombreCliente;
  private int cuposReservados;
  private Restaurante restaurante;
  private TipoComida tipoComida;
  private Mesa mesa;
  private boolean esConfirmada;
  private DetalleRestaurante[] detalleRestaurante;

  public ReservaRestaurante(String nombreCliente, int cuposReservados, Restaurante restaurante, TipoComida tipoComida, Mesa mesa,, boolean esConfirmada) {
    this.nombreCliente = nombreCliente;
    this.cuposReservados = cuposReservados;
    this.restaurante = restaurante;
    this.tipoComida = tipoComida;
    this.mesa = mesa;
    this.esConfirmada = esConfirmada;
  }

  public DetalleRestaurante[] getDetalleRestaurante() {
    return detalleRestaurante;
  }

  public ReservaRestaurante setDetalleRestaurante(DetalleRestaurante[] detalleRestaurante) {
    this.detalleRestaurante = detalleRestaurante;
    return this;
  }

  public ReservaRestaurante() {
  }

  public boolean isEsConfirmada() {
    return esConfirmada;
  }

  public ReservaRestaurante setEsConfirmada(boolean esConfirmada) {
    this.esConfirmada = esConfirmada;
    return this;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public ReservaRestaurante setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
    return this;
  }

  public int getCuposReservados() {
    return cuposReservados;
  }

  public ReservaRestaurante setCuposReservados(int cuposReservados) {
    this.cuposReservados = cuposReservados;
    return this;
  }

  public Restaurante getRestaurante() {
    return restaurante;
  }

  public ReservaRestaurante setRestaurante(Restaurante restaurante) {
    this.restaurante = restaurante;
    return this;
  }

  public TipoComida getTipoComida() {
    return tipoComida;
  }

  public ReservaRestaurante setTipoComida(TipoComida tipoComida) {
    this.tipoComida = tipoComida;
    return this;
  }

  public Mesa getMesa() {
    return mesa;
  }

  public ReservaRestaurante setMesa(Mesa mesa) {
    this.mesa = mesa;
    return this;
  }

  public String mostrarFactura() {
    Double montoSubtotal = 0.0;
    Double montoTotal = 0.0;
    Double montoPorUnidad;
    Double iva = 0.0;
    StringBuilder sb = new StringBuilder();
    sb.append("Factura de restaurante: ");
    sb.append(this.restaurante.getNombre());
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Nombre del cliente: ");
    sb.append(this.nombreCliente);
    sb.append("\n");
    sb.append("Tipo de comida: ");
    sb.append(this.tipoComida.getValor());
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("Detalle comprobante: ");
    sb.append("\n");
    sb.append("Comentario\t\tCantidad\tMonto\tSubtotal\tTotal (IVA)");
    sb.append("\n");
    for (int i = 0; i < this.detalleRestaurante.length; i++) {
      montoPorUnidad = this.detalleRestaurante[i].getMonto() * detalleRestaurante[i].getCantidad();
      sb.append(this.detalleRestaurante[i].getComentario());
      sb.append("\t\t");
      sb.append(this.detalleRestaurante[i].getCantidad());
      sb.append("\t");
      sb.append(this.detalleRestaurante[i].getMonto());
      sb.append("\t");
      sb.append(montoPorUnidad);
      sb.append("\t");
      sb.append(montoPorUnidad * 1.13);
      sb.append("\n");
      montoSubtotal += montoPorUnidad;
      montoTotal += montoPorUnidad * 1.13;
      iva += montoPorUnidad * 0.13;
    }
    sb.append("\n");
    sb.append("------------------------------------------------");
    sb.append("\n");
    sb.append("IVA: ");
    sb.append(iva);
    sb.append("\n");
    sb.append("Subtotal: ");
    sb.append(montoSubtotal);
    sb.append("\n");
    sb.append("Total: ");
    sb.append(montoTotal);
    sb.append("\n");
    return sb.toString();
  }



  public void cancelarReserva() {
    setEsConfirmada(false);
    this.mesa.setDisponibilidad(true);
    this.mesa = new Mesa()
        .setIdMesa("MESA CANCELADA")
        .setDisponibilidad(false)
        .setAsientosDisponibles(0);
  }

  public void agregarCobroAFactura(double cantidad, double monto, String comentario) {
    DetalleRestaurante[] nuevoDetalle = new DetalleRestaurante[this.detalleRestaurante.length + 1];
    for (int i = 0; i < this.detalleRestaurante.length; i++) {
      nuevoDetalle[i] = this.detalleRestaurante[i];
    }
    nuevoDetalle[this.detalleRestaurante.length] = new DetalleRestaurante()
        .setCantidad(cantidad)
        .setMonto(monto)
        .setComentario(comentario);
    this.detalleRestaurante = nuevoDetalle;
  }
}
