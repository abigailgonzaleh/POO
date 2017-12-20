//Abigail Gonzalez Hidalgo - A00819967
//Oscar Canongo Vergara - A01730443
public class Deportivo extends Videojuego{

	protected String tipo, asociacion;

	Deportivo(String nombre, double precio, int anio, String tipo, String asociacion){
		super(nombre, precio, anio);
		this.tipo = tipo;
		//Football basketball etc
		this.asociacion = asociacion;
		//FIFA NBA NFL
	}

	public String getTipo(){
		return tipo;
	}

	public String getAsociacion(){
		return asociacion;
	}

	public String toString(){
		return super.toString()+ " de tipo " + tipo + " de la asociacion " + asociacion;
	}
}