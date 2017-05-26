package introducao.io.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copiador {

	public static void copiar(File origem, File destino) throws IOException {
		FileInputStream entrada = new FileInputStream(origem);
		FileOutputStream saida = new FileOutputStream(destino);
		
		int bytesLidos;
		byte[] buffer = new byte[1000];
		
		while ((bytesLidos = entrada.read(buffer)) != -1) {
			System.out.println("Bytes lidos: " + bytesLidos);
			saida.write(buffer, 0, bytesLidos);
		}
		
		entrada.close();
		saida.close();
	}

}
