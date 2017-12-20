//Abigail Gonzalez Hidalgo - A00819967
//Oscar Canongo Vergara - A01730443
public class Shooter extends Videojuego{
    protected int persona;
    protected int jugadores;

    Shooter(String nombre, double precio, int anio, int persona, int jugadores){
        super(nombre, precio, anio);
        this.persona = persona;
        this.jugadores = jugadores;
    }

    public String toString(){
        return super.toString()+ " de tipo " + "Shooter" + " de persona " + persona + " de " + jugadores + " jugadores";
    }
}