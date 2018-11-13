/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenProgra3.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Alejandro
 */
    public class VentanaDatos extends JFrame {
    public VentanaDatos(String titulo){
        super(titulo);
        ajustarComponentes(getContentPane());
        setup();
}
    private void construirFormulario(JPanel p) {
        p.setLayout(new GridBagLayout());
        GridBagConstraints gc;
        Insets insets = new Insets(8, 8, 0, 8);
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(new JLabel("n: "), gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = insets;
        p.add(totaldatos= new JLabel("indeterminado"),gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 0.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(new JLabel("x̄: "), gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(mediaAr = new JLabel("Indeterminado"), gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 0.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(new JLabel("\u03C3: "), gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(desEs = new JLabel("Indeterminado"), gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 3;
        gc.weightx = 0.0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(new JLabel("\u03C3 \u03BC: "), gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 3;
        gc.weightx = 0.1;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = insets;
        p.add(desEs = new JLabel("Indeterminado"), gc);
        
    }
    
    private void setup(){
        setSize(680, 420);
        setMinimumSize(new Dimension(300, 300));
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);        
    }
    public void init(){
        setVisible(true);
    }
    private void ajustarComponentes(Container c){
    c.setLayout(new BorderLayout());
    c.add(BorderLayout.CENTER,
                panelDatos = new JPanel());
    construirFormulario(panelDatos); 
    }
    
    private JPanel panelDatos;
    private JLabel totaldatos;
    private JLabel mediaAr;
    private JLabel desEs;
    private JLabel erDes;
    
}

