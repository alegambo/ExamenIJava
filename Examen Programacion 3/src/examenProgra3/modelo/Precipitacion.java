package examenProgra3.modelo;

public class Precipitacion {

    public Precipitacion(String precipitacion,
            int mes,
            int dia
            ) {
        this.precipitacion = precipitacion;
        this.mes = mes;
        this.dia = dia;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        r.append(String.format(
                "%s, %i, %i",
                precipitacion, mes, dia));
        r.append("}");
        return r.toString();
    }

    // <editor-fold desc="Atributos" defaultstate="collapsed" >
    public String precipitaciones() {
        return precipitacion;
    }
    

    public void fijarPrecipitaciones(String precipitacion) {
        this.precipitacion = precipitacion;
    }

    public int mes() {
        return mes;
    }

    public void fijarMes(int mes) {
        this.mes = mes;
    }

    public int dia() {
        return dia;
    }

    public void fijarDia(int dia) {
        this.dia = dia;
    }

    
    
    private String precipitacion;
    private int mes;
    private int dia;
    

    // </editor-fold>
}
