package Ficharios;

import Modelos.Aluno;
import Modelos.Enturmacao;
import Modelos.Professor;
import Modelos.SituacaoAluno;
import Modelos.Turma;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioEnturmacao {
    private ArrayList<Turma> turmaArrayList;
    private ArrayList<Aluno> alunoArrayList;
    private ArrayList<Enturmacao> enturmacaoArrayList;
    private ArrayList<Professor> professorArrayList;
    private SituacaoAluno situacaoAluno;
    private Scanner entrada;

    public FicharioEnturmacao(ArrayList<Enturmacao> enturmacoes, ArrayList<Turma> turmas, ArrayList<Aluno> alunos, ArrayList<Professor> professors) {
        this.professorArrayList = professors;
        this.turmaArrayList = turmas;
        this.alunoArrayList = alunos;
        this.enturmacaoArrayList = enturmacoes;
        this.situacaoAluno = situacaoAluno.enturmado;
        entrada = new Scanner(System.in);
    }

    public FicharioEnturmacao(ArrayList<Aluno> aluno) {
        this.alunoArrayList = aluno;

    }


    public ArrayList<Enturmacao> getEnturmacaoArrayList(Aluno aluno) {
        return enturmacaoArrayList;
    }

    public void cadastrar() {
        int posicaoTurma, posAluno, posicaoProfessor;

        System.out.println(" === Cadastrar ENTURMAÇÃO === ");

        System.out.println("Qual a posição da turma no vetor? ");
        posicaoTurma = entrada.nextInt();
        entrada.skip("\n");

        System.out.println("Qual a posição do aluno no vetor? ");
        posAluno = entrada.nextInt();
        entrada.skip("\n");

        System.out.println("Qual a posição do professor no vetor? ");
        posicaoProfessor = entrada.nextInt();
        entrada.skip("\n");

        Enturmacao enturmacao; //objeto para cada posição
        enturmacao = new Enturmacao(turmaArrayList.get(posicaoTurma), alunoArrayList.get(posAluno), professorArrayList.get(posicaoProfessor));

        if (enturmacaoArrayList.contains(enturmacao)) {
            System.out.println("Enturmação já realizada!");
        } else {
            enturmacaoArrayList.add(enturmacao);
            alunoArrayList.get(posAluno).getSituacaoAluno(situacaoAluno) = SituacaoAluno.enturmado;
        }
    }

    public void excluir() {
        int pos, resp;

        System.out.println(" --==[Excluir Enturmação]==-- ");
        //TODO: Buscas devem ser feitas pela posição e código
        System.out.println("Qual a posição do vetor deseja excluir? ");
        pos = entrada.nextInt();
        entrada.skip("\n");

        if (enturmacaoArrayList.get(pos) != null) {
            System.out.println(enturmacaoArrayList.get(pos));
            System.out.println("Confirma a exclusão? (1-sim) e (2-não) ");
            resp = entrada.nextInt();
            entrada.skip("\n");

            if (resp == 1) {
                //TODO: Inserir try/catch para lançar exceção de busca fora do índice
                enturmacaoArrayList.remove(pos); // exclui um objeto do vetor
                System.out.println(" Exclusão efetuada com sucesso. ");

            } else {
                System.out.println(" Exclusão não efetuada. ");
            }
        } else {
            System.out.println(" Posição inválida. ");
        }
    }

    public void consultar() {
        int pos;

        System.out.println(" --==[Consultar Enturmação]==-- ");
        System.out.println("Qual a posição do vetor deseja consultar? ");
        pos = entrada.nextInt();
        entrada.skip("\n");
        //TODO: Inserir try/catch para lançar exceção de busca fora do índice
        // testa se existe uma enturmação na posição escolhida pelo usuário
        if (enturmacaoArrayList.get(pos) != null) {
            System.out.println(enturmacaoArrayList.get(pos));
        } else {
            System.out.println(" Posição inválida. ");
        }
    }


    public void relatorio() {

        System.out.println("[Relatório de ENTURMACOES]");

        for (Enturmacao enturmacao : enturmacaoArrayList) {
            System.out.println(enturmacao);
            System.out.println("---------------------");
        }

    }
}