package modulo25;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoHeranca {
	public static void serializaCliente(Cliente3 c){
		try{
			File file = new File("c:\\FCJ6\\modulo25");
			if(!file.exists()){
				file.mkdirs();
			}
			File arquivoClientes = new File(file, "cliente-heranca.ser");
			if(!arquivoClientes.exists()){
				arquivoClientes.createNewFile();
			}
			//Define o nome do arquivo
			FileOutputStream fs = new FileOutputStream(arquivoClientes);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			//Escreve o objeto no arquivo cliente-heranca.ser
			os.writeObject(c);
			
			//Fecha o ObjectOutputStream
			os.close();
		
		}catch (Exception e){e.printStackTrace();}	
	}
	
	public static Cliente3 deserializaCliente(String arquivo){
		Cliente3 clienteSerializado = null;
		try{
			//Define o nome do arquivo que sera deserializado
			FileInputStream fs = new FileInputStream(arquivo);
			ObjectInputStream os = new ObjectInputStream(fs);
			//Atribui o cliente serializado a um objeto Cliente
			clienteSerializado = (Cliente3) os.readObject();
			os.close();
		}catch (Exception e) {e.printStackTrace();}
		//Retorna o cliente deserializado
		return clienteSerializado;
	}
	
	public static void main(String[] args){
		Cliente3 cliente = new Cliente3(1, "Gevaldino", "Especial");
		System.out.println("------ Dados do cliente antes de Serialização -----\n");
		cliente.exibeInformacoes();
		serializaCliente(cliente);
		System.out.println("----- Dados do cliente depois da Serialização -----\n");
		//Recebe o cliente deserializado
		Cliente3 clienteDeserializado = deserializaCliente("c:\\FCJ6\\modulo25\\cliente-heranca.ser");
		clienteDeserializado.exibeInformacoes();
	}
}
