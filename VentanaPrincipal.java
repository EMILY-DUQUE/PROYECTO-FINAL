import javax.swing.*;
import java.io.*;

public class VentanaPrincipal extends JFrame {
    JPanel panelListas;
    JPanel panelArtistas;
    JPanel panelCanciones;

    public VentanaPrincipal() {
        setTitle("Gestor de Música");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelListas = new PanelListas();
        panelArtistas = new PanelArtistas();
        panelCanciones = new PanelCanciones();

        setLayout(new java.awt.BorderLayout());
        add(panelListas, java.awt.BorderLayout.WEST);
        add(panelArtistas, java.awt.BorderLayout.CENTER);
        add(panelCanciones, java.awt.BorderLayout.EAST);

        // Cargar datos al iniciar
        cargarDatos();

        // Agregar un listener para guardar datos al cerrar la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                guardarDatos();
            }
        });

        setVisible(true);
    }

    // Método para guardar los datos en un archivo
    public void guardarDatos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos.txt"))) {
            // Guardar artistas
            writer.write("ARTISTAS\n");
            DefaultListModel<String> modeloArtistas = ((PanelArtistas) panelArtistas).modeloArtistas;
            for (int i = 0; i < modeloArtistas.getSize(); i++) {
                writer.write(modeloArtistas.getElementAt(i));
                writer.newLine();
            }

            // Guardar canciones
            writer.write("CANCIONES\n");
            DefaultListModel<String> modeloCanciones = ((PanelCanciones) panelCanciones).modeloCanciones;
            for (int i = 0; i < modeloCanciones.getSize(); i++) {
                writer.write(modeloCanciones.getElementAt(i));
                writer.newLine();
            }

            // Guardar listas
            writer.write("LISTAS\n");
            DefaultListModel<String> modeloListas = ((PanelListas) panelListas).modeloListas;
            for (int i = 0; i < modeloListas.getSize(); i++) {
                writer.write(modeloListas.getElementAt(i));
                writer.newLine();
            }

            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage());
        }
    }

    // Método para cargar los datos desde un archivo
    public void cargarDatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            String seccion = "";

            while ((linea = reader.readLine()) != null) {
                if (linea.equals("ARTISTAS")) {
                    seccion = "ARTISTAS";
                } else if (linea.equals("CANCIONES")) {
                    seccion = "CANCIONES";
                } else if (linea.equals("LISTAS")) {
                    seccion = "LISTAS";
                } else {
                    if (seccion.equals("ARTISTAS")) {
                        ((PanelArtistas) panelArtistas).modeloArtistas.addElement(linea);
                    } else if (seccion.equals("CANCIONES")) {
                        ((PanelCanciones) panelCanciones).modeloCanciones.addElement(linea);
                    } else if (seccion.equals("LISTAS")) {
                        ((PanelListas) panelListas).modeloListas.addElement(linea);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar los datos: " + e.getMessage());
        }
    }
}
