package Modelo;

public class Estudante {

    private long RegistroAcademico;
    private String NomeEstudante;
    private String EmailEstudante;
    private String SenhaEstudante;

    public Estudante(long registroAcademico, String nomeEstudante, String emailEstudante, String senhaEstudante) {
        RegistroAcademico = registroAcademico;
        NomeEstudante = nomeEstudante;
        EmailEstudante = emailEstudante;
        SenhaEstudante = senhaEstudante;
    }

    public Estudante(String nomeEstudante, String emailEstudante, String senhaEstudante) {
        NomeEstudante = nomeEstudante;
        EmailEstudante = emailEstudante;
        SenhaEstudante = senhaEstudante;
    }
    public long getRegistroAcademico() {
        return RegistroAcademico;
    }

    public void setRegistroAcademico(long registroAcademico) {
        RegistroAcademico = registroAcademico;
    }

    public String getNomeEstudante() {
        return NomeEstudante;
    }

    public void setNomeEstudante(String nomeEstudante) {
        NomeEstudante = nomeEstudante;
    }

    public String getEmailEstudante() {
        return EmailEstudante;
    }

    public void setEmailEstudante(String emailEstudante) {
        EmailEstudante = emailEstudante;
    }

    public String getSenhaEstudante() {
        return SenhaEstudante;
    }

    public void setSenhaEstudante(String senhaEstudante) {
        SenhaEstudante = senhaEstudante;
    }

}
