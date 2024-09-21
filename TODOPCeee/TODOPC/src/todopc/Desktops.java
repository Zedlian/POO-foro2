package todopc;

public class Desktops extends Equipo {
    //Atributos o declaracion de variables
    private String memoria;
    private String tarjetaGrafica;
    private String tamanoTorre;
    private String capacidadDiscoDuro;
    
    //Constructor iniciador de valores
    public Desktops(String fabricante, String modelo, String microProcesador, String memoria, String tarjetaGrafica, String tamanoTorre, String capacidadDiscoDuro){
        super(fabricante, modelo, microProcesador);
        this.memoria = memoria;
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorre = tamanoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;   
    }
    
    //Metodos para retornar valores
    public String getMemoria(){
        return memoria;
    }    
    public String getTargetaGrafica(){
        return tarjetaGrafica;
    }
    public String getTamanoTorre(){
        return tamanoTorre;
    }   
    public String getCapacidadDiscoDuro(){
        return capacidadDiscoDuro;
    }
}
