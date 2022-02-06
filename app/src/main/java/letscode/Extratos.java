package letscode;

import lombok.AllArgsConstructor;

import java.util.Locale;
import java.util.Set;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

@AllArgsConstructor
public class Extratos {
    DataOperations dados;


    public void fazerExtratos() {
        Set<String> contasSet = dados.keys();
        System.out.println(contasSet);
        String[] contasArray = new String[contasSet.size()];
        contasSet.toArray(contasArray);
        for(int i=0; i<contasArray.length; i++){
            criarExtrato(contasArray[i]);
        }
    }

    public void criarExtrato(String conta) {
        double saldo = 0.0;
        String separator = System.getProperty("file.separator");
        // colocar para passar o caminho fora
        String file = "C:\\Users\\Notebook-2\\Desktop\\projeto_estrutura_dados\\extratos"+separator+conta+".txt";

        ArrayList<OperacaoBancaria> trasacoes = dados.getKey(conta);

        try {
            FileWriter arq = new FileWriter(file);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("Extrato de "+conta+"\n\n");
            gravarArq.printf("Operador \t");
            gravarArq.printf("Data \t\t\t\t");
            gravarArq.printf("Valor \t\t");
            gravarArq.printf("Tipo \t\n\n");

            for (OperacaoBancaria item : trasacoes) {
                gravarArq.printf(item.getOperador()+"\t");
                gravarArq.printf(item.getDataHoraOperacao()+"\t");
                if (item.getTipo().equals("SAQUE")) {
                    saldo = saldo - item.getValor();
                    gravarArq.printf("-%.2f\t\t", item.getValor());
                }
                if (item.getTipo().equals("DEPOSITO")) {
                    saldo = saldo + item.getValor();
                    gravarArq.printf("+%.2f\t\t", item.getValor());
                }
                gravarArq.printf(item.getTipo() + "\t\n");
            }
            gravarArq.printf("\nSaldo: .....................................\t");
            gravarArq.printf(Double.toString(saldo));
            arq.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
