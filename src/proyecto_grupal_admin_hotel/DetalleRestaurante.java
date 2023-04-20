package proyecto_grupal_admin_hotel;

public class DetalleRestaurante {
    private double monto;
    private double cantidad;
    private String comentario;

    public DetalleRestaurante(double monto, double cantidad, String comentario) {
        this.monto = monto;
        this.cantidad = cantidad;
        this.comentario = comentario;
    }

    public DetalleRestaurante() {
    }

    public double getMonto() {
        return monto;
    }

    public DetalleRestaurante setMonto(double monto) {
        this.monto = monto;
        return this;
    }

    public double getCantidad() {
        return cantidad;
    }

    public DetalleRestaurante setCantidad(double cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public String getComentario() {
        return comentario;
    }

    public DetalleRestaurante setComentario(String comentario) {
        this.comentario = comentario;
        return this;
    }
}
