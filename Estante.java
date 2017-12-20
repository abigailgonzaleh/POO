//Abigail Gonzalez Hidalgo - A00819967
//Oscar Canongo Vergara - A01730443
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Estante{
    private ArrayList<Videojuego> estante;
    Estante(){
        estante= new ArrayList<Videojuego>();
    }

    public ArrayList getArrayList(){
        return estante;
    }

    public String getNombre(int x){
        String nombre=estante.get(x).getNombre();
        return nombre;
    }
    public double getPrecio(int x){
        double precio=estante.get(x).getPrecio();
        return precio;
    }

    public int getAnio(int x){
        int anio=estante.get(x).getAnio();
        return anio;
    }

    public Videojuego getObjeto(int x){
        Videojuego tem;
        tem = estante.get(x);
        return tem;
    }

    public int getTamanio(){
        return estante.size();
    }

    public void insertar(Videojuego miVideojuego){
        estante.add(miVideojuego);
    }

    public void eliminar(int x){
        int y = 0;
        while(y==0){
            try{
                if(estante.get(x)!=null)
                    estante.remove(x);
                else
                    JOptionPane.showMessageDialog(null, "El elemento no existe");
                y=1;
            }
            catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No tienes videojuegos.");
                continue;
            }
            catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null,"El dato que introduciste es incorrecto.");
                continue;
            } 
            catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(null,"No hay mas caracteres en la entrada");
                continue;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No tiene el formato correcto para parsear.");
                continue;
            }
        }
    }

    public void mostrar(){
      if(estante.size()!=0){
         String cadenota ="";
         for (int i=0;i<estante.size();i++){
          cadenota+= i+")"+estante.get(i).toString()+"\n";
}
JOptionPane.showMessageDialog(null, cadenota);
}
else
    JOptionPane.showMessageDialog(null, "No tienes videojuegos");
}

public void ordenarPrecio(){
    if(estante.size()>1){
        boolean swapped=true;
        Videojuego tem;
        while(swapped==true){
            swapped=false;
            for (int i=0; i < estante.size()-1; i++){
                if (getPrecio(i) > getPrecio(i+1)){ 
                    tem=estante.get(i);
                    estante.set(i,estante.get(i+1));
                    estante.set(i+1, tem);
                    swapped=true;
                }
            }
        }
        mostrar();
    }
    else{
        JOptionPane.showMessageDialog(null,"No hay elementos suficientes para ordenar");
    }
}

public void ordenarAnio(){
    if(estante.size()>1){
        boolean swapped=true;
        Videojuego tem;
        while(swapped==true){
            swapped=false;
            for (int i=0; i < estante.size()-1; i++){
                if (getAnio(i) > getAnio(i+1)){ 
                    tem=estante.get(i);
                    estante.set(i,estante.get(i+1));
                    estante.set(i+1, tem);
                    swapped=true;
                }
            }
        }
        mostrar();
        mostrar();
    }
    else{
        JOptionPane.showMessageDialog(null,"No hay elementos suficientes para ordenar");
    }
} 

public void ordenarNombre(){
    if(estante.size()>1){
        boolean swapped=true;
        Videojuego tem;
        while(swapped==true){
            swapped=false;
            for(int i=0;i<estante.size()-1;i++){
                if(getNombre(i).compareToIgnoreCase(getNombre(i+1))==1){
                    tem=estante.get(i);
                    estante.set(i, estante.get(i+1));
                    estante.set(i+1, tem);
                    swapped=true;
                }
            }  
        }
        mostrar();
    }
    else{
        JOptionPane.showMessageDialog(null,"No hay elementos suficientes para ordenar");
    }
}

public void buscarPorPrecio(int numero){
    int x=0;
    for (int i=0;i<estante.size();i++) {
        if(numero==getPrecio(i)){
            JOptionPane.showMessageDialog(null, estante.get(i).toString());
            x++;
        }
    }
    if(x==0) JOptionPane.showMessageDialog(null,"No se encontraron coincidencias");
}

public void buscarPorAnio(int numero){
    int x=0;
    for (int i=0;i<estante.size();i++) {
        if(numero==getAnio(i)){
            JOptionPane.showMessageDialog(null, estante.get(i).toString());
            x++;
        }
    }
    if(x==0) JOptionPane.showMessageDialog(null,"No se encontraron coincidencias");
}

public void buscarPorNombre(String nombre){
    int x=0;
    String mininombre=nombre.toLowerCase();
    int index;
    for (int i=0;i<estante.size();i++){
        String nombrecito=getNombre(i).toLowerCase();
        index =nombrecito.indexOf(mininombre); 
        if (index!=-1) {
            JOptionPane.showMessageDialog(null, i+ ") "+getNombre(i).toString());
            x++;
        }
    }
    if(x==0){
        JOptionPane.showMessageDialog(null,"No se encontraron coincidencias");
    }
}

public void guardar(){
    Scanner sc = new Scanner(System.in);
    String arch_out = JOptionPane.showInputDialog(null, "Nombre del archivo?");
    String stmp;
    File arch_sal = new File(arch_out);

    try {
        PrintWriter writer = new PrintWriter (arch_sal, "UTF-8");                    
        for (int i=0; i<estante.size(); i++){
            writer.println(estante.get(i));
        }
        writer.close();
    } 
    catch (IOException e) {
        System.err.println(e);
        System.exit(1);
    }

    JOptionPane.showMessageDialog(null,"Tu archivo ha sido guardado exitosamente!");
}
}