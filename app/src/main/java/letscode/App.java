/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package letscode;
import java.text.SimpleDateFormat;
import java.util.Date;


public class App {

    public static void main(String[] args) {

//        System.out.println("olá");
//        ContaBancaria jeff = new ContaBancaria("$1", "001", "0101", "01001-01");
//
//        System.out.println(jeff.getId());

        ReadFile arquivo = new ReadFile("C:\\Users\\Notebook-2\\Desktop\\projeto_estrutura_dados", "operacoes", "csv");
        DataOperations dados = arquivo.openFile();

        Extratos extratos = new Extratos(dados);
        extratos.fazerExtratos();
//        System.out.println(dados);


//        DataOperations data1 = new DataOperations();
//        data1.put("name", "Rohan");
//        data1.put("sname", "Kumar");
//        System.out.println(data1.toString());
//        System.out.println(data1.getKey("name"));
//        System.out.println(data1.getKey("zdsdf"));


    }
}
