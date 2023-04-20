package proyecto_grupal_admin_hotel;

public enum TipoComida {
  DESAYUNO("Desayuno"),
  ALMUERZO("Almuerzo"),
  CENA("Cena");

  private final String valor;

  TipoComida(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}
