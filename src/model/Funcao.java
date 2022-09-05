package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas de Liz Frutuoso e Matheus Henrique Maas
 */
public class Funcao {

    private String nomeFuncao;
    private String setor;
    private double salario;
    private List<Pessoa> pessoas = new ArrayList<>();

    public Funcao() {

    }

    public String getNome() {
        return nomeFuncao;
    }

    public void setNome(String nome) {
        this.nomeFuncao = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public String toString() {
        return "Funcao{" + "nome=" + nomeFuncao + ", setor=" + setor + ", salario=" + salario + ", pessoas=" + pessoas + '}';
    }


}
