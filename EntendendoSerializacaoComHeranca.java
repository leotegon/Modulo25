package modulo25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EntendendoSerializacaoComHeranca {
	public static void serializa(Filho filho){
		try{
			File diretorio = new File("c:\\FCJ6\\modulo25");
			diretorio.mkdirs(); //cria diretorios e subdiretorios caso nao existam
			File file = new File( diretorio, "filho.ser");
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}else if(!file.exists()){
				file.createNewFile();
			}
			//Define o nome do arquivo
			FileOutputStream fs = new FileOutputStream(new File(diretorio, "filho.ser"));
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			//Escreve o objeto no arquivo filho.ser
			System.out.println("Serializando!");
			os.writeObject(filho);
			System.out.println("Serialização finalizada com sucesso!");
			
			//Fecha o ObjectOutputStream
			os.close();
			fs.close();
		
		}catch (Exception e){e.printStackTrace();}	
	}
	
	public static Filho deserializa(String arquivo){
		System.out.println("Efetuando deserialização!");
		Filho filho = null;
		
		try{
			//Define o nome do arquivo que sera deserializado
			FileInputStream fs = new FileInputStream(arquivo);
			ObjectInputStream os = new ObjectInputStream(fs);
			
			//Atribui o filho serializado no objeto filho
			filho = (Filho) os.readObject();
			
			os.close();
			
		}catch (Exception e) {e.printStackTrace();}
		
		//Retorna o filho deserializado
		System.out.println("Deserializacao concluida!");
		return filho;
	}
	
	public static void main(String[] args){
		
		Filho filho = new Filho();
		
		serializa(filho);
		
		//Recebe o cliente deserializado
		Filho filhoDeserializado = deserializa("c:\\FCJ6\\modulo25\\filho.ser");
	}
}
