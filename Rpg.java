//Abigail Gonzalez Hidalgo - A00819967
//Oscar Canongo Vergara - A01730443
public class Rpg extends Videojuego{
	
	protected String tipo, persona;
	
	Rpg(String nombre, double precio, int anio, String tipo, String persona){
		super(nombre, precio, anio);
		this.tipo = tipo;
		//Rol-accion MMORPG Rol-tacticos
		this.persona = persona;
		//Primera o tercera
	}

	public String getTipo(){
		return tipo;
	}

	public String getPersona(){
		return persona;
	}

	public String toString(){
		return super.toString()+" de tipo " + tipo + " de persona " + persona;
	}
}