package introducao.io.inversor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Inversor {

	public static void inverter(File origem) throws IOException {
		//Lendo o arquivo
		FileInputStream fis = new FileInputStream(origem);
		String resultado = "";
		byte[] buffer = new byte[1];
		while (fis.read(buffer) != -1) {
			resultado += new String(buffer);
		}
		
		fis.close();
		
		//Invertendo as linhas
		String lineSeparator = System.getProperty("line.separator");
		String[] linhas = resultado.split(lineSeparator);
		for (int i = 0; i < linhas.length; i++) {
			linhas[i] = new StringBuffer(linhas[i]).reverse().append('\n').toString();
		}
		
		//Indicando arquivo de saída
		File saida = new File(origem.getParentFile(), "invertido-" + origem.getName());
		saida.createNewFile();
		
		//Escrever o conteúdo do arquivo de saída
		FileOutputStream fos = new FileOutputStream(saida);
		for (String linhaInvertida : linhas) {
			fos.write(linhaInvertida.getBytes());
		}
		
		fos.close();
	}

}
