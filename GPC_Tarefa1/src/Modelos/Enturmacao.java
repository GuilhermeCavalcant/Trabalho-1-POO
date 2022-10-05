package Modelos;
import java.util.Date;
import java.util.Objects;

public class Enturmacao {
    //TODO: Atributos de Enturmacao
    private int codigo;
    private Aluno aluno;
    private Turma turma;
    private SituacaoAluno situacaoAluno;
    private Date dataDeEnturmacao;
    private static int geradorDeCodigo;



    //TODO: Getter de Enturmação.
    public Aluno getAluno(){
        return aluno;
    }

    public Turma getTurma(){
        return turma;
    }

    public Date getDataDeEnturmacao() {
        return dataDeEnturmacao;
    }

    public int getCodigo(){
        return codigo;
    }



    // TODO: setter de Enturmação.
    public void setAluno( Aluno aluno ){
        this.aluno = aluno;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setDataDeEnturmacao(Date dataDeEnturmacao) {
        this.dataDeEnturmacao = dataDeEnturmacao;
    }



    //TODO: Metodo construtor.

    public Enturmacao(Turma turma, Aluno aluno, Professor professor){
        this.aluno = aluno;
        this.turma = turma;
        codigo = ++geradorDeCodigo;
    }


    //TODO: metodos de enturmação.

    @Override
    public String toString(){
        return "Codigo : " +this.getCodigo() +" Turma : " +
                this.getTurma().getNome() + "aluno : " +
                this.getAluno().getNome();
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if ( o == null || getClass() != o.getClass())
            return false;
        Enturmacao enturmacao = (Enturmacao) o;
        return turma.equals(enturmacao.turma) && aluno.equals(enturmacao.aluno);
    }

    @Override
    public int hashCode(){
        return Objects.hash(turma, aluno);
    }
}

