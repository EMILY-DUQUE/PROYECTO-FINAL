import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelListas extends JPanel {
    DefaultListModel<String> modeloListas;
    JList<String> listaListas;
    JButton botonNuevaLista;

    public PanelListas() {
        modeloListas = new DefaultListModel<>();
        listaListas = new JList<>(modeloListas);
        botonNuevaLista = new JButton("Nueva Lista");

        setLayout(new java.awt.BorderLayout());
        add(new JLabel("Listas"), java.awt.BorderLayout.NORTH);
        add(new JScrollPane(listaListas), java.awt.BorderLayout.CENTER);
        add(botonNuevaLista, java.awt.BorderLayout.SOUTH);


                }
            }
