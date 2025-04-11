package Clases.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Clases.Convertidor.Binario;
import Clases.Convertidor.Decimal;
import Clases.Convertidor.Hexadecimal;

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
        panelBotones.setVisible(false);

        decimalField = new JTextField("Número Decimal");
        decimalField.setPreferredSize(new Dimension(200, 30));
        decimalField.setForeground(Color.DARK_GRAY);

        binarioField = new JTextField("Número Binario");
        binarioField.setPreferredSize(new Dimension(200, 30));
        binarioField.setForeground(Color.DARK_GRAY);

        hexadecimalField = new JTextField("Número Hexadecimal");
        hexadecimalField.setPreferredSize(new Dimension(200, 30));
        hexadecimalField.setForeground(Color.DARK_GRAY);

        agregarFocusListener(decimalField, "Número Decimal");
        agregarFocusListener(binarioField, "Número Binario");
        agregarFocusListener(hexadecimalField, "Número Hexadecimal");

        agregarKeyListener(decimalField, binarioField, hexadecimalField);
        agregarKeyListener(binarioField, decimalField, hexadecimalField);
        agregarKeyListener(hexadecimalField, decimalField, binarioField);

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBotones.setVisible(true);
                decimalField.setVisible(false);
                binarioField.setVisible(false);
                hexadecimalField.setVisible(false);
                menuButton.setVisible(false);
            }
        });

        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel, BoxLayout.Y_AXIS));
        textFieldsPanel.add(decimalField);
        textFieldsPanel.add(Box.createVerticalStrut(10));
        textFieldsPanel.add(binarioField);
        textFieldsPanel.add(Box.createVerticalStrut(10));
        textFieldsPanel.add(hexadecimalField);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuPanel.add(menuButton);
        menuPanel.setOpaque(false);

        textFieldsPanel.add(Box.createVerticalStrut(10));
        textFieldsPanel.add(menuPanel);

        textFieldsPanel.setOpaque(false);

        frame.getContentPane().add(textFieldsPanel);

        textFieldsPanel.setVisible(true);

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    private void agregarFocusListener(JTextField textField, String textoPorDefecto) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(textoPorDefecto)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(textoPorDefecto);
                    textField.setForeground(Color.DARK_GRAY);
                } else {
                    if (decimalField.getText().isEmpty()) {
                        decimalField.setText("Número Decimal");
                        decimalField.setForeground(Color.DARK_GRAY);
                    }
                    if (binarioField.getText().isEmpty()) {
                        binarioField.setText("Número Binario");
                        binarioField.setForeground(Color.DARK_GRAY);
                    }
                    if (hexadecimalField.getText().isEmpty()) {
                        hexadecimalField.setText("Número Hexadecimal");
                        hexadecimalField.setForeground(Color.DARK_GRAY);
                    }
                }
            }
        });
    }

    private void agregarKeyListener(JTextField inputField, JTextField outputField1, JTextField outputField2) {
        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                inputField.setBorder(UIManager.getLookAndFeelDefaults().getBorder("TextField.border"));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputField.setBorder(UIManager.getLookAndFeelDefaults().getBorder("TextField.border"));
                if (inputField == decimalField) {
                    binarioField.setText("");
                    hexadecimalField.setText("");
                } else if (inputField == binarioField) {
                    decimalField.setText("");
                    hexadecimalField.setText("");
                } else if (inputField == hexadecimalField) {
                    decimalField.setText("");
                    binarioField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                convertirNumero(inputField, outputField1, outputField2);

                if (inputField.getText().isEmpty()) {
                    if (inputField != decimalField && decimalField.getText().isEmpty()) {
                        decimalField.setText("Número Decimal");
                        decimalField.setForeground(Color.DARK_GRAY);
                    }
                    if (inputField != binarioField && binarioField.getText().isEmpty()) {
                        binarioField.setText("Número Binario");
                        binarioField.setForeground(Color.DARK_GRAY);
                    }
                    if (inputField != hexadecimalField && hexadecimalField.getText().isEmpty()) {
                        hexadecimalField.setText("Número Hexadecimal");
                        hexadecimalField.setForeground(Color.DARK_GRAY);
                    }
                }
            }
        });
    }

    private void convertirNumero(JTextField inputField, JTextField outputField1, JTextField outputField2) {
        String input = inputField.getText();
        inputField.setBorder(UIManager.getLookAndFeelDefaults().getBorder("TextField.border"));

        if (input.isEmpty()) {
            return;
        }

        try {
            if (inputField == decimalField) {
                if (Decimal.esDecimal(input)) {
                    Decimal decimalConverter = new Decimal();
                    outputField1.setText(new Binario().decimalConvertBinary(Integer.parseInt(input)));
                    outputField2.setText(new Hexadecimal().decimalConvertHexa(Integer.parseInt(input)).toUpperCase());
                } else {
                    mostrarError(inputField, outputField1, outputField2);
                }
            } else if (inputField == binarioField) {
                if (Binario.esBinario(input)) {
                    Decimal decimalConverter = new Decimal();
                    outputField1.setText(String.valueOf(decimalConverter.binaryConvertDecimal(Long.parseLong(input))));
                    Hexadecimal hexadecimalConverter = new Hexadecimal();
                    outputField2.setText(hexadecimalConverter.binaryConvertHexa(input).toUpperCase());
                } else {
                    mostrarError(inputField, outputField1, outputField2);
                }
            } else if (inputField == hexadecimalField) {
                if (Hexadecimal.esHexadecimal(input)) {
                    Decimal decimalConverter = new Decimal();
                    outputField1.setText(String.valueOf(decimalConverter.hexaConvertDecimal(input)));
                    Binario binarioConverter = new Binario();
                    outputField2.setText(binarioConverter.hexaConvertBinary(input));
                } else {
                    mostrarError(inputField, outputField1, outputField2);
                }
            }
        } catch (NumberFormatException ex) {
            mostrarError(inputField, outputField1, outputField2);
        }
    }

    private void mostrarError(JTextField inputField, JTextField outputField1, JTextField outputField2) {
        inputField.setBorder(BorderFactory.createLineBorder(Color.RED));
        outputField1.setText("Número no válido");
        outputField2.setText("Número no válido");
    }
}