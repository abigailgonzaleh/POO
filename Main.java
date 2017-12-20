//Abigail Gonzalez Hidalgo - A00819967
//Oscar Canongo Vergara - A01730443
import java.util.*;
import java.io.*;
import javax.swing.*;
public class Main{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int op, opcion=0;
        Estante miEstante = new Estante();
        EstanteFav miEstanteFav = new EstanteFav(5);
        do{
            do{

                op = menu();

                switch(op){
                    case 1:
                    int x=menuVideojuegos();
                    Videojuego miVideojuego=null;
                    switch(x){
                        case 1:
                        miVideojuego=crearRPG();
                        break;
                        case 2:
                        miVideojuego=crearShooter();
                        break;
                        case 3: 
                        miVideojuego=crearDeportivo();
                        break;
                    }
                    miEstante.insertar(miVideojuego);
                    break;
                    case 2:
                    Integer error2 = 0;
                    while(error2 == 0){
                        try{
                            if(miEstante.getTamanio()>0){
                                miEstante.mostrar();
                                String zz=JOptionPane.showInputDialog(null,"Que videojuego quieres eliminar");
                                if(zz==null) break;
                                else{
                                    int z= Integer.parseInt(zz);
                                    miEstante.eliminar(z);
                                    error2 = 1;
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"No tienes videojuegos");
                                error2 = 1;
                            }
                        }
                        catch (InputMismatchException e) {
                            JOptionPane.showMessageDialog(null,"El dato que introduciste es incorrecto.");
                            continue;
                        } 
                        catch (NoSuchElementException e) {
                            JOptionPane.showMessageDialog(null,"No hay mas caracteres en la entrada.");
                            continue;
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "No tiene el formato correcto.");
                            continue;
                        }
                    }
                    break;
                    case 3:
                    miEstante.mostrar();
                    break;
                    case 4:
                    if(miEstante.getTamanio()!=0){
                        int op2=menuOrdenar();
                        switch(op2){
                            case 1: miEstante.ordenarNombre();
                            break;
                            case 2: miEstante.ordenarPrecio();
                            break;
                            case 3: miEstante.ordenarAnio();
                            break;
                            default: JOptionPane.showMessageDialog(null,"Numero no valido");
                        }   
                    }
                    else JOptionPane.showMessageDialog(null, "No tienes ningun videojuego");
                    break;
                    case 5:
                    int v = 0;
                    if(miEstante.getTamanio()!=0){
                        while(v==0){
                            try{
                                int w=menuBuscar();
                                switch(w){
                                    case 1: 
                                    String nombre=JOptionPane.showInputDialog(null,"Introduce el nombre a buscar");
                                    if(nombre==null) break;
                                    else{
                                        miEstante.buscarPorNombre(nombre);
                                    }
                                    v = 1;
                                    break;
                                    case 2: 
                                    String gg=JOptionPane.showInputDialog(null,"Introduce el precio a buscar");
                                    if(gg==null) break;
                                    else{
                                        int g=Integer.parseInt(gg);
                                        miEstante.buscarPorPrecio(g);
                                    }
                                    v = 1;
                                    break;
                                    case 3:
                                    String dd=JOptionPane.showInputDialog(null,"Introduce el anio a buscar");
                                    if(dd==null) break;
                                    else{
                                        int d=Integer.parseInt(dd);
                                        miEstante.buscarPorAnio(d);
                                    }
                                    v = 1;
                                    break;
                                }  
                            }
                            catch (InputMismatchException e) {
                                JOptionPane.showMessageDialog(null,"El dato que introduciste es incorrecto.");
                                continue;
                            } 
                            catch (NoSuchElementException e) {
                                JOptionPane.showMessageDialog(null, "No hay mas caracteres en la entrada");
                                continue;
                            }
                            catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(null, "No tiene el formato correcto para parsear.");
                                continue;
                            }
                        }

                    }
                    else JOptionPane.showMessageDialog(null, "No tienes ningun videojuego");
                    break;
                    case 6:
                    miEstante.guardar();
                    break;
                    case 7:
                    if(miEstante.getTamanio()!=0){
                        Integer error = 0;
                        JOptionPane.showMessageDialog(null, "Cual juego quieres agregar a favoritos?");
                        miEstante.mostrar();
                        while(error == 0){
                            try{
                                String kk=JOptionPane.showInputDialog(null,"Introduce el indice del juego");
                                if(kk==null) break;
                                else {
                                    int k=Integer.parseInt(kk);
                                    miEstanteFav.agregar(miEstante.getObjeto(k));
                                    error = 1;
                                }
                            }
                            catch (InputMismatchException e) {
                                JOptionPane.showMessageDialog(null,"El dato que introduciste es incorrecto.");
                                continue;
                            } 
                            catch (NoSuchElementException e) {
                                JOptionPane.showMessageDialog(null, "No hay mas caracteres en la entrada");
                                continue;
                            }
                            catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(null, "No tiene el formato correcto para parsear.");
                                continue;
                            }

                        }
                    }
                    else JOptionPane.showMessageDialog(null, "No tienes videojuegos");
                    break;
                    case 8:
                    if(miEstanteFav.getTamanio()!=0){
                        JOptionPane.showMessageDialog(null, "Cual juego quieres remover de favoritos?");
                        miEstanteFav.imprimirEstanteFav();
                        Integer y = 0;
                        while(y == 0){
                            try{
                                String hh=JOptionPane.showInputDialog(null,"Introduce el indice del juego");
                                if(hh==null) break;
                                else{
                                    int h=Integer.parseInt(hh);
                                    miEstanteFav.remove(h);
                                    y = 1;
                                }
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
                    else JOptionPane.showMessageDialog(null, "No tienes videojuegos favoritos");
                    break;

                    case 9: miEstanteFav.imprimirEstanteFav();
                    break;
                }

            } while (op !=0);
            try{

                String zz=JOptionPane.showInputDialog(null,"Estas seguro que quieres salir\n Presiona uno si desea salir");
                if(zz==null) break;
                else{
                    opcion= Integer.parseInt(zz);
                }
            }
            catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null,"El dato que introduciste es incorrecto.");
                continue;
            } 
            catch (NoSuchElementException e) {
                JOptionPane.showMessageDialog(null,"No hay mas caracteres en la entrada.");
                continue;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No tiene el formato correcto.");
                continue;
            }
        }while(opcion !=1);
    }

    public static int menu() {
        int x=0;
        Integer erro = 0;

        while(erro == 0){
           String men="Que quieres hacer?\n1.- Insertar\n2.- Eliminar\n3.-Mostrar todos\n4.-Ordenar\n5.-Buscar\n6.-Guardar\n7.-Agregar a favoritos\n8.-Eliminar de favoritos\n9.-Mostrar favoritos\n0.-Salir\n";
           String xx=JOptionPane.showInputDialog(null, men);

           if(xx==null) break;
           else{
            try{
              x=Integer.parseInt(xx);
              erro = 1;
          } 
          catch (InputMismatchException e) {
              JOptionPane.showMessageDialog(null, "El dato que introduciste es incorrecto.");
              continue;
                    //System.out.println(e.getMessage());
          } 
          catch (NoSuchElementException e) {
           JOptionPane.showMessageDialog(null, "No hay mas caracteres en la entrada");
           continue;
       }
       catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "No tiene el formato correcto para parsear.");
        continue;
    }
}
}
return x;
}

