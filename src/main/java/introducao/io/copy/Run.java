package introducao.io.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Run {
	
	public static void main(String[] args) throws IOException {
		File root = new File("D:");
		File pastaLegal = new File(root, "3ads2017");
		File pastaOrigem = new File(pastaLegal, "pasta-legal");
		File origem = new File(pastaOrigem, "origem.jpg");

		File pastaDestino = new File(pastaOrigem, "pasta-mais-legal");
		File destino = new File(pastaDestino, "destino.jpg");
		
		FileInputStream entrada = new FileInputStream(origem);
		FileOutputStream saida = new FileOutputStream(destino);
		
		int bytesLidos;
//		byte[] buffer = new byte[(int) origem.length()]; //cuidado com tamanho do arquivo
		byte[] buffer = new byte[1000];
		
		while ((bytesLidos = entrada.read(buffer)) != -1) {
			System.out.println("Bytes lidos: " + bytesLidos);
			saida.write(buffer, 0, bytesLidos);
//			saida.write(buffer); //faz porcaria
		}
		
		entrada.close();
		saida.close();
	}

}
