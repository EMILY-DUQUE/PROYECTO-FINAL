import javax.swing.*;
import java.awt.event.*;

public class PanelCanciones extends JPanel {
    DefaultListModel<String> modeloCanciones;
    JList<String> listaCanciones;
    JButton botonNuevaCancion;

    public PanelCanciones() {
        modeloCanciones = new DefaultListModel<>();
        listaCanciones = new JList<>(modeloCanciones);
        botonNuevaCancion = new JButton("Nueva Canción");

        setLayout(new java.awt.BorderLayout());
        add(new JLabel("Canciones"), java.awt.BorderLayout.NORTH);
        add(new JScrollPane(listaCanciones), java.awt.BorderLayout.CENTER);
        add(botonNuevaCancion, java.awt.BorderLayout.SOUTH);

        botonNuevaCancion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tituloCancion = JOptionPane.showInputDialog("Título de la canción:");
                if (tituloCancion != null && !tituloCancion.equals("")) {
                    modeloCanciones.addElement(tituloCancion);
                }
            }
        });
    }
}
