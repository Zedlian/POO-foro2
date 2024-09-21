package todopc;

public class Laptops extends Equipo {
    //Atributos o declaracion de variables
    private String memoria;
    private String tamanoPantalla;
    private String capacidadDiscoDuro;
    
    //Constructor iniciador de valores
    public Laptops(String fabricante, String modelo, String microProcesador, String memoria, String tamanoPantalla, String capacidadDiscoDuro){
        super(fabricante, modelo, microProcesador);
        this.memoria = memoria;
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }
    
    //Metodos para retornar valores
    public String getMemoria(){
        return memoria;
    }
    public String getTamanoPantalla(){
        return tamanoPantalla;
    }
    public String getCapacidadDiscoDuro(){
        return capacidadDiscoDuro;
    }
    
}