public static int menuOrdenar(){
    int x = 0;
    Integer erro2 = 0;
    while(erro2 == 0){
        String menO = "Bajo que parametros desea ordenar?\n1.- Nombre\n2.- Precio\n3.- Anio\n";
        String x2 = JOptionPane.showInputDialog(null, menO);
        if(x2==null) break;
        else{
            try{
                x = Integer.parseInt(x2);
                erro2 = 1;
            }
            catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null,"El dato que introduciste es incorrecto.");
                continue;
        // System.out.println(e.getMessage());
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
    return x;
}

public static int menuBuscar(){

    int x = 0;
    Integer erro3 = 0;
    while(erro3 == 0){
        String menu = "Bajo que parametros quieres buscar?\n1.- Nombre\n2.- Precio\n3.- Anio";
        String x2 = JOptionPane.showInputDialog(null, menu);
        if(x2==null) break;
        else{
            try{
                x = Integer.parseInt(x2);
                erro3 = 1;
            }
            catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null,"El dato que introduciste es incorrecto.");
                continue;
        // System.out.println(e.getMessage());
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
    return x;
}

public static int menuVideojuegos(){

    int x = 0;
    Integer erro4 = 0;
    while(erro4 == 0){
        String menu = "Que tipo de videojuego quieres agregar?\n1.- RPG\n2.- Shooter\n3.- Deportivo";
        String x2 = JOptionPane.showInputDialog(null, menu);
        if(x2==null) break;
        else{
            try{
                x = Integer.parseInt(x2);
                erro4 = 1;
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
    return x;
}

public static Rpg crearRPG(){
    String nombre = " ";
    double precio = 0.0;
    int anio = 0;
    String tipo = " ";
    String persona = " ";
    Integer erro5 = 0;
    while(erro5 == 0){
        try{
            String nP= "Dime el nombre";
            nombre = JOptionPane.showInputDialog(null,nP);
            if(nombre==null) break;
            else{
                String pP= "Dime el precio";
                String pre=JOptionPane.showInputDialog(null,pP);
                if(pre==null) break;
                else{
                    precio= Double.parseDouble(pre);
                    String ani=JOptionPane.showInputDialog(null,"Dime el anio");
                    if (ani==null) break;
                    else{
                        anio= Integer.parseInt(ani);
                        tipo = JOptionPane.showInputDialog(null,"Dime el tipo de RPG");
                        if (tipo==null) break;
                        else{
                            persona = JOptionPane.showInputDialog(null,"Dime de cuantas personas es el RPG");
                            if(persona==null) break;
                            else
                                erro5 = 1;
                        }
                    }
                }
            }
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
    Rpg miVideojuego = new Rpg(nombre, precio, anio, tipo, persona);
    return miVideojuego;
}

public static Shooter crearShooter(){
    String nombre = " ";
    double precio = 0.0;
    int anio = 0;
    int persona = 0;
    int jugadores = 0;
    Integer erro6 = 0;
    while(erro6 == 0){
        try{
            String nP= "Dime el nombre";
            nombre = JOptionPane.showInputDialog(null,nP);
            if(nombre==null) break;
            else{
                String pP= "Dime el precio";
                String pre=JOptionPane.showInputDialog(null,pP);
                if(pre==null) break;
                else{
                    precio= Double.parseDouble(pre);
                    String ani=JOptionPane.showInputDialog(null,"Dime el anio");
                    if (ani==null) break;
                    else{
                        anio= Integer.parseInt(ani);
                        String per= JOptionPane.showInputDialog(null,"Dime la persona, 1, 2 o 3");
                        if (per==null) break;
                        else{
                            persona=Integer.parseInt(per);
                            String jug = JOptionPane.showInputDialog(null,"Dime el numero de jugadores");
                            if(jug==null) break;
                            else
                                jugadores=Integer.parseInt(jug);
                        }
                    }
                }
            }
            erro6 = 1;
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
    Shooter miVideojuego = new Shooter(nombre, precio, anio, persona, jugadores);
    return miVideojuego;
}

public static Deportivo crearDeportivo(){
    String nombre = " ";
    double precio = 0.0;
    int anio = 0;
    String tipo = " ";
    String asociacion = " ";
    Integer erro7 = 0;
    while(erro7 == 0){
        try{
            String nP= "Dime el nombre";
            nombre = JOptionPane.showInputDialog(null,nP);
            if(nombre==null) break;
            else{
                String pP= "Dime el precio";
                String pre=JOptionPane.showInputDialog(null,pP);
                if(pre==null) break;
                else{
                    precio= Double.parseDouble(pre);
                    String ani=JOptionPane.showInputDialog(null,"Dime el anio");
                    if (ani==null) break;
                    else{
                        anio= Integer.parseInt(ani);
                        tipo= JOptionPane.showInputDialog(null,"Dime el tipo de juego deportivo");
                        if (tipo==null) break;
                        else{
                            asociacion= JOptionPane.showInputDialog(null,"A que asociacion deportiva pertenece?");
                            if(asociacion==null) break;
                        }
                    }
                }
            }
            erro7 = 1;
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
    Deportivo miVideojuego = new Deportivo(nombre, precio, anio, tipo, asociacion);
    return miVideojuego;
}
}
