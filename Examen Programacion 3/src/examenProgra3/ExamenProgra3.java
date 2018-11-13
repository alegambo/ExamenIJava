package examenProgra3;

import examenProgra3.control.ControladorAplicacion;
import examenProgra3.vista.VentanaAplicacion;
import examenProgra3.vista.VentanaDatos;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ExamenProgra3 {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            mostrarInterfaz();
        });
    }

    public static void mostrarInterfaz() {
        new VentanaAplicacion("Examen EIF 206",new ControladorAplicacion()).init();
        new VentanaDatos("").init();
    }
}
