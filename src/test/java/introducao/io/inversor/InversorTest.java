package introducao.io.inversor;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class InversorTest {

	private static File testFilesFolder;

	@BeforeClass
	public static void setUpClass() throws IOException {
		testFilesFolder = new File("test_files");
		
		testFilesFolder.mkdirs();
		InputStream streamOrigem = InversorTest.class.getClassLoader().getResourceAsStream("origem-inverter.txt");
		File origemParaTeste = new File(testFilesFolder, "origem-inverter.txt");
		Files.copy(streamOrigem, origemParaTeste.toPath());
	}
	
	@AfterClass
	public static void tearDownClass() {
		for (File file : testFilesFolder.listFiles())
			file.delete();
		testFilesFolder.delete();
	}
	
	@Test
	public void arquivoGeradoComparadoComLiteral() throws IOException {
		File origem = new File(testFilesFolder, "origem-inverter.txt");
		Inversor.inverter(origem);
		
		File arquivoGerado = new File(testFilesFolder, "invertido-origem-inverter.txt");
		assertThat(arquivoGerado.exists()).isTrue();
		
		String resultado = lerConteudo(arquivoGerado);
		
		assertThat(resultado).isEqualTo(
				"ecsan odnauq ahnitataB\n" +
				"oãhc olep amar ahlapsE\n" +
				"emrod odnauq ahninineM\n" +
				"oãçaroc on oãm a eõP\n");
	}

	@Test
	public void arquivoGeradoComparadoComArquivoEsperado() throws IOException {
		File origem = new File(testFilesFolder, "origem-inverter.txt");
		Inversor.inverter(origem);
		
		File arquivoGerado = new File(testFilesFolder, "invertido-origem-inverter.txt");
		assertThat(arquivoGerado.exists()).isTrue();
		
		FileInputStream streamArquivoGerado = new FileInputStream(arquivoGerado);
		InputStream streamArquivoEsperado = getClass().getClassLoader()
				.getResourceAsStream("invertido-origem-inverter-esperado.txt");
		
		int posicao = 0;
		boolean acabouArquivoEsperado = false;
		while (!acabouArquivoEsperado) {
			int byteGerado = streamArquivoGerado.read();
			int byteEsperado = streamArquivoEsperado.read();
			
			assertThat(byteGerado).as("Byte posição " + posicao).isEqualTo(byteEsperado);
			
			posicao++;
			acabouArquivoEsperado = byteEsperado == -1;
		}
		
		streamArquivoGerado.close();
	}
	
	private String lerConteudo(File arquivoGerado) throws IOException {
		FileInputStream fis = new FileInputStream(arquivoGerado);
		String resultado = "";
		byte[] buffer = new byte[1];
		while (fis.read(buffer) != -1) {
			resultado += new String(buffer);
		}
		
		fis.close();
		return resultado;
	}
	
}
