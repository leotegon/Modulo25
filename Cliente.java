package modulo25;
import java.io.Serializable;
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private int idade;
	
	public Cliente(){}
	
	public Cliente(int id, String nome, int idade){
		
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	//Getters and Setters omitidos 
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("========== Dados do cliente " + id + "==========\n");
		sb.append("\tEndereco memoria: " + super.toString());
		sb.append("\n\tNOME: " + nome);
		sb.append("\n\tIDADE: "+ idade);
		return sb.toString();
	}
}
