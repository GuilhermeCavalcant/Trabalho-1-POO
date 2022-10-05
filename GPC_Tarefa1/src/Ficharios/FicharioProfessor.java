package Ficharios;

import Modelos.Professor;

import java.util.ArrayList;
import java.util.Scanner;
public class FicharioProfessor {
    private ArrayList<Professor> professorArrayList;
    private Scanner entrada;

    public FicharioProfessor(ArrayList<Professor> professores){
        this.professorArrayList = professores;
        entrada = new Scanner(System.in);
    }
    public void cadastrar(){
        String nome, telefone, matricula, cpf, email;

        System.out.println(" === Cadastrar PROFESSOR ==== ");
        System.out.print("Registro: ");
        matricula = entrada.nextLine();
        System.out.print("CPF: ");
        cpf = entrada.nextLine();
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
        System.out.print("Email: ");
        email = entrada.nextLine();

        Professor professor = new Professor(matricula, cpf, nome, telefone, email);
        if(professorArrayList.contains(professor)){
            System.out.println("Professor já cadastrado!");
        }else{
            professorArrayList.add(professor);
        }


    }

    public void alterar() {
        String nome, telefone, cpf, email;
        int pos;

        System.out.println(" ==== Alterar PROFESSOR ==== ");
        //TODO: Buscas devem ser feitas pela posição e registro
        System.out.println("Qual a posição do vetor deseja alterar? ");
        pos = entrada.nextInt();
        entrada.skip("\n");
        //TODO: Inserir try/catch para lançar exceção de busca fora do índice
        if (professorArrayList.get(pos) != null) {

            System.out.println("CPF atual: " + professorArrayList.get(pos).getCpf()); //get_ pega valor do objeto
            System.out.print("Digite o novo CPF: ");
            cpf = entrada.nextLine();
            professorArrayList.get(pos).setCpf(cpf); // set_ coloca o valor no objeto

            System.out.println("Nome atual: " + professorArrayList.get(pos).getNome()); //get_ pega valor do objeto
            System.out.print("Digite o novo Nome: ");
            nome = entrada.nextLine();
            professorArrayList.get(pos).setNome(nome); // set_ coloca o valor no objeto

            System.out.println("Tefone atual: " + professorArrayList.get(pos).getTelefone()); //get_ pega valor do objeto
            System.out.print("Digite o novo Telefone: ");
            telefone = entrada.nextLine();
            professorArrayList.get(pos).setTelefone(telefone); // set_ coloca o valor no objeto

            System.out.println("Endereco email atual: " + professorArrayList.get(pos).getEmail()); //get_ pega valor do objeto
            System.out.print("Digite o novo Endereço email: ");
            email = entrada.nextLine();
            professorArrayList.get(pos).setEmail(email); // set_ coloca o valor no objeto

        } else {
            System.out.println(" Posicao inválida. ");
        }

    }

    public void excluir() {
        int pos, resp;

        System.out.println(" --==[Excluir PROFESSOR]==-- ");
        System.out.println("Qual a posição deseja excluir? ");
        pos = entrada.nextInt();
        entrada.skip("\n");

        if (professorArrayList.get(pos) != null) {
            System.out.println(professorArrayList.get(pos));
            System.out.println("Confirma a exclusão? (1-sim) e (2-não) ");
            resp = entrada.nextInt();
            entrada.skip("\n");

            if (resp == 1) {
                //TODO: Inserir try/catch para lançar exceção de busca fora do índice
                professorArrayList.remove(pos); // exclui um objeto do vetor
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

        System.out.println(" === Consultar PROFESSOR === ");
        System.out.println("Qual a posição do vetor deseja consultar? ");
        pos = entrada.nextInt();
        entrada.skip("\n");

        if (professorArrayList.get(pos) != null) {
            System.out.println(professorArrayList.get(pos));
        } else {
            System.out.println(" Posicao inválida. ");
        }
    }

    public void relatorio() {

        System.out.println("[Relatório de PROFESSORES]");

        for(Professor professor: professorArrayList){
            System.out.println(professor);
            System.out.println("---------------------");
        }

    }
}