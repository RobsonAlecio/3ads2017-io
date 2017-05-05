package introducao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {
//		File file = new File("nomezinho.txt");
//		File file = new File("D:\\3ads2017\\nomezinho.txt");
		File file = new File("D:/3ads2017/nomezinho2.txt");
		file.createNewFile();
		
		File root = new File("D:");
		File pasta = new File(root, "3ads2017");
		File novaPasta = new File(pasta, "pasta-legal");
		File novissimaPasta = new File(novaPasta, "pasta-mais-legal");
//		novaPasta.mkdir();
//		novissimaPasta.mkdir();
		novissimaPasta.mkdirs();
		
		
		File arquivo = new File(novissimaPasta, "coiso.txt");
		arquivo.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(arquivo);
//		fos.write(new byte[]{67, 111, 105, 115, 111}); //Coiso
		String poema = 
				"Batatinha quando nasce\n"
				+ "Espalha rama pelo chão\n"
				+ "Meninha quando dorme\n"
				+ "Põe a mão no coração";
		fos.write(poema.getBytes());
		fos.close();
		
		FileInputStream fis = new FileInputStream(arquivo);
		
		byte[] buffer = new byte[1];
//		byte[] buffer = new byte[10];
		String resultado = "";
		int lidos = 0;
		while ((lidos = fis.read(buffer)) != -1) {
			System.out.println("Bytes lidos: " + lidos);
			resultado += new String(buffer);
		}
		
		fis.close();
		
		System.out.println(resultado);
		
//		System.out.print("isso é um texto \n em duas linhas");
//		System.out.println("\n==========================");
//		System.out.print("isso é um texto \\n em uma linha só");
	}

}
