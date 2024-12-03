import java.util.ArrayList;

public class Playlist {
    String nombre;
    ArrayList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public ArrayList<Cancion> obtenerCanciones() {
        return canciones;
    }
}
