/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenProgra3.modelo;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Lista {
    ArrayList<Precipitacion>array;
    public void insertarPrecipitaciones(ArrayList<Precipitacion> precipitaciones){
     array= new ArrayList<Precipitacion>();
     for(Precipitacion p: precipitaciones){
         array.add(new Precipitacion (p.precipitaciones(),p.dia(),p.mes()));
     }

        
    }
    
    public ArrayList getArray(){
        return array;
    }
}
    
    
    
    

