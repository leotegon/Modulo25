package modulo25;
import java.io.Serializable;
public class ClienteComEnderecoV2 implements Serializable {
	private int id;
	private String nome;
	private int idade;
	private transient Endereco endereco;
	public ClienteComEnderecoV2(){}
	
	public ClienteComEnderecoV2(int id, String nome, int idade, Endereco endereco){
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}
	//Getters and Setters omitidos 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("========== Dados do cliente " + id + "==========\n");
		sb.append("\tEndereco memoria: " + super.toString());
		sb.append("\n\tNOME: " + nome);
		sb.append("\n\tIDADE: "+ idade);
		sb.append("\n----Endereço----");
		sb.append(endereco);
		return sb.toString();
	}
}

