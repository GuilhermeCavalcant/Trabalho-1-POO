package Ficharios;

import Modelos.Turma;
import java.util.ArrayList;
import java.util.Scanner;

public class FicharioTurma {

    private ArrayList<Turma> turmaArrayList;
    private final Scanner entrada;

    public FicharioTurma(ArrayList<Turma> turmas){
        this.turmaArrayList = turmas;
        entrada = new Scanner(System.in);
    }
    public void cadastrar(){
        String codigo, nome;

        System.out.println(" === Cadastrar TURMA ==== ");
        System.out.print("Codigo: ");
        codigo = entrada.nextLine();

        System.out.print("Nome: ");
        nome = entrada.nextLine();

        Turma turma = new Turma(codigo, nome);
        if(turmaArrayList.contains(turma)){
            System.out.println("Turma já cadastrada!");
        }else{
            turmaArrayList.add(turma);
        }


    }

    public void alterar() {
        String nome;
        int pos;

        System.out.println(" ==== Alterar TURMA ==== ");
        System.out.println("Qual a posição do vetor deseja alterar? ");
        pos = entrada.nextInt();
        entrada.skip("\n");
        //TODO: Inserir try/catch para lançar exceção de busca fora do índice
        //TODO: Buscas devem ser feitas pela posição e código
        if (turmaArrayList.get(pos) != null) {

            System.out.println("Nome atual: " + turmaArrayList.get(pos).getNome()); //get_ pega valor do objeto
            System.out.print("Digite o novo Nome: ");
            nome = entrada.nextLine();
            turmaArrayList.get(pos).setNome(nome); // set_ coloca o valor no objeto

        } else {
            System.out.println(" Posicao inválida. ");
        }

    }

    public void excluir() {
        int pos, resp;
        //TODO: Inserir validação para não permitir excluir turma que tenham alunos vinculados
        System.out.println(" --==[Excluir TURMA]==-- ");
        System.out.println("Qual a posição deseja excluir? ");
        pos = entrada.nextInt();
        entrada.skip("\n");

        if (turmaArrayList.get(pos) != null) {
            System.out.println(turmaArrayList.get(pos));
            System.out.println("Confirma a exclusão? (1-sim) e (2-não) ");
            resp = entrada.nextInt();
            entrada.skip("\n");

            if (resp == 1) {
                turmaArrayList.remove(pos); // exclui um objeto do vetor
                System.out.println(" Exclusão efetuada com sucesso. ");

            } else {
                System.out.println(" Exclusão não efetuada. ");
            }

        } else {
            System.out.println(" Posicao inválida. ");
        }
    }

    public void consultar() {
        int pos;

        System.out.println(" === Consultar TURMA === ");
        System.out.println("Qual a posição do vetor deseja consultar? ");
        pos = entrada.nextInt();
        entrada.skip("\n");

        if (turmaArrayList.get(pos) != null) {
            System.out.println(turmaArrayList.get(pos));
        } else {
            System.out.println(" Posicao inválida. ");
        }
    }

    public void relatorio() {

        System.out.println("[Relatório de TURMAs]");

        for(Turma turma: turmaArrayList){
            System.out.println(turma);
            System.out.println("---------------------");
        }

    }


}