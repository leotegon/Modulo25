package modulo25;

public class Pessoa {

	private int id;
	private String nome;
	
	public Pessoa(int id, String nome){
		
		this.id = id;
		this.nome = nome;
	}
	
	public Pessoa(){}
	
	public void exibeInformacoes(){
		
		System.out.println("Id: " + id);
		System.out.println("Nome: " + nome);
	} 
}
