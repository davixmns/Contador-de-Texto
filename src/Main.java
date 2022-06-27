import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Apenas .txt", "txt");
        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            String caminhoDoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
            ContadorDeTexto contadorDeTexto = new ContadorDeTexto(caminhoDoArquivo);

            Integer numeroDeLetras = contadorDeTexto.contarLetras();
            Integer numeroDePalavras = contadorDeTexto.contarPalavras();
            Integer numeroDeLinhas = contadorDeTexto.contarLinhas();

            JOptionPane.showMessageDialog(null,
                    "Número de letras = " + numeroDeLetras + "\n" +
                            "Número de palavras = " + numeroDePalavras + "\n" +
                            "Número de linhas = " + numeroDeLinhas,
                    fileChooser.getSelectedFile().getName(), JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
}
