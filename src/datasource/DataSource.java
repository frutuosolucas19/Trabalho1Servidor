package datasource;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Funcao;
import model.Pessoa;
import utils.Utils;

/**
 *
 * @author lucas
 */
public class DataSource {

    private Pessoa pessoa;
    private Funcao funcao;
    private Utils utils;
    private List<Pessoa> pessoas = new ArrayList();
    private List<Funcao> funcoes = new ArrayList();

    public String addPessoa(String mensagem) throws ParseException {

        pessoa = utils.JsonParaPessoa(mensagem);
        pessoas.add(pessoa);

        return "Pessoa inserida com sucesso";
    }

    public String addFuncao(String mensagem) throws org.json.simple.parser.ParseException {

        funcao = utils.JsonParaFuncao(mensagem);
        return "Função inserida com sucesso";
    }

}
