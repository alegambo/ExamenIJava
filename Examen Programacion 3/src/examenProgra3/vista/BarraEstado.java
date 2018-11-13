package examenProgra3.vista;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class BarraEstado extends JPanel {

    public BarraEstado() {
        if (BTN_VERDE == null) {
            BTN_VERDE = new ImageIcon(getClass().getResource("icons/dot_green_16px.png"), null);
        }
        if (BTN_ROJO == null) {
            BTN_ROJO = new ImageIcon(getClass().getResource("icons/dot_red_16px.png"), null);
        }

        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        add(estadoEdicion = new JLabel());
        add(etqEstado = new JLabel());

        indicarCambios(false);
        mostrarMensaje("Programa Iniciado");
    }
    
    public void indicarCambios(boolean nuevoEstado) {
        hayCambios = nuevoEstado;
        estadoEdicion.setIcon(hayCambios ? BTN_ROJO : BTN_VERDE);
    }

    public void mostrarMensaje(String mensaje) {
        etqEstado.setText(String.format("%s ", mensaje));
    }

    public void mostrarMensaje() {
        mostrarMensaje("");
    }

    public void borrarMensaje() {
        mostrarMensaje("");
    }
    private JLabel estadoEdicion;
    private JLabel etqEstado;

    private boolean hayCambios = false; //booleano para el metodo indicarCambios
    private static ImageIcon BTN_VERDE = null; //Imagen
    private static ImageIcon BTN_ROJO = null; //Imagen
}
