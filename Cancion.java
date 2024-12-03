public class Cancion {
    String titulo;
    String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerArtista() {
        return artista;
    }
}
