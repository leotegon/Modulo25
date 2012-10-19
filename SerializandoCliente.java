package modulo25;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class SerializandoCliente {
	public static void serializarCliente(Cliente cliente, File file){
		System.out.println("Serializando cliente e gravando em: " + file.getAbsolutePath());
		try{
			//Define o nome do arquivo
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fs);

			//Escreve o cliente no arquivo cliente.ser
			os.writeObject(cliente);
			//Fecha o ObjectOutputStream
			os.close();
			fs.close();
			System.out.println("Serializacao do cliente efetuada com sucesso!");
		}catch (Exception e){
			System.out.println("Serializacao do cliente não realizada!");
			e.printStackTrace();
		}	
	}

	public static Cliente deserializarCliente(String arquivo){
		System.out.println("\n\nLendo cliente a partir do arquivo: " + arquivo);
		Cliente cliente = null;
		try{
			//Define o nome do arquivo que sera deserializado
			FileInputStream fs = new FileInputStream(arquivo);
			ObjectInputStream os = new ObjectInputStream(fs);
			//Atribui o cliente serializado a um objeto Cliente
			cliente = (Cliente) os.readObject();
			System.out.println("Leitura do cliente serializado do arquivo: " 
					+ arquivo + " efetuada com sucesso!\n");
			os.close();
			fs.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		//Retorna o cliente deserializado
		return cliente;
	}


	public static void main(String[] args) throws Exception{
		
		Cliente cliente = new Cliente(1, "Gevaldino", 29);
		System.out.println("============== Dados do cliente antes de Serialização ==============");
		System.out.println(cliente);
		
		File diretorio = new File("c:\\FCJ6\\modulo25");
		diretorio.mkdirs(); //cria diretorios e subdiretorios caso nao existam
		File file = new File( diretorio, "cliente.ser");
		if(file.exists()){
			file.delete();
			file.createNewFile();
		}else if(!file.exists()){
			file.createNewFile();
		}
		serializarCliente(cliente, file);
		//Recebe o cliente deserializado
		Cliente clienteDeserializado = deserializarCliente("c:\\FCJ6\\modulo25\\cliente.ser");		
		System.out.println("============== Dados do cliente obtidos do " +
		"arquivo apos Serialização ==============");
		System.out.println(clienteDeserializado);	
	}
}
