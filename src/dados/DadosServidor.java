package dados;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Funcao;
import model.Pessoa;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.Conversor;

/**
 *
 * @author Lucas de Liz Frutuoso e Matheus Henrique Maas
 */
public class DadosServidor {

    private Pessoa pessoa;
    private Funcao funcao;
    private Conversor conversor;
    private static final List<Pessoa> pessoas = new ArrayList();
    private static final List<Funcao> funcoes = new ArrayList();

    public DadosServidor() {
        this.conversor = new Conversor();
    }

    public String addPessoa(String mensagem) throws ParseException, org.json.simple.parser.ParseException {
        this.pessoa = conversor.JsonParaPessoa(mensagem);
        pessoas.add(pessoa);

        return "Pessoa inserida com sucesso";
    }

    public String addFuncao(String mensagem) throws org.json.simple.parser.ParseException {

        this.funcao = conversor.JsonParaFuncao(mensagem);
        funcoes.add(funcao);

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

        for (Funcao funcao : funcoes) {
            JSONObject jsonFuncao = new JSONObject();
            jsonFuncao.put("nome", funcao.getNome());
            jsonFuncao.put("setor", funcao.getSetor());
            jsonFuncao.put("salario", funcao.getSalario());

            jsonFuncoes.put(i, jsonFuncao);
            i++;
        }
        return jsonFuncoes.toJSONString();
    }

    public String buscaPessoa(String cpf) {
        if (pessoas.isEmpty() != true) {
            for (Pessoa p : pessoas) {
                if (p.getCpf().equalsIgnoreCase(cpf)) {
                    return conversor.PessoaParaJson(p);
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
        pessoa = conversor.JsonParaPessoa(msg);
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

    public String buscaFuncao(String nomeFuncao) {
        if (funcoes.isEmpty() != true) {
            for (Funcao f : funcoes) {
                if (f.getNome().equalsIgnoreCase(nomeFuncao)) {
                    return conversor.FuncaoParaJson(f);
                }
            }

            return "Funcão não encontrada";
        }
        return "Sem funções cadastradas";
    }

    public String deletarFuncao(String nomeFuncao) {
        boolean sucesso = false;
        if (funcoes.isEmpty() != true) {
            for (int i = 0; i < funcoes.size(); i++) {
                if (funcoes.get(i).getNome().equalsIgnoreCase(nomeFuncao)) {
                    funcoes.remove(i);
                    sucesso = true;
                    // break;
                }
                if (sucesso == true) {
                    return "Funcão removida com sucesso.";
                }
            }
            return "Funcão não encontrada";
        }
        return "Sem funcões cadastradas";
    }

    public String atualizarFuncao(String msg) throws ParseException, org.json.simple.parser.ParseException {
        funcao = new Funcao();
        funcao = conversor.JsonParaFuncao(msg);
        String nomeFuncao = funcao.getNome();

        boolean sucesso = false;

        if (funcoes.isEmpty() != true) {
            for (int i = 0; i < funcoes.size(); i++) {
                if (funcoes.get(i).getNome().equalsIgnoreCase(nomeFuncao)) {
                    funcoes.set(i, funcao);
                    sucesso = true;
                    // break;
                }
            }

            if (sucesso) {
                return "Funcao atualizada com sucesso";
            }
            return "Funcao não encontrada";
        }
        return "Sem funcões cadastradas";
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

        Funcao f1 = new Funcao();
        f1.setNome("Secretária");
        f1.setSetor("RH");
        f1.setSalario(1500);
        funcoes.add(f1);

        Funcao f2 = new Funcao();
        f2.setNome("Secretária");
        f2.setSetor("Administrativo");
        f2.setSalario(1500);
        funcoes.add(f1);
    }

    private Funcao getFuncaoNome(String nomeFuncao) {

        for (Funcao f : funcoes) {
            if (f.getNome().equalsIgnoreCase(nomeFuncao)) {
                return f;
            }
        }

        return new Funcao();
    }

    private Pessoa getPessoaCpf(String cpfPessoa) {

        for (Pessoa p : pessoas) {
            if (p.getCpf().equalsIgnoreCase(cpfPessoa)) {
                return p;
            }
        }

        return new Pessoa();
    }

    public String associaPessoaEmpresa(String cpfPessoa, String nomeFuncao) {

        String resposta = "Não foi possível associar esta pessoa a uma Função";

        if ((buscaPessoa(cpfPessoa)).equalsIgnoreCase("Pessoa com o CPF: " + cpfPessoa + " não encontrada.")) {

            Funcao funcao = getFuncaoNome(nomeFuncao);
            Pessoa pessoa = getPessoaCpf(cpfPessoa);

            if (funcao.getNome() != null && pessoa.getCpf() != null) {
                funcao.getPessoas().add(pessoa);
                resposta = "Cpf " + cpfPessoa + " associado a Função de " + funcao.getNome();
            }
        } else {
            resposta = "Esta pessoa já esta vinculada a uma empresa";
        }

        return resposta;
    }
}
