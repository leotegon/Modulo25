package modulo25;
public class Endereco{
	private Long id;
	private String cidade;
	private String logradouro;
	private int numero;
	private int cep;
	
	public Endereco(Long id, String cidade, String rua, int num, int cep){
		this.id = id;
		this.cidade = cidade;
		this.logradouro = rua;
		this.numero = num;
		this.cep = cep;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\nId: " + id);
		sb.append("\nLogradouro: " + logradouro);
		sb.append("\nNúmero: " + numero);
		sb.append("\nCep: " + cep);
		sb.append("\nCidade: " + cidade);
		sb.append("\nId em memoria " + numero);
		return sb.toString();
	}
}
