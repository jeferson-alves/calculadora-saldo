package letscode;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@ToString

public class DataOperations {
//    private OperacaoBancaria operacao;
    Map<String, ArrayList<OperacaoBancaria>> map = new HashMap<>();


//    public void put(String chave, String valor) {
//        map.put(chave, valor);
//    }

    public void put(OperacaoBancaria operacao) {
        ArrayList<OperacaoBancaria> operationsList = new ArrayList<>();
        String idConta = operacao.getContaBancaria(); //buscar o id da conta e colocar

        ArrayList<OperacaoBancaria> contaOperations = map.get(idConta);
        if (contaOperations == null) {
            operationsList.add(operacao);
            map.put(idConta, operationsList);
        } else {
            operationsList = contaOperations;
            operationsList.add(operacao);
//            operationsList = adicionarOrdenado(contaOperations, operacao);
            map.put(idConta, operationsList);
        }
//
    }

    public ArrayList<OperacaoBancaria> getKey(String chave) {
        return map.get(chave);
    }

    public Set<String> keys() {
//        System.out.println( map.keySet() );
        return map.keySet();
    }

    //colocar algo para checar quando a operação é repetida

//    public ArrayList<OperacaoBancaria> adicionarOrdenado(ArrayList<OperacaoBancaria> operacoesConta, OperacaoBancaria novaOperacao) {
//        Date novaData = novaOperacao.getDataHoraOperacao();
//        long novaDataEpoch = novaData.getTime();
//        ArrayList<OperacaoBancaria> listaOrdenada = new ArrayList<>();
//        boolean controle = true;
//        int count = 0;
//        long itemDataEpoch;
//        Date itemData;
//        OperacaoBancaria item;
//        while ( count < operacoesConta.size() ) {
//            item = operacoesConta.get(count);
//            itemData = item.getDataHoraOperacao();
//            itemDataEpoch = itemData.getTime();
//            if (controle) {
//                if (novaDataEpoch > itemDataEpoch) {
//                    listaOrdenada.add(item);
//                    count++;
//                } else {
//                    listaOrdenada.add(novaOperacao);
//                    controle = false;
//                }
//            } else {
//                listaOrdenada.add(item);
//                count++;
//            }
//        }
//        return operacoesConta;
//    }
}
