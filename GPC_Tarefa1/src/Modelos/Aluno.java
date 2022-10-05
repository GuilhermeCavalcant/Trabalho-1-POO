package Modelos;
import java.util.Objects;
import java.time.*;

public class Aluno extends Pessoa{
    //TODO: Atributo de Aluno.
    private String matricula;
    private SituacaoAluno situacaoAluno ;
    private LocalDate dataDeNascimento;

    //TODO: Metodo construtor de Aluno.
    public Aluno(String matricula, String cpf, String nome, String telefone, String email, LocalDate dataNascimento, SituacaoAluno situacaoAluno){
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nome = nome;
        this.situacaoAluno = SituacaoAluno.naoEnturmado;
        this.dataDeNascimento = dataNascimento;
    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    //TODO: getter dos atributos.
    public String getMatricula() {
        return matricula;
    }
    public SituacaoAluno getSituacaoAluno(){
        return situacaoAluno;
    }



    //TODO: Setter dos atributos.
    public void setMatricula( String matricula){
        this.matricula = matricula;
    }
    public void setSituacaoAluno(SituacaoAluno situacaoAluno){
        this.situacaoAluno = situacaoAluno;
    }

    // TODO: METODOS.

    @Override
    public String toString(){
        return " Nome: " +this.nome + "\n" +" Matricula: " +this.matricula +"\n" +" Cpf: " +
                this.cpf +"\n" +" Telefone: " +this.telefone +"\n" +" Email: " + this.email
                +"\n" +" Data de nascimento: " +this.dataDeNascimento + " Situação: " +
                this.situacaoAluno;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode(){
        return Objects.hash(matricula);
    }
}
