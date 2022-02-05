package letscode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class ReadFile {
    private String path;
    private String name;
    private String extension;

    public File openFile() {
        System.out.println("Abrindo arquivo, aguarde...");
        String separator = System.getProperty("file.separator");
        String pathName = this.path + separator + this.name + "." + this.extension;

        try {
            File file;
            Scanner scan;
            String line;
            OperacaoBancaria operacao;
            switch (this.extension.toLowerCase()) {
                case "csv":
                    file = new File(pathName);
                    scan = new Scanner(file);
                    while (scan.hasNextLine()){
                        line = scan.nextLine();
                        String[] parts = line.split(";");
                        operacao = new OperacaoBancaria(parts[0],parts[1],Double.parseDouble(parts[2]),parts[3],parts[4]);
                        System.out.println(operacao);
                    };
                    break;
                case "txt":
                    // implementar
                    break;

                default:
                    System.out.println("Tipo de arquivo não suportado");
                    // lançar erro
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    };


    public void closeFile() {
        // implementar fechamento do arquivo
        System.out.println("Arquivo fechado.");
    }
}
