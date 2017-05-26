package introducao.io.copy;

import java.io.File;
import java.io.IOException;

public class Run {
	
	public static void main(String[] args) throws IOException {
		File root = new File("D:");
		File pastaLegal = new File(root, "3ads2017");
		File pastaOrigem = new File(pastaLegal, "pasta-legal");
		File origem = new File(pastaOrigem, "origem.jpg");

		File pastaDestino = new File(pastaOrigem, "pasta-mais-legal");
		File destino = new File(pastaDestino, "destino.jpg");

		Copiador.copiar(origem, destino);
	}

}
