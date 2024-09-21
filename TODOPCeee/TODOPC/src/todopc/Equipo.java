package todopc;

public class Equipo {
    //Atributos
    private String fabricante;
    private String modelo;
    private String microProcesador;
    
    //Constructor inicial
    public Equipo(String fabricante, String modelo, String microProcesador){
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microProcesador = microProcesador;
    }
    
    //Metodos para retornar valores
    public String getFabricante(){
        return fabricante;
    }   
    public String getModelo(){
        return modelo;
    }    
    public String getMicroProcesador(){
        return microProcesador;
    }
}
