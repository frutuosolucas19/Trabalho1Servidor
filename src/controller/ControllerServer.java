package controller;

import dados.DadosServidor;
import org.json.simple.parser.ParseException;
import utils.Conversor;

/**
 *
 * @author Lucas de Liz Frutuoso e Matheus Henrique Maas
 */
public class ControllerServer {

    public String Dados(String mensagem) throws ParseException, java.text.ParseException {
        Conversor conversor = new Conversor();
        DadosServidor dadosServidor = new DadosServidor();

        String operacao = conversor.retornaOperacao(mensagem);
        String classe = conversor.retornaClasse(mensagem);
        String cpf = conversor.cpfDaPessoa(mensagem);
        String nomeFuncao = conversor.retornaNomeFuncao(mensagem);

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
                if (classe.equalsIgnoreCase("funcao")) {
                    return dadosServidor.buscaFuncao(nomeFuncao);
                }
                break;
            case "DELETE":
                if (classe.equalsIgnoreCase("pessoa")) {
                    return dadosServidor.deletarPessoa(cpf);
                }
                if (classe.equalsIgnoreCase("funcao")) {
                    return dadosServidor.deletarFuncao(nomeFuncao);
                }
            case "UPDATE":
                if (classe.equalsIgnoreCase("pessoa")) {
                    return dadosServidor.atualizarPessoa(mensagem);
                }
                if (classe.equalsIgnoreCase("funcao")) {
                    return dadosServidor.atualizarFuncao(mensagem);
                }
            default:
                System.out.println("Nenhuma opção foi reconhecida pelo servidor.");
        }
        return "Saindo...";
    }

}
