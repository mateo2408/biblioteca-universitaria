import java.util.Objects;

/**
 * Representa un libro de la biblioteca universitaria.
 */
public final class Libro {
  private final String titulo;
  private final String autor;
  private boolean disponible = true;

  /**
   * Crea un libro disponible.
   *
   * @param titulo titulo del libro
   * @param autor autor del libro
   */
  public Libro(String titulo, String autor) {
    this.titulo = requireText(titulo, "titulo");
    this.autor = requireText(autor, "autor");
  }

  private static String requireText(String value, String fieldName) {
    Objects.requireNonNull(value, fieldName + " no puede ser null");
    if (value.isBlank()) {
      throw new IllegalArgumentException(fieldName + " no puede estar vacío");
    }
    return value;
  }

  /**
   * Retorna el titulo del libro.
   *
   * @return titulo del libro
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * Retorna el autor del libro.
   *
   * @return autor del libro
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Indica si el libro esta disponible.
   *
   * @return true si esta disponible
   */
  public boolean estaDisponible() {
    return disponible;
  }

  /**
   * Marca el libro como prestado.
   *
   * @throws IllegalStateException si el libro ya esta prestado
   */
  public void prestar() {
    if (!disponible) {
      throw new IllegalStateException("Libro no disponible");
    }

    disponible = false;
  }

  /**
   * Marca el libro como disponible.
   */
  public void devolver() {
    disponible = true;
  }

  /**
   * Compara este titulo con otro por contenido.
   *
   * @param otroTitulo titulo que se desea comparar
   * @return true si ambos titulos tienen el mismo contenido
   */
  public boolean esMismoTitulo(String otroTitulo) {
    return Objects.equals(titulo, otroTitulo);
  }
}