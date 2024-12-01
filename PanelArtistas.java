import javax.swing.*;
import java.awt.event.*;

public class PanelArtistas extends JPanel {
    DefaultListModel<String> modeloArtistas;
    JList<String> listaArtistas;
    JButton botonNuevoArtista;

    public PanelArtistas() {
        modeloArtistas = new DefaultListModel<>();
        listaArtistas = new JList<>(modeloArtistas);
        botonNuevoArtista = new JButton("Nuevo Artista");

        setLayout(new java.awt.BorderLayout());
        add(new JLabel("Artistas"), java.awt.BorderLayout.NORTH);
        add(new JScrollPane(listaArtistas), java.awt.BorderLayout.CENTER);
        add(botonNuevoArtista, java.awt.BorderLayout.SOUTH);


    }
}