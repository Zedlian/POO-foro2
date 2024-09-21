package todopc;

//Librerias adicionales
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TODOPC {   
    //Atributos de Listas
    private static ArrayList<Desktops> desktops = new ArrayList<>();
    private static ArrayList<Laptops> laptops = new ArrayList<>();
    private static ArrayList<Tablets> tablets = new ArrayList<>();
    
    //Menu Principal y Clase Principal
    public static void main(String[] args) {
        while(true){
            String opcion = JOptionPane.showInputDialog(null, "Seleccione una opcion: \n 1. Ingresar Equipo \n 2. Ver Equipo \n 3. Actualizar Equipo \n 4. Eliminar Equipo \n 5. Salir");
            
            if(opcion == null || opcion.equals("6")){
                break;
            }
            switch(opcion){
                case "1":
                    registrarEquipo();
                    break;
                case "2":
                    verEquipo();
                    break;
                case "3":
                    actualizarEquipo();
                    break;
                case "4":
                    eliminarEquipo();
                    break;
                case "5":
                    salir();
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion ingresada no es valida");
            }
        }
    }
    
    //------------------------------------------------------------------------------------------------------
    //Registrar Equipo en Sistema
        private static void registrarEquipo(){
            String tipoEquipo = JOptionPane.showInputDialog(null, "Seleccione el tipo de Equipo: \n 1. Desktop \n 2. Laptop \n 3. Tablet");
            
            if(tipoEquipo == null){
                return;
            }
            switch(tipoEquipo){
                case "1":
                    registrarDesktop();
                    break;
                case "2":
                    registrarLaptop();
                    break;
                case "3":
                    registrarTablet();
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion ingresada no es valida");
            }
        }
        
        //Registro de Desktop
        private static void registrarDesktop(){
            //Solicitar y validar datos
            String fabricante = solicitarDato("Fabricante");
            String modelo = solicitarDato("Modelo");
            String microprocesador = solicitarDato("Microprocesador");
            String memoria = solicitarDato("Memoria");
            String tarjetaGrafica = solicitarDato("Targeta Grafica");
            String tamanoTorre = solicitarDato("Tamaño de Torre");
            String capacidadDiscoDuro = solicitarDato("Capacidad de Disco Duro");
            
            //Crear y Añadir Desktop
            desktops.add(new Desktops(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamanoTorre, capacidadDiscoDuro));
            JOptionPane.showMessageDialog(null, "Desktop Registrada Exitosamente");
        }
        
        //Registro de Laptop
        private static void registrarLaptop(){
            String fabricante = solicitarDato("fabricante");
            String modelo = solicitarDato("Modelo");
            String microprocesador = solicitarDato("Microprocesador");
            String memoria = solicitarDato("Memoria");
            String tamanoPantalla = solicitarDato("Tamaño de Pantalla");
            String capacidadDiscoDuro = solicitarDato("Capacidad de Disco Duro");
            
            //Crear y Añadir Laptop
            laptops.add(new Laptops(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDiscoDuro));
            JOptionPane.showMessageDialog(null, "Laptop Registrada Exitosamente");
            
        }
        
        //Registro de Tablet
        private static void registrarTablet(){
            String fabricante = solicitarDato("fabricante");
            String modelo = solicitarDato("Modelo");
            String microprocesador = solicitarDato("Microprocesador");
            String tamanoPantallaDiagonal = solicitarDato("Tamaño de Pantalla Diagonal");
            String tipoPantalla = solicitarDato("Tipo de Pantalla");
            String tamanoMemoriaNand = solicitarDato("Tamaño de Memoria Nand");
            String sistemaOperativo = solicitarDato("Sistema Operativo");
            
            //Crear y Añadir Tablet
            tablets.add(new Tablets(fabricante, modelo, microprocesador, tamanoPantallaDiagonal, tipoPantalla, tamanoMemoriaNand, sistemaOperativo));
        JOptionPane.showMessageDialog(null, "Tablet Registrada Exitosamente");
        }
        
        //Validacion al solicitar dato
        private static String solicitarDato(String campo){
            String dato;
            do {                
                dato = JOptionPane.showInputDialog(null, "Ingrese "+campo+":");
                if(dato == null || dato.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "El campo "+campo+" no puede estar vacio");
                }                
            } while (dato == null || dato.trim().isEmpty());
            return dato;
        } 
     
    //------------------------------------------------------------------------------------------------------
    //Ver Equipo en Sistema
        private static void verEquipo(){
            String tipoEquipo = JOptionPane.showInputDialog(null, "Seleccione el tipo de Equipo: \n 1. Desktop \n 2. Laptop \n 3. Tablet");
            
            if(tipoEquipo == null){
                return;
            }
            switch(tipoEquipo){
                case "1":
                    verListaEquipos(desktops, "Desktops");
                    break;
                case "2":
                    verListaEquipos(laptops, "Laptops");
                    break;
                case "3":
                    verListaEquipos(tablets, "Tablets");
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion ingresada no es valida");            
            }  
    }
    
    private static <T extends Equipo> void verListaEquipos(ArrayList<T> lista, String tipo) {
    if (lista.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay " + tipo + " registrados.");
    } else {
        StringBuilder sb = new StringBuilder(tipo + " registrados:\n");
        
        // Agregar encabezado de tabla
        if (tipo.equals("Desktops")) {
            sb.append(String.format("%-15s %-25s %-25s %-25s %-25s %-25s %-25s %-25s\n", 
                "Índice", "Fabricante", "Modelo", "MicroProcesador", "Memoria", "Targeta Grafica", "Tamaño de Torre", "Capacidad de Disco Duro"));
        } else if (tipo.equals("Laptops")) {
            sb.append(String.format("%-15s %-25s %-25s %-25s %-25s %-25s %-25s\n", 
                "Índice", "Fabricante", "Modelo", "MicroProcesador", "Memoria", "Tamaño de Pantalla", "Capacidad de Disco Duro"));
        } else if (tipo.equals("Tablets")) {
            sb.append(String.format("%-15s %-25s %-25s %-25s %-25s %-25s %-25s %-25s\n", 
                "Índice", "Fabricante", "Modelo", "MicroProcesador", "Tamaño Diagonal de Pantalla", "Tipo de Pantalla", "Tamaño Memoria NAND", "Sistema Operativo"));
        }

        int index = 1;  // Índice de posición
        for (T equipo : lista) {
            if (equipo instanceof Desktops) {
                Desktops desktop = (Desktops) equipo;
                sb.append(String.format("%-15s %-25s %-25s %-25s %-25s %-25s %-25s %-25s\n", 
                    index, desktop.getFabricante(), desktop.getModelo(), desktop.getMicroProcesador(), 
                    desktop.getMemoria(), desktop.getTargetaGrafica(), 
                    desktop.getTamanoTorre(), desktop.getCapacidadDiscoDuro()));
            } else if (equipo instanceof Laptops) {
                Laptops laptop = (Laptops) equipo;
                sb.append(String.format("%-15s %-25s %-25s %-25s %-25s %-25s %-25s\n", 
                    index, laptop.getFabricante(), laptop.getModelo(), laptop.getMicroProcesador(), 
                    laptop.getMemoria(), laptop.getTamanoPantalla(), 
                    laptop.getCapacidadDiscoDuro()));
            } else if (equipo instanceof Tablets) {
                Tablets tablet = (Tablets) equipo;
                sb.append(String.format("%-15s %-25s %-25s %-25s %-25s %-25s %-25s %-25s\n", 
                    index, tablet.getFabricante(), tablet.getModelo(), tablet.getMicroProcesador(), 
                    tablet.getTamanoPantallaDiagonal(), tablet.getTipoPantalla(), 
                    tablet.getTamanoMemoriaNand(), tablet.getSistemaOperativo()));
            }
            index++;  // Incrementar el índice de posición
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
    
    //------------------------------------------------------------------------------------------------------
    //Actualizar Equipo en Sistema
        private static void actualizarEquipo() {
    String tipoEquipo = JOptionPane.showInputDialog(null, "Seleccione el tipo de Equipo para actualizar: \n 1. Desktop \n 2. Laptop \n 3. Tablet");

    if (tipoEquipo == null) {
        return;
    }

    ArrayList<?> lista = null;
    String tipoLista = "";

    switch (tipoEquipo) {
        case "1":
            lista = desktops;
            tipoLista = "Desktops";
            break;
        case "2":
            lista = laptops;
            tipoLista = "Laptops";
            break;
        case "3":
            lista = tablets;
            tipoLista = "Tablets";
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción ingresada no es válida");
            return;
    }

    // Mostrar la lista de equipos y solicitar el índice
    verListaEquipos((ArrayList<Equipo>) lista, tipoLista); // Muestra la lista antes de actualizar
    String indiceStr = JOptionPane.showInputDialog(null, "Ingrese el índice del " + tipoLista + " a actualizar:");

    if (indiceStr != null) {
        try {
            int indice = Integer.parseInt(indiceStr) - 1; // Convertir a índice (base 0)

            if (indice >= 0 && indice < lista.size()) {
                // Obtener el equipo actual
                Equipo equipo = (Equipo) lista.get(indice);

                // Solicitar nuevos datos
                String fabricante = solicitarDato("Fabricante (actual: " + equipo.getFabricante() + ")");
                String modelo = solicitarDato("Modelo (actual: " + equipo.getModelo() + ")");
                String microprocesador = solicitarDato("Microprocesador (actual: " + equipo.getMicroProcesador() + ")");

                // Dependiendo del tipo de equipo, solicitar datos específicos
                if (equipo instanceof Desktops) {
                    Desktops desktop = (Desktops) equipo;
                    String memoria = solicitarDato("Memoria (actual: " + desktop.getMemoria() + ")");
                    String tarjetaGrafica = solicitarDato("Tarjeta Gráfica (actual: " + desktop.getTargetaGrafica() + ")");
                    String tamanoTorre = solicitarDato("Tamaño de Torre (actual: " + desktop.getTamanoTorre() + ")");
                    String capacidadDiscoDuro = solicitarDato("Capacidad de Disco Duro (actual: " + desktop.getCapacidadDiscoDuro() + ")");
                    desktops.set(indice, new Desktops(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamanoTorre, capacidadDiscoDuro));
                } else if (equipo instanceof Laptops) {
                    Laptops laptop = (Laptops) equipo;
                    String memoria = solicitarDato("Memoria (actual: " + laptop.getMemoria() + ")");
                    String tamanoPantalla = solicitarDato("Tamaño de Pantalla (actual: " + laptop.getTamanoPantalla() + ")");
                    String capacidadDiscoDuro = solicitarDato("Capacidad de Disco Duro (actual: " + laptop.getCapacidadDiscoDuro() + ")");
                    laptops.set(indice, new Laptops(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDiscoDuro));
                } else if (equipo instanceof Tablets) {
                    Tablets tablet = (Tablets) equipo;
                    String tamanoPantallaDiagonal = solicitarDato("Tamaño de Pantalla Diagonal (actual: " + tablet.getTamanoPantallaDiagonal() + ")");
                    String tipoPantalla = solicitarDato("Tipo de Pantalla (actual: " + tablet.getTipoPantalla() + ")");
                    String tamanoMemoriaNand = solicitarDato("Tamaño de Memoria NAND (actual: " + tablet.getTamanoMemoriaNand() + ")");
                    String sistemaOperativo = solicitarDato("Sistema Operativo (actual: " + tablet.getSistemaOperativo() + ")");
                    tablets.set(indice, new Tablets(fabricante, modelo, microprocesador, tamanoPantallaDiagonal, tipoPantalla, tamanoMemoriaNand, sistemaOperativo));
                }
                JOptionPane.showMessageDialog(null, tipoLista + " actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Índice no válido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
            e.printStackTrace(); // Imprimir la traza del error en la consola
        }
    }
}   
    
    //------------------------------------------------------------------------------------------------------
     //Eliminar Equipo en Sistema
        private static void eliminarEquipo(){
            String tipoEquipo = JOptionPane.showInputDialog(null, "Seleccione el tipo de Equipo: \n 1. Desktop \n 2. Laptop \n 3. Tablet");
            
            if(tipoEquipo == null){
                return;
            }
            
            ArrayList<?> lista = null;
            String tipoLista = null;
            
            switch (tipoEquipo) {
        case "1":
            lista = desktops;
            tipoLista = "Desktops";
            break;
        case "2":
            lista = laptops;
            tipoLista = "Laptops";
            break;
        case "3":
            lista = tablets;
            tipoLista = "Tablets";
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción ingresada no es válida");
            return;
    }
            // Mostrar la lista de equipos y solicitar el índice
    verListaEquipos((ArrayList<Equipo>) lista, tipoLista); // Muestra la lista antes de eliminar
    String indiceStr = JOptionPane.showInputDialog(null, "Ingrese el índice del " + tipoLista + " a eliminar:");

    if (indiceStr != null) {
        try {
            int indice = Integer.parseInt(indiceStr) - 1; // Convertir a índice (base 0)

            if (indice >= 0 && indice < lista.size()) {
                // Eliminar el equipo
                ((ArrayList<Equipo>) lista).remove(indice);
                JOptionPane.showMessageDialog(null, tipoLista + " eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Índice no válido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
        }
    }
    
        }
    
    //------------------------------------------------------------------------------------------------------
    //Salir del Sistema
        private static void salir(){
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    
    
    
    
    
    
    

        
        
                



        

}
    

