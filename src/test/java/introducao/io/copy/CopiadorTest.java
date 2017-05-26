package introducao.io.copy;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CopiadorTest {
	
	private static File testFileFolder;

	@BeforeClass
	public static void setUpClass() throws IOException {
		testFileFolder = new File("copy_test_folder");
		
		testFileFolder.mkdirs();
		InputStream resourceAsStream = CopiadorTest.class.getClassLoader().getResourceAsStream("origem.jpg");
		File file = new File(testFileFolder, "origem-teste.jpg");
		Files.copy(resourceAsStream, file.toPath());
	}
	
	@AfterClass
	public static void tearDownClass() {
		deleteAll(testFileFolder);
	}
	
	private static void deleteAll(File target) {
		if (target.isDirectory()) {
			for (File file : target.listFiles())
				deleteAll(file);
		}
		target.delete();
	}

	@Test
	public void copiarArquivo() throws IOException {
		File origem = new File(testFileFolder, "origem-teste.jpg");
		
		File pastaDestino = new File(testFileFolder, "pasta-destino");
		pastaDestino.mkdirs();
		
		File destino = new File(pastaDestino, "copia.jpg");
		
		Copiador.copiar(origem, destino);
		
		FileInputStream streamOrigem = new FileInputStream(origem);
		FileInputStream streamDestino = new FileInputStream(destino);
		
		int posicao = 0;
		boolean arquivoEsperadoAcabou = false;
		while (!arquivoEsperadoAcabou) {
			int byteEsperado = streamOrigem.read();
			int byteCopiado = streamDestino.read();
			
			assertThat(byteCopiado).as("Byte da posição " + posicao).isEqualTo(byteEsperado);
			
			arquivoEsperadoAcabou = byteEsperado == -1;
		}
		
		streamOrigem.close();
		streamDestino.close();
	}

}
