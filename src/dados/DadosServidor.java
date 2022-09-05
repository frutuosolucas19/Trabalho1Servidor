package dados;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Funcao;
import model.Pessoa;
import org.json.simple.JSONObject;
import utils.Conversor;

/**
 *
 * @author Lucas de Liz Frutuoso e Matheus Henrique Maas
 */
public class DadosServidor {

    private Pessoa pessoa;
    private Funcao funcao;
    private Conversor utils;
    private static final List<Pessoa> pessoas = new ArrayList();
    private static final List<Funcao> funcoes = new ArrayList();

    public DadosServidor() {
        this.utils = new Conversor();
    }

    public String addPessoa(String mensagem) throws ParseException, org.json.simple.parser.ParseException {

        pessoa = utils.JsonParaPessoa(mensagem);
        pessoas.add(pessoa);

        return "Pessoa inserida com sucesso";
    }

    public String addFuncao(String mensagem) throws org.json.simple.parser.ParseException {

        funcao = utils.JsonParaFuncao(mensagem);
        return "Função inserida com sucesso";
    }

    public String listaPessoas() {

        if (pessoas.isEmpty() != true) {
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

        return "0";
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

    public String buscaPessoa(String cpf) {
        if (pessoas.isEmpty() != true) {
            for (Pessoa p : pessoas) {
                if (p.getCpf().equalsIgnoreCase(cpf)) {
                    return utils.PessoaParaJson(p);
                }
            }

            return "Pessoa não encontrada";
        }
        return "Sem pessoas cadastradas";
    }

    public String deletarPessoa(String cpf) {
        boolean sucesso = false;
        if (pessoas.isEmpty() != true) {
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i).getCpf().equalsIgnoreCase(cpf)) {
                    pessoas.remove(i);
                    sucesso = true;
                    // break;
                }
                if (sucesso == true) {
                    return "Pessoa removida com sucesso.";
                }
            }
            return "Pessoa não encontrada";
        }
        return "Sem pessoas cadastradas";
    }

    public String atualizarPessoa(String msg) throws ParseException, org.json.simple.parser.ParseException {
        pessoa = new Pessoa();
        pessoa = utils.JsonParaPessoa(msg);
        String cpfPessoa = pessoa.getCpf();

        boolean sucesso = false;

        if (pessoas.isEmpty() != true) {
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i).getCpf().equalsIgnoreCase(cpfPessoa)) {
                    pessoas.set(i, pessoa);
                    sucesso = true;
                    // break;
                }
            }

            if (sucesso) {
                return "Pessoa atualizada com sucesso";
            }
            return "Pessoa não encontrada";
        }
        return "Sem pessoas cadastradas";
    }

    public void popularDadosServidor() {

        Pessoa p1 = new Pessoa();
        p1.setCpf("111");
        p1.setNome("João");
        p1.setEndereco("Rua Amazonas");
        pessoas.add(p1);

        Pessoa p2 = new Pessoa();
        p2.setCpf("222");
        p2.setNome("Marcos");
        p2.setEndereco("Rua Ibirama");
        pessoas.add(p2);
    }
}
