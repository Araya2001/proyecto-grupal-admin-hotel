package proyecto_grupal_admin_hotel;

public class ReservaRestaurante {
    private String nombreCliente;
    private int cuposReservados;
    private Restaurante restaurante;
    private TipoComida tipoComida;
    private Mesa mesa;
    private Factura factura;
    private boolean esConfirmada;

    public ReservaRestaurante setFactura(Factura factura) {
        this.factura = factura;
        return this;
    }

    public ReservaRestaurante(String nombreCliente, int cuposReservados, Restaurante restaurante, TipoComida tipoComida, Mesa mesa, Factura factura, boolean esConfirmada) {
        this.nombreCliente = nombreCliente;
        this.cuposReservados = cuposReservados;
        this.restaurante = restaurante;
        this.tipoComida = tipoComida;
        this.mesa = mesa;
        this.factura = factura;
        this.esConfirmada = esConfirmada;
    }

    public Factura getFactura() {
        return factura;
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
        return this.getFactura().desplegar_factura();
    }

    public void cancelarReserva() {
        setEsConfirmada(false);
        this.mesa.setDisponibilidad(true);
        this.mesa = new Mesa()
                .setIdMesa("MESA CANCELADA")
                .setDisponibilidad(false)
                .setAsientosDisponibles(0);
    }
}
