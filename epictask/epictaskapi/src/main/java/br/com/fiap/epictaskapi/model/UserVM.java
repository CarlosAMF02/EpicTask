package br.com.fiap.epictaskapi.model;

public class UserVM {
    private String name;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
