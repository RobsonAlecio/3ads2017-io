package introducao.io.inversor;

import java.io.File;
import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		//Indicando arquivo a ser lido
//		File origem = new File("D:/3ads2017/pasta-legal/arquivo-xxx.txt");
		
		File root = new File("D:");
		File pasta1 = new File(root, "3ads2017");
		File pastaDestino = new File(pasta1, "pasta-legal");
		File origem = new File(pastaDestino, "arquivo-xxx.txt");
		
		Inversor.inverter(origem);
	}

}
