import javax.swing.*;

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

        setVisible(true);
    }
}