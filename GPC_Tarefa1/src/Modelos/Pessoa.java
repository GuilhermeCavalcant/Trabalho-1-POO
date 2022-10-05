package Modelos;
import java.time.LocalDate;
import java.util.Date;
import java.time.*;

public class Pessoa {
    //TODO: Atributos de Pessoa.
    protected  String nome;
    protected  String cpf;
    protected  String telefone;
    protected  String email;

    protected LocalDate dataDeNacimento;

    //TODO: Metodo construtor.
    public Pessoa (){

    }


    // TODO: Getter dos atributos de Pessoa.
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataDeNacimento() {
        return dataDeNacimento;
    }

    // TODO: Setter dos atributos de Pessoa.

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setDataDeNacimento(LocalDate dataDeNacimento) {
        this.dataDeNacimento = dataDeNacimento;
    }
}
