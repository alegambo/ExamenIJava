package examenProgra3.vista;

import examenProgra3.control.ControladorAplicacion;
import examenProgra3.modelo.Precipitacion;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaAplicacion extends JFrame {

    public VentanaAplicacion(String titulo, ControladorAplicacion nuevogestor) {
        super(titulo);
        this.gestor=nuevogestor;
    }

    private void ajustarComponentes(Container c) {
        ajustarMenus();
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER,
                panelPrincipal = new JPanel());
        construirFormulario(panelPrincipal);

        c.add(BorderLayout.PAGE_END,
                estado = new BarraEstado());
    }

    private void construirFormulario(JPanel p) {
        p.setLayout(new GridBagLayout());
        GridBagConstraints gc;
        Insets insets = new Insets(8, 8, 0, 8);
/////////////////POSICION DE LOS ELEMENTOS EN LA VENTANA////////////////////////
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(new JLabel("Precipitacion: "), gc);
////////////////////////////////////////////////////////////////////////////////
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = insets;
        p.add(campoPrecipitacion = new JTextField(), gc);
////////////////////////////////////////////////////////////////////////////////
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 0.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(new JLabel("Dia: "), gc);
////////////////////////////////////////////////////////////////////////////////
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = insets;
        p.add(menuDia = new JComboBox(DIAS), gc);
////////////////////////////////////////////////////////////////////////////////
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 0.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(new JLabel("Mes: "), gc);
////////////////////////////////////////////////////////////////////////////////
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(menuMes = new JComboBox(MES), gc);
////////////////////////////////////////////////////////////////////////////////
       
////////////////////////////////////////////////////////////////////////////////
       
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 4;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = insets;
////////////////////////////////////////////////////////////////////////////////
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnBorrar = new JButton("Borrar"));
        panelBotones.add(btnEliminar = new JButton("Eliminar"));
        panelBotones.add(btnAgregar = new JButton("Agregar"));

        p.add(panelBotones, gc);
////////////////////////////////////////////////////////////////////////////////
        /*
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 3;
        gc.weightx = 0.0;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.REMAINDER;
        p.add(new Filler(
                new Dimension(0, 0),
                new Dimension(0, 0),
                new Dimension(32767, 32767)), gc);
         */
        campoPrecipitacion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                estado.indicarCambios(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                estado.indicarCambios(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                estado.indicarCambios(true);
            }

        });
        menuDia.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                estado.indicarCambios(true);
            }

        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarCampos();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarCampos();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capturarRegistro();
            }
        });
    }

    private void ajustarMenus() {
        menuPrincipal = new JMenuBar();
        setJMenuBar(menuPrincipal);

        menuArchivo = new JMenu("Archivo");
        menuArchivo.add(itemSalir = new JMenuItem("Salir")); //el atributo itemSalir lo inicializa
        menuPrincipal.add(menuArchivo);

        menuDatos = new JMenu("Datos");
        menuDatos.add(itemBorrarObs = new JMenuItem("Borrar Datos"));
        menuDatos.add(eliminarObs = new JMenuItem("Eliminar Observaciones"));
        menuPrincipal.add(menuDatos);

        menuAyuda = new JMenu("Ayuda");
        menuAyuda.add(itemAyuda = new JMenuItem("Ayuda"));
        menuAyuda.add(new JSeparator());
        menuAyuda.add(itemAcercaDe = new JMenuItem("Acerca de esta aplicación.."));
        

 //metodo que atiene el evento de los botones-atriutos
 itemBorrarObs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarCampos();
            }
        });
 eliminarObs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarCampos();
            }
        });
        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarAplicacion();
            }
        });

        itemAcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInfo();
            }
        });
    }

    public void init() {
        ajustarComponentes(getContentPane());
        setSize(640, 480);
        // pack();
        setMinimumSize(new Dimension(400, 300));
        setLocationByPlatform(true);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }

        });
        new VentanaDatos("");
        setVisible(true);
    }

    // <editor-fold desc="Manejadores de eventos" defaultstate="collapsed" >
    private void cerrarAplicacion() {

        if (JOptionPane.OK_OPTION
                == JOptionPane.showConfirmDialog( //OK_OPTION pasa a ser una ventana de confirmacion, con varios mensajes dentro
                        this,
                        "¿Desea cerrar la aplicación?", //mensaje principal
                        "Confirmar", //mensaje arriba de la ventana
                        JOptionPane.OK_CANCEL_OPTION, //plantilla de botones
                        JOptionPane.WARNING_MESSAGE, //formato de la ventana
                        null)) {
            System.exit(0);
        }
    }

    private void actualizarFormulario() {
        if (registroActual != null) {
            campoPrecipitacion.setText(registroActual.precipitaciones());
            menuDia.setSelectedIndex(registroActual.dia());
            menuMes.setSelectedIndex(registroActual.mes());
            

            estado.indicarCambios(false);
            campoPrecipitacion.requestFocusInWindow();
            campoPrecipitacion.selectAll();
        } else {
            borrarCampos();
        }
    }

    private void borrarCampos() {
        campoPrecipitacion.setText(null);
        menuMes.setSelectedIndex(0);
        menuDia.setSelectedIndex(0);

        estado.indicarCambios(false);
        campoPrecipitacion.requestFocusInWindow();
    }

    private void capturarRegistro() {
        String precipitacion = campoPrecipitacion.getText();
        int mes = menuMes.getSelectedIndex();
        int dia = menuDia.getSelectedIndex();

        registroActual = new Precipitacion(precipitacion, mes, dia);
        
        estado.indicarCambios(false);
        estado.mostrarMensaje(String.format(
                "Datos capturados: %s",
                registroActual));
    }

    private void mostrarInfo() {
        JOptionPane.showMessageDialog(this, "Examen Progra .");
    }

    // </editor-fold>
    // <editor-fold desc="Atributos" defaultstate="collapsed" >
    private JMenuBar menuPrincipal;
    //
    private JMenu menuArchivo;
    private JMenu menuDatos;
    private JMenu menuAyuda;
    //
    private JMenuItem itemSalir;
    private JMenuItem itemBorrarObs;
    private JMenuItem eliminarObs;
    private final ControladorAplicacion gestor;
    
    private JMenuItem itemAyuda;
    private JMenuItem itemAcercaDe;

    private JPanel panelPrincipal;
    private BarraEstado estado;

    private JTextField campoPrecipitacion;
    private JTextField campoNombre;
    private JComboBox menuDia;
    private JComboBox menuMes;
    private JTextArea campoObservaciones;
    private boolean hayCambios = false;
    private JButton btnBorrar;
    private JButton btnEliminar;
    private JButton btnAgregar;

    private static final String[] DIAS = {
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
             "7",
        "8",
        "9",
        "10",
     "11",
        "12",
        "13",
        "14",
      "15",
        "16",
        "17",
        "19",
        "20",
        "21",
        "22",
        "23",
        "24",
        "25",
        "26",
        "27",
        "28",
        "29",
        "30",
        "31"
    };
    
     private static final String[] MES = {
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
             "7",
        "8",
        "9",
        "10",
     "11",
        "12",
    };

    private Precipitacion registroActual = null;

    // </editor-fold>
}
