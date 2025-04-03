package Clases.Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionalidadSalir implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Salir")) {
            System.exit(0);
        }
    }
}
