package utils;

import java.text.ParseException;
import model.Funcao;
import model.Pessoa;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author lucas
 */
public class Utils {

    public String PessoaParaJson(Pessoa pessoa) {

        JSONObject jsonPessoa = new JSONObject();
        jsonPessoa.put("cpf", pessoa.getCpf());
        jsonPessoa.put("nome", pessoa.getNome());
        jsonPessoa.put("endereco", pessoa.getEndereco());

        return jsonPessoa.toJSONString();
    }

    public Pessoa JsonParaPessoa(String mensagem) throws ParseException {

        JSONObject json = new JSONObject();

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf((String) json.get("cpf"));
        pessoa.setNome((String) json.get("nome"));
        pessoa.setEndereco((String) json.get("endereco"));

        return pessoa;
    }

    public String FuncaoParaJson(Funcao funcao) {

        JSONObject jsonFuncao = new JSONObject();
        jsonFuncao.put("nome", funcao.getNome());
        jsonFuncao.put("setor", funcao.getSetor());
        jsonFuncao.put("salario", funcao.getSalario());

        return jsonFuncao.toJSONString();
    }

    public Funcao JsonParaFuncao(String mensagem) throws org.json.simple.parser.ParseException {

        JSONObject json = new JSONObject();

        Funcao funcao = new Funcao();
        funcao.setNome((String) json.get("nome"));
        funcao.setSetor((String) json.get("setor"));
        funcao.setSalario((Double) json.get("salario"));

        return funcao;
    }

    public String cpfPessoa(String mensagem) throws org.json.simple.parser.ParseException {

        JSONObject jsonObjeto;
        JSONParser parser = new JSONParser();
        jsonObjeto = (JSONObject) parser.parse(mensagem);
        String cpf = (String) jsonObjeto.get("cpf");

        return cpf;
    }

    public String retornaOperacao(String mensagem) throws org.json.simple.parser.ParseException {

        JSONObject jsonObjeto;
        JSONParser parser = new JSONParser();
        jsonObjeto = (JSONObject) parser.parse(mensagem);

        String operacao = (String) jsonObjeto.get("operacao");
         
        return operacao;
    }

    public String retornaEntidade(String mensagem) throws org.json.simple.parser.ParseException {

        JSONObject jsonObjeto;
        JSONParser parser = new JSONParser();
        jsonObjeto = (JSONObject) parser.parse(mensagem);
        String entidade = (String) jsonObjeto.get("classe");

        return entidade;
    }

}
