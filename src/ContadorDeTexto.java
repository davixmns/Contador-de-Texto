import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContadorDeTexto {
    private BufferedReader arquivoDeEntrada;
    private final String caminhoDoArquivoDeEntrada;

    public ContadorDeTexto(String caminho) throws IOException {
        this.arquivoDeEntrada = new BufferedReader(new FileReader(caminho));
        this.caminhoDoArquivoDeEntrada = caminho;
    }

    public Integer contarLetras() throws IOException {
        Integer numeroDeLetras = 0;
        while (this.arquivoDeEntrada.ready()) {
            String linha = this.arquivoDeEntrada.readLine();
            for (int i = 0; i < linha.length(); i++) {
                if (linha.charAt(i) != ' ') {
                    numeroDeLetras++;
                }
            }
        }
        this.arquivoDeEntrada = new BufferedReader(new FileReader(this.caminhoDoArquivoDeEntrada));
        return numeroDeLetras;
    }

    public Integer contarPalavras() throws IOException {
        Integer numeroDePalavras = 0;
        while (this.arquivoDeEntrada.ready()) {
            String[] linha = this.arquivoDeEntrada.readLine().split(" ");
            for (String palavra : linha) {
                if (palavra.length() > 1) {
                    numeroDePalavras++;
                }
            }
        }
        this.arquivoDeEntrada = new BufferedReader(new FileReader(this.caminhoDoArquivoDeEntrada));
        return numeroDePalavras;
    }

    public Integer contarLinhas() throws IOException {
        Integer numeroDeLinhas = 0;
        while (this.arquivoDeEntrada.ready()) {
            numeroDeLinhas++;
            this.arquivoDeEntrada.readLine();
        }
        this.arquivoDeEntrada = new BufferedReader(new FileReader(this.caminhoDoArquivoDeEntrada));
        return numeroDeLinhas;
    }
}
