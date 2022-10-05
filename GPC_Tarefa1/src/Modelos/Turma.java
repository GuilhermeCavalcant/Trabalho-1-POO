package Modelos;
import java.util.ArrayList;
import java.util.Objects;

public class Turma {
    //TODO: Atributos de Turma.
    private String codigo;
    private String nome;
    private ArrayList<Aluno> alunoArrayList;

    //TODO: getter da Turma.
    public String getCodigo() {
        return codigo;
    }
    public String getNome(){
        return nome;
    }

    public ArrayList<Aluno> getAlunoArrayList() {
        return alunoArrayList;
    }

    //TODO: setter da Turma.
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }



    //TODO: metodo construtor da Turma.
    public Turma(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    //TODO: Metodos da Turma.

    @Override
    public String toString() {
        return "Turma{ " +"codigo: " +codigo +"nome: " + nome +'}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if( o == null || getClass() != o.getClass())
            return false;
        Turma turma = (Turma) o;
        return Objects.equals(codigo, turma.codigo);
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

    //TODO: Add aluno a turma
    public void addAlunoArrayList(Aluno alunoDoArray){
        this.alunoArrayList.add(alunoDoArray);
    }
}
