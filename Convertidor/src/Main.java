import javax.swing.SwingUtilities;

import Clases.Interfaz.InterfazP;

public class Main {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> new InterfazP().setVisible(true));
    }
}
