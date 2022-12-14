package utils;

import java.text.ParseException;
import model.Funcao;
import model.Pessoa;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Lucas de Liz Frutuoso e Matheus Henrique Maas
 */
public class Conversor {

    public String PessoaParaJson(Pessoa pessoa) {

        JSONObject jsonPessoa = new JSONObject();
        jsonPessoa.put("cpf", pessoa.getCpf());
        jsonPessoa.put("nome", pessoa.getNome());
        jsonPessoa.put("endereco", pessoa.getEndereco());

        return jsonPessoa.toJSONString();
    }

    public Pessoa JsonParaPessoa(String mensagem) throws ParseException, org.json.simple.parser.ParseException {
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(mensagem);

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

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(mensagem);

        Funcao funcao = new Funcao();
        funcao.setNome((String) json.get("nome"));
        funcao.setSetor((String) json.get("setor"));
        funcao.setSalario((Double) json.get("salario"));

        return funcao;
    }

    public String cpfDaPessoa(String mensagem) throws org.json.simple.parser.ParseException {

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

    public String retornaClasse(String mensagem) throws org.json.simple.parser.ParseException {

        JSONObject jsonObjeto;
        JSONParser parser = new JSONParser();
        jsonObjeto = (JSONObject) parser.parse(mensagem);
        String classe = (String) jsonObjeto.get("classe");

        return classe;
    }

    public String retornaNomeFuncao(String mensagem) throws org.json.simple.parser.ParseException {
        JSONObject jsonObjeto;
        JSONParser parser = new JSONParser();
        jsonObjeto = (JSONObject) parser.parse(mensagem);
        String nomeFuncao = (String) jsonObjeto.get("nome");

        return nomeFuncao;
    }

}
