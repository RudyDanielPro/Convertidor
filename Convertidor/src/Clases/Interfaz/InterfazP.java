package Clases.Interfaz;

import javax.swing.*;

import Clases.Interfaz.FuncionalidadesInst.FuncionalidadMenu;

import java.awt.*;

public class InterfazP extends JFrame {
    
    private static final String FONDO_IMAGEN_PATH = "Convertidor\\Convertidor\\src\\Resources\\Fondo.jfif";
    private JButton boton1, boton2, boton3, botonMenu;
    private JPanel panelBotones, panelBotonesInstrucciones;
    private JScrollPane scrollPaneInstrucciones;

    public InterfazP() {
        setTitle("Convertidor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Cargar imagen de fondo y redimensionarla
        ImageIcon fondoImagen = new ImageIcon(FONDO_IMAGEN_PATH);
        Image imagen = fondoImagen.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        ImageIcon fondoEscalado = new ImageIcon(imagen);
        JLabel fondo = new JLabel(fondoEscalado);
        fondo.setLayout(new GridBagLayout());
        setContentPane(fondo);

        // Crear panel para los botones principales
        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // Crear botones principales
        boton1 = new JButton("Convertidor");
        boton2 = new JButton("Instrucciones");
        boton3 = new JButton("Salir");

        // Agregar funcionalidad a los botones principales
        boton1.addActionListener(new FuncionalidadCON(panelBotones, this)); // Agregar listener al botón Convertidor
        boton3.addActionListener(new FuncionalidadSalir());

        // Crear área de texto para instrucciones
        JTextArea instruccionesArea = new JTextArea("La aplicacion esta diseñada en java 22. \nCada boton cuenta con diferentes funcionalidades. \nEn la interfaz de convertir solo admiten numero Decimales,Binarios \ny Hexadecimales, cada area de texto se autocompleta. \nNinguno de los campos de conversion admiten \ncaracteres especiales ni numeros que no cumplan con lo \nespecificado\n\n\nCualquier duda o sugerencia contactar con:\nrudydanielcarballo@gmail.com , o escribir al +53 56498546\nmendez10dev@gmail.com , o escribir al +53 58030795");
        instruccionesArea.setEditable(false);
        Font fuenteInstrucciones = new Font("Arial", Font.PLAIN, 16); // Fuente Arial, tamaño 16
        instruccionesArea.setFont(fuenteInstrucciones);
        scrollPaneInstrucciones = new JScrollPane(instruccionesArea);
        scrollPaneInstrucciones.setPreferredSize(new Dimension(450, 300));
        scrollPaneInstrucciones.setVisible(false);

        //Crear panel para el boton menu
        panelBotonesInstrucciones = new JPanel();
        panelBotonesInstrucciones.setOpaque(false);
        panelBotonesInstrucciones.setLayout(new FlowLayout());
        panelBotonesInstrucciones.setVisible(false);

        //Crear boton menu
        botonMenu = new JButton("Menu");
        botonMenu.addActionListener(new FuncionalidadMenu(scrollPaneInstrucciones, panelBotones, panelBotonesInstrucciones));
        panelBotonesInstrucciones.add(botonMenu);

        // Agregar botones principales al panel
        panelBotones.add(boton1, gbc);
        gbc.gridy++;
        panelBotones.add(boton2, gbc);
        gbc.gridy++;
        panelBotones.add(boton3, gbc);

        // Agregar paneles y área de texto a la ventana
        fondo.add(panelBotones, gbc);
        gbc.gridy++;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        fondo.add(scrollPaneInstrucciones, gbc);
        gbc.gridy++;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        fondo.add(panelBotonesInstrucciones, gbc);

        boton2.addActionListener(new FuncionalidadINS(panelBotones, scrollPaneInstrucciones, panelBotonesInstrucciones));
    }
}