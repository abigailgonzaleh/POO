//Abigail Gonzalez Hidalgo - A00819967
//Oscar Canongo Vergara - A01730443
import java.io.*;
import java.util.*;
import javax.swing.*;
public class EstanteFav<T>{

    private ArrayList<T> lista= new ArrayList<T>();
    private int tope;


    EstanteFav(int tope) {
        super();
        this.tope = tope;
    }

    public int getTamanio(){
        return lista.size();
    }

    public void add(T objeto ) {
        if (lista.size()<=tope) {

            lista.add(objeto);
        }else {

            throw new RuntimeException("Solo pudes agregar 5 juegos a favoritos");
        }
    }

    public void agregar(T objeto){
        lista.add(objeto);
    }

    public void remove(int x){
        if (lista.get(x)!=null){
            lista.remove(x);
        }
        else{
           JOptionPane.showMessageDialog(null, "No tienes videojuegos");

           
        }
    }

    public void imprimirEstanteFav(){
        if(lista.size()!=0){
         String cadenota ="";
            for (int i=0;i<lista.size();i++){
              cadenota+= i+")"+lista.get(i).toString()+"\n";
            }
          JOptionPane.showMessageDialog(null, cadenota);
        }
      else
        JOptionPane.showMessageDialog(null, "No tienes videojuegos guardados en favoritos");
    }
}
              
    