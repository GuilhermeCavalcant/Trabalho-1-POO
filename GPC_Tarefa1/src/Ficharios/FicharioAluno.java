package Ficharios;
import Modelos.Aluno;
import Modelos.SituacaoAluno;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;

public class FicharioAluno {

    private ArrayList<Aluno> alunoArrayList;
    private Scanner entrada;
    private SituacaoAluno situacaoAluno;


    //TODO: Metodo construtor FicharioAluno
    public FicharioAluno(ArrayList<Aluno> alunos, Scanner entrada){
        this.alunoArrayList = alunos;
        this.entrada = entrada;
    }

    //TODO: metodos do FicharioAluno.
    public void cadastrar(){
        LocalDate dataDeNascimento = null;
        String nome, telefone, matricula, cpf, email, dataInformada;
        System.out.println("===CADASTRO DE ALUNO ===");
        System.out.print("Nome: ");
        nome =  entrada.nextLine();
        System.out.print("Matricula: ");
        matricula = entrada.nextLine();


        System.out.println("Data de nacimento: " +"dd/MM/yyyy");
        try {
            dataInformada = entrada.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataDeNascimento = LocalDate.parse(dataInformada, formatador);

        } catch (DateTimeException exc ) {
            System.out.println("formato errado!" );
        }


        System.out.print("Cpf: ");
        cpf = entrada.nextLine();
        System.out.print("telefone: ");
        telefone = entrada.nextLine();
        System.out.print("Email: ");
        email = entrada.nextLine();

        Aluno aluno = new Aluno(matricula, cpf, nome, telefone, email,dataDeNascimento, situacaoAluno);
        if(alunoArrayList.contains(aluno)){  //Testando se os dados do aluno já existem dentro do array
            System.out.println("Dados já pertencentes a outro aluno!");
        }else{      // caso não existam, o aluno será alocado dentro do array.
            alunoArrayList.add(aluno);
        }

    }

    public void alterar()
    {
        LocalDate dataDeNascimento;
        String dataInformada;
        String nome, telefone, cpf, email;
        int posicao = 0;

        System.out.println("=== Alterar Aluno===");
        System.out.println("Informe a posição que deseja alterar: ");
        posicao = entrada.nextInt();
        entrada.skip("\n");

        try {
            if (alunoArrayList.get(posicao) != null){
                // Nome do aluno.
                System.out.println("Nome atual do aluno: "+ alunoArrayList.get(posicao).getNome());
                System.out.print("NOVO nome do aluno.: ");
                nome =  entrada.nextLine();

                // Cpf do aluno
                System.out.println("Cpf atual do aluno: " +alunoArrayList.get(posicao).getCpf());
                System.out.print("NOVO Cpf do aluno.: ");
                cpf = entrada.nextLine();

                // Telefone do aluno
                System.out.println("Telefone atual do aluno: " +alunoArrayList.get(posicao).getTelefone());
                System.out.print("NOVO Telefone do aluno.: ");
                telefone = entrada.nextLine();

                // email do aluno
                System.out.println("email atual do aluno: " +alunoArrayList.get(posicao).getEmail());
                System.out.print("NOVO email do aluno.: ");
                email = entrada.nextLine();

                //data de nacimento
                System.out.println("Data de nascimento atual do aluno: " +alunoArrayList.get(posicao).getDataDeNacimento());
                System.out.print("NOVA data de nascimento do aluno.: " + "(dd/MM/yyyy) ");
                try {
                    dataInformada = entrada.nextLine();
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    dataDeNascimento = LocalDate.parse(dataInformada, formatador);
                    alunoArrayList.get(posicao).setDataDeNacimento(dataDeNascimento);

                } catch (DateTimeException exc ) {
                    System.out.println("formato errado!" );
                }

                // Passando Novos DADOS de aluno.
                alunoArrayList.get(posicao).setNome(nome);
                alunoArrayList.get(posicao).setCpf(cpf);
                alunoArrayList.get(posicao).setTelefone(telefone);
                alunoArrayList.get(posicao).setEmail(email);



            }else{
                System.out.println("posição invalida...");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("\nExeceção encontrada, Indici nao existe");
        }

    }

    public void excluir() {
        int posicao, resp,codigo;
        FicharioEnturmacao ficharioEnturmacao;
        //TODO: Inserir validação para não permitir excluir aluno que esteja numa turma ou excluir também a enturmação
        System.out.println(" --==[Excluir ALUNO]==-- ");
        System.out.println("como dejesa procurar aluno?\n1.posicao \n2.codigo");
        resp = entrada.nextInt();
        entrada.skip("\n");

        if (resp == 1) {
            System.out.println("Qual a posição deseja excluir? ");
            posicao = entrada.nextInt();
            entrada.skip("\n");

            if (alunoArrayList.get(posicao) != null)
            {
                if(situacaoAluno != situacaoAluno.enturmado)
                {
                    System.out.println(alunoArrayList.get(posicao));
                    System.out.println("Confirma a exclusão? (1-sim) e (2-não) ");
                    resp = entrada.nextInt();
                    entrada.skip("\n");

                    if (resp == 1) {

                        alunoArrayList.remove(posicao); // exclui um objeto do vetor
                        System.out.println(" Exclusão efetuada com sucesso. ");

                    } else {
                        System.out.println(" Exclusão não efetuada. ");
                    }
                }

            } else {
                System.out.println(" Posicao inválida. ");
            }

        } else {
            System.out.println("Qual o codigo que deseja consultar? ");
            codigo = entrada.nextInt();
            entrada.skip("\n");
            procurarCodigo(codigo);

        }






    }

    public void consultar() {
        int posicao, resposta;
        String matricula;

        System.out.println("---Consultar Aluno---");
        System.out.println("como dejesa procurar?\n1.Indici \n2.Matricula");
        resposta = entrada.nextInt();
        entrada.skip("\n");

        if (resposta == 1) {
            System.out.println("Qual a posição do vetor deseja consultar? ");
            posicao = entrada.nextInt();
            entrada.skip("\n");
            procurar(posicao);

        } else {
            System.out.println("Qual a matrícula que deseja consultar? ");
            matricula = entrada.nextLine();
            entrada.skip("\n");
            procurar(matricula);

        }
    }

    public void procurarCodigo(int codigo){
        int resp;
        try{
            if(alunoArrayList.get(codigo) != null) {
                System.out.println(alunoArrayList.get(codigo));
                System.out.println("Confirma a exclusão? (1-sim) e (2-não) ");
                resp = entrada.nextInt();
                entrada.skip("\n");

                if (resp == 1) {
                    alunoArrayList.remove(codigo); // exclui um objeto do vetor
                    System.out.println(" Exclusão efetuada com sucesso. ");

                } else {
                    System.out.println(" Exclusão não efetuada. ");
                }

            } else {
                System.out.println(" Posição Invalida");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("\nExceção alcançada, índice inexistente!!");
        }
    }
    public void procurar(String chave){
            Aluno aluno = new Aluno(chave);
            if(alunoArrayList.indexOf(aluno) >= 0){
                System.out.println(alunoArrayList.get(alunoArrayList.indexOf(aluno)));
            }else{
                System.out.println("aluno não encontrado");
            }

    }


    public void procurar(int posicao){
        //TODO: Inserir try/catch para lançar exceção de busca fora do índice
        try{
            if(alunoArrayList.get(posicao) != null) {
                System.out.println(alunoArrayList.get(posicao));

            } else {
                System.out.println(" Posição Invalida");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("\nExceção alcançada, índice inexistente!!");
        }
    }


    public void ralatorio(){
        System.out.println("Relatório dos Alunos Cadastrados: ");

        for(Aluno aluno : alunoArrayList){
            System.out.println(aluno);
            System.out.println("---------------");
        }
    }

    public void relatorio() {

    }
}
