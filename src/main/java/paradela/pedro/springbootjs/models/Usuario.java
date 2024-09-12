package paradela.pedro.springbootjs.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 255 caracteres.")
    @NotNull
    private String nome;

    @Email(message = "Email inválido")
    @NotNull
    private String email;

    @Size(min = 8, max = 32, message = "O nome deve ter entre 8 e 32 caracteres.")
    @NotNull
    private String senha;

    public Usuario() { }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}