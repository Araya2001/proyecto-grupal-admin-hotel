package proyecto_grupal_admin_hotel;

public enum TipoComida {
  DESAYUNO("Desayuno", 100.0),
  ALMUERZO("Almuerzo", 200.0),
  CENA("Cena", 250.0);
  private final String valor;
  private final Double monto;

  TipoComida(String valor, Double monto) {
    this.valor = valor;
    this.monto = monto;
  }

  public String getValor() {
    return valor;
  }

  public Double getMonto() {
    return monto;
  }

  public static TipoComida obtenerTipoComidaConValor(String tipoComida) {
    TipoComida[] tipoComidas = TipoComida.values();
    for (int i = 0; i < tipoComidas.length; i++) {
      if (tipoComidas[i].getValor().equalsIgnoreCase(tipoComida)) {
        return tipoComidas[i];
      }
    }
    return null;
  }
}
