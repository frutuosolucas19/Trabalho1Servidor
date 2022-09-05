package controller;

import dados.DadosServidor;
import org.json.simple.parser.ParseException;
import utils.ConversorClasseJSON;

/**
 *
 * @author Lucas de Liz Frutuoso e Matheus Henrique Maas
 */
public class Controller {

    public String Dados(String mensagem) throws ParseException, java.text.ParseException {
        ConversorClasseJSON utils = new ConversorClasseJSON();
        DadosServidor dadosServidor = new DadosServidor();

        String operacao = utils.retornaOperacao(mensagem);
        String classe = utils.retornaEntidade(mensagem);
        String cpf = utils.cpfDaPessoa(mensagem);

        switch (operacao) {
            case "INSERT":
                if (classe.equalsIgnoreCase("pessoa")) {
                    return dadosServidor.addPessoa(mensagem);
                }
                if (classe.equalsIgnoreCase("funcao")) {
                    return dadosServidor.addFuncao(mensagem);
                }
                break;
            case "LIST":
                if (classe.equalsIgnoreCase("pessoa")) {
                    return dadosServidor.listaPessoas();
                }
                if (classe.equalsIgnoreCase("funcao")) {
                    return dadosServidor.listaFuncoes();
                }
                break;
            case "GET":
                if (classe.equalsIgnoreCase("pessoa")) {
                    return dadosServidor.buscaPessoa(cpf);
                }
                break;
            case "DELETE":
                if (classe.equalsIgnoreCase("pessoa")) {
                    return dadosServidor.deletarPessoa(cpf);
                }
            case "UPDATE":
                if (classe.equalsIgnoreCase("pessoa")) {
                    return dadosServidor.atualizarPessoa(mensagem);
                }
            default:
                System.out.println("Nenhuma opção foi reconhecida pelo servidor.");
        }
        return "Saindo...";
    }

}
