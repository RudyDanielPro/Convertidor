package Clases.Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionalidadINS implements ActionListener {

    private JPanel panelBotones, panelBotonesInstrucciones;
    private JScrollPane scrollPaneInstrucciones;

    public FuncionalidadINS(JPanel panelBotones, JScrollPane scrollPaneInstrucciones, JPanel panelBotonesInstrucciones) {
        this.panelBotones = panelBotones;
        this.scrollPaneInstrucciones = scrollPaneInstrucciones;
        this.panelBotonesInstrucciones = panelBotonesInstrucciones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelBotones.setVisible(false);
        scrollPaneInstrucciones.setVisible(true);
        panelBotonesInstrucciones.setVisible(true);

        // Forzar la actualización de la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            scrollPaneInstrucciones.getParent().revalidate();
            scrollPaneInstrucciones.getParent().repaint();
            panelBotonesInstrucciones.getParent().revalidate();
            panelBotonesInstrucciones.getParent().repaint();
        });
    }
}