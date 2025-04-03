package Clases.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FuncionalidadCON implements ActionListener {

    private JPanel panelBotones;
    private JFrame frame;
    private JTextField decimalField;
    private JTextField binarioField;
    private JTextField hexadecimalField;

    public FuncionalidadCON(JPanel panelBotones, JFrame frame) {
        this.panelBotones = panelBotones;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelBotones.setVisible(false); // Ocultar botones principales

        // Crear cuadros de texto con tamaños preferidos
        decimalField = new JTextField("Número Decimal");
        decimalField.setPreferredSize(new Dimension(200, 30)); // Ancho: 200, Alto: 30
        decimalField.setForeground(Color.DARK_GRAY); // Color de fuente gris oscuro para simular sombra

        binarioField = new JTextField("Número Binario");
        binarioField.setPreferredSize(new Dimension(200, 30));
        binarioField.setForeground(Color.DARK_GRAY);

        hexadecimalField = new JTextField("Número Hexadecimal");
        hexadecimalField.setPreferredSize(new Dimension(200, 30));
        hexadecimalField.setForeground(Color.DARK_GRAY);

        // Agregar FocusListener para manejar el efecto de sombra
        decimalField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (decimalField.getText().equals("Número Decimal")) {
                    decimalField.setText("");
                    decimalField.setForeground(Color.BLACK);
                    binarioField.setForeground(Color.BLACK);
                    hexadecimalField.setForeground(Color.BLACK);
                    binarioField.setText("");
                    hexadecimalField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (decimalField.getText().isEmpty()) {
                    decimalField.setText("Número Decimal");
                    decimalField.setForeground(Color.DARK_GRAY);
                }
            }
        });

        binarioField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (binarioField.getText().equals("Número Binario")) {
                    binarioField.setText("");
                    binarioField.setForeground(Color.BLACK);
                    decimalField.setForeground(Color.BLACK);
                    hexadecimalField.setForeground(Color.BLACK);
                    decimalField.setText("");
                    hexadecimalField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (binarioField.getText().isEmpty()) {
                    binarioField.setText("Número Binario");
                    binarioField.setForeground(Color.DARK_GRAY);
                }
            }
        });

        hexadecimalField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (hexadecimalField.getText().equals("Número Hexadecimal")) {
                    hexadecimalField.setText("");
                    hexadecimalField.setForeground(Color.BLACK);
                    decimalField.setForeground(Color.BLACK);
                    binarioField.setForeground(Color.BLACK);
                    decimalField.setText("");
                    binarioField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (hexadecimalField.getText().isEmpty()) {
                    hexadecimalField.setText("Número Hexadecimal");
                    hexadecimalField.setForeground(Color.DARK_GRAY);
                }
            }
        });

        // Crear botón Menu
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volver a mostrar botones principales y ocultar cuadros de texto
                panelBotones.setVisible(true);
                decimalField.setVisible(false);
                binarioField.setVisible(false);
                hexadecimalField.setVisible(false);
                menuButton.setVisible(false);
            }
        });

        // Crear panel para organizar los cuadros de texto y el botón verticalmente
        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel, BoxLayout.Y_AXIS)); // Organización vertical
        textFieldsPanel.add(decimalField);
        textFieldsPanel.add(Box.createVerticalStrut(10)); // Espacio vertical entre los cuadros de texto
        textFieldsPanel.add(binarioField);
        textFieldsPanel.add(Box.createVerticalStrut(10));
        textFieldsPanel.add(hexadecimalField);

        // Crear panel para centrar el botón Menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrar el botón
        menuPanel.add(menuButton);
        menuPanel.setOpaque(false); // Hacer el panel transparente

        textFieldsPanel.add(Box.createVerticalStrut(10)); // Espacio vertical antes del botón
        textFieldsPanel.add(menuPanel); // Agregar el panel del botón

        // Hacer el panel transparente
        textFieldsPanel.setOpaque(false);

        // Agregar panel al frame
        frame.getContentPane().add(textFieldsPanel);

        // Mostrar panel
        textFieldsPanel.setVisible(true);

        // Actualizar frame
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
}