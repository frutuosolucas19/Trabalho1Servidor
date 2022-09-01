package datasource;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Funcao;
import model.Pessoa;
import org.json.simple.JSONObject;
import utils.ConversorClasseJSON;

/**
 *
 * @author lucas
 */
public class DataSource {

    private Pessoa pessoa;
    private Funcao funcao;
    private ConversorClasseJSON utils;
    private List<Pessoa> pessoas = new ArrayList();
    private List<Funcao> funcoes = new ArrayList();

    public DataSource() {
        this.utils = new ConversorClasseJSON();
    }

    public String addPessoa(String mensagem) throws ParseException {

        pessoa = utils.JsonParaPessoa(mensagem);
        pessoas.add(pessoa);

        return "Pessoa inserida com sucesso";
    }

    public String addFuncao(String mensagem) throws org.json.simple.parser.ParseException {

        funcao = utils.JsonParaFuncao(mensagem);
        return "Função inserida com sucesso";
    }

    public String listaPessoas() {
        JSONObject jsonPessoas = new JSONObject();
        int i = 0;

        for (Pessoa pessoas : pessoas) {
            JSONObject jsonPessoa = new JSONObject();
            jsonPessoa.put("cpf", pessoas.getCpf());
            jsonPessoa.put("nome", pessoas.getNome());
            jsonPessoa.put("endereco", pessoas.getEndereco());

            jsonPessoas.put(i, jsonPessoa);
            i++;
        }
        return jsonPessoas.toJSONString();
    }

    public String listaFuncoes() {
        JSONObject jsonFuncoes = new JSONObject();
        int i = 0;

        for (Funcao funcoes : funcoes) {
            JSONObject jsonFuncao = new JSONObject();
            jsonFuncao.put("nome", funcoes.getNome());
            jsonFuncao.put("setor", funcoes.getSetor());
            jsonFuncao.put("salario", funcoes.getSalario());

            jsonFuncoes.put(i, jsonFuncao);
            i++;
        }
        return jsonFuncoes.toJSONString();
    }
}
