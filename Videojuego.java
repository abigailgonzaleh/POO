//Abigail Gonzalez Hidalgo - A00819967
//Oscar Canongo Vergara - A01730443
public abstract class Videojuego implements Videojuego2{

    protected String nombre;
    protected double precio;
    protected int anio;

    Videojuego (String nombre, double precio, int anio){
        this.nombre = nombre;
        this.precio = precio;
        this.anio = anio;
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public int getAnio(){
        return anio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public String toString(){
        return ("El Videojuego con nombre " + nombre + " con precio de " + precio + " que salio en el anio " + anio);
    }
}