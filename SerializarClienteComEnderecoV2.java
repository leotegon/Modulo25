package modulo25;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializandoClienteComEnderecoV2 {
	public static void main(String[] args) {
		//Endereço não implementa Serializable
		Endereco endereco = new Endereco(1L, "Araçatuba", "Hum", 166, 16035444);
		ClienteComEnderecoV2 cliente = new ClienteComEnderecoV2(1, "Gevaldino", 29, endereco);
		System.out.println("============== Dados do cliente antes de Serialização ==============");
		System.out.println(cliente);
		try{
			File diretorio = new File("c:\\FCJ6\\modulo25");
			diretorio.mkdirs(); //cria diretorios e subdiretorios caso nao existam
			File file = new File( diretorio, "cliente2.ser");
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}else if(!file.exists()){
				file.createNewFile();
			}
			System.out.println("Serializando cliente e gravando em: " + file.getAbsolutePath());
			//Define o nome do arquivo
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			//E agora? será que conseguiremos salvar o cliente com o endereço não serializavel?
			os.writeObject(cliente);
			//Fecha o ObjectOutputStream
			os.close();
			fs.close();

			//deserializando
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			//Atribui o cliente serializado a um objeto Cliente
			ClienteComEnderecoV2 clienteDeserializado = (ClienteComEnderecoV2) ois.readObject();
			System.out.println("Leitura do cliente serializado do arquivo: " 
					+ file.getName() + " efetuada com sucesso!\n");
			System.out.println("=============Imprimindo ClienteComEnderecoV2 deserializado===========");
			System.out.println(clienteDeserializado);
			os.close();
			fs.close();
			
		}catch (Exception e){
			System.out.println("Serializacao do cliente não realizada!");
			e.printStackTrace();
		}	
	}
}
