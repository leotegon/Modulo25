package modulo25;

import java.io.Serializable;

public class Cliente3 extends Pessoa implements Serializable{

	private String tipo;
	
	public Cliente3(int id, String nome, String tipo){
		
		super(id, nome);
		this.tipo = tipo;
	}
	
	public Cliente3(){}
	
	public void exibeInformacoes(){
		
		super.exibeInformacoes();
		System.out.println("Tipo: " + tipo);
	}
}
