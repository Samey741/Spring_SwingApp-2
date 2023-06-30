package com.example.cipherSpringAPP;
import javax.persistence.*;

@Entity // pre hibernate
@Table(name = "users")
public class GetUsersDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
