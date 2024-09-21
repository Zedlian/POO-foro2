package todopc;

public class Tablets extends Equipo{
    //Atributos o declaracion de variables
    private String tamanoPantallaDiagonal;
    private String tipoPantalla;
    private String tamanoMemoriaNand;
    private String sistemaOperativo;
    
    //Constructor iniciador de valores    
    public Tablets(String fabricante, String modelo, String microProcesador, String tamanoPantallaDiagonal, String tipoPantalla, String TamanoMemoriaNand, String sistemaOperativo){
        super(fabricante, modelo, microProcesador);
        this.tamanoPantallaDiagonal = tamanoPantallaDiagonal;
        this.tipoPantalla = tipoPantalla;
        this.tamanoMemoriaNand = TamanoMemoriaNand;
        this.sistemaOperativo = sistemaOperativo;
    }
    
    //Metodos para retornar valores    
    public String getTamanoPantallaDiagonal(){
        return tamanoPantallaDiagonal;
    }
    public String getTipoPantalla(){
        return tipoPantalla;
    }
    public String getTamanoMemoriaNand(){
        return tamanoMemoriaNand;
    }
    public String getSistemaOperativo(){
        return sistemaOperativo;
    }
}
