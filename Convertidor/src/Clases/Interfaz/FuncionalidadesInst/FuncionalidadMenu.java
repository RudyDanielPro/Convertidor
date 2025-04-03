package Clases.Interfaz.FuncionalidadesInst;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionalidadMenu implements ActionListener {

    private JScrollPane scrollPaneInstrucciones;
    private JPanel panelBotones, panelBotonesInstrucciones;

    public FuncionalidadMenu(JScrollPane scrollPaneInstrucciones, JPanel panelBotones, JPanel panelBotonesInstrucciones) {
        this.scrollPaneInstrucciones = scrollPaneInstrucciones;
        this.panelBotones = panelBotones;
        this.panelBotonesInstrucciones = panelBotonesInstrucciones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ocultar el cuadro de texto de instrucciones
        scrollPaneInstrucciones.setVisible(false);

        // Mostrar los botones principales y ocultar los botones de instrucciones
        panelBotones.setVisible(true);
        panelBotonesInstrucciones.setVisible(false);
    }
}