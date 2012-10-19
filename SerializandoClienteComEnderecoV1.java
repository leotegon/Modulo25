package modulo25;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
public class SerializandoClienteComEnderecoV1 {
	public static void main(String[] args) {
		//Endere�o n�o implementa Serializable
		Endereco endereco = new Endereco(1L, "Ara�atuba", "Hum", 166, 16035444);
		ClienteComEndereco cliente = new ClienteComEndereco(1, "Gevaldino", 29, endereco);
		System.out.println("============== Dados do cliente antes de Serializa��o ==============");
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
			//E agora? ser� que conseguiremos salvar o cliente com o endere�o n�o serializavel?
			os.writeObject(cliente);
			//Fecha o ObjectOutputStream
			os.close();
			fs.close();
		}catch (Exception e){
			System.out.println("Serializacao do cliente n�o realizada!");
			e.printStackTrace();
		}	
	}
}

