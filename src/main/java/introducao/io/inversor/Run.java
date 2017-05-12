package introducao.io.inversor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
		//Indicando arquivo a ser lido
//		File origem = new File("D:/3ads2017/pasta-legal/arquivo-xxx.txt");
		
		File root = new File("D:");
		File pasta1 = new File(root, "3ads2017");
		File pastaDestino = new File(pasta1, "pasta-legal");
		File origem = new File(pastaDestino, "arquivo-xxx.txt");
		
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
//		String[] linhas = resultado.split("(\r\n|\n)");
		String[] linhas = resultado.split(lineSeparator);
		for (int i = 0; i < linhas.length; i++) {
			linhas[i] = new StringBuffer(linhas[i]).reverse().append('\n').toString();
		}
		
		//Indicando arquivo de saída
//		File saida = new File(origem.getParentFile(), "invertido-" + origem.getName());
		File saida = new File(pastaDestino, "invertido-arquivo.xxx.txt");
		saida.createNewFile();
		
		//Escrever o conteúdo do arquivo de saída
		FileOutputStream fos = new FileOutputStream(saida);
		for (String linhaInvertida : linhas) {
			fos.write(linhaInvertida.getBytes());
		}
		
		fos.close();
	}

}
