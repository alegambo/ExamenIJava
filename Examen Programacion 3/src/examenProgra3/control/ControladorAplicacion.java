/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenProgra3.control;

import examenProgra3.modelo.Precipitacion;

/**
 *
 * @author Alejandro
 */
public class ControladorAplicacion {
    public ControladorAplicacion(Precipitacion newData){
        this.modelo= newData;
    }
      public ControladorAplicacion(){}
    private Precipitacion modelo;   
}

