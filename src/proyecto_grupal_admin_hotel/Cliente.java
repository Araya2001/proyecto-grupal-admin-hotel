package proyecto_grupal_admin_hotel;

import java.util.Objects;

public class Cliente {
  private String id;
  private String nombre;
  private String apellido;
  private String telefono;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(id, cliente.id) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(telefono, cliente.telefono);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellido, telefono);
  }

  public Cliente() {
  }

  public Cliente(String id, String nombre, String apellido, String telefono) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
  }

  public String getId() {
    return id;
  }

  public Cliente setId(String id) {
    this.id = id;
    return this;
  }

  public String getNombre() {
    return nombre;
  }

  public Cliente setNombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  public String getApellido() {
    return apellido;
  }

  public Cliente setApellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  public String getTelefono() {
    return telefono;
  }

  public Cliente setTelefono(String telefono) {
    this.telefono = telefono;
    return this;
  }
}
