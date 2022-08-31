
package controller;

import datasource.DataSource;
import org.json.simple.parser.ParseException;
import utils.Utils;

/**
 *
 * @author lucas
 */
public class Controller {
    
    public String Dados(String mensagem) throws ParseException, java.text.ParseException {
        Utils utils = new Utils();
        DataSource dataSource = new DataSource();
        
        String operacao = utils.retornaOperacao(mensagem);
        String classe = utils.retornaEntidade(mensagem);
        String cpfPessoa = utils.cpfPessoa(mensagem);
        
        switch (operacao) {
            case "INSERT":
                if(classe.equalsIgnoreCase("pessoa"))
                    return dataSource.addPessoa(mensagem);
                if(classe.equalsIgnoreCase("funcao"))
                    return dataSource.addFuncao(mensagem);
                break;
            case "2":
                if(classe.equalsIgnoreCase("pessoa"))
                    return dataSource.listaPessoas();
                if(classe.equalsIgnoreCase("funcao"))
                    return dataSource.listaFuncoes();
                break;
            default:
                
        }
        return "Saindo...";
    }
   
}
