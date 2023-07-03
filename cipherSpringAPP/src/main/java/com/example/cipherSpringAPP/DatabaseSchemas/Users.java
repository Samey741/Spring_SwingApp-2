package com.example.cipherSpringAPP.DatabaseSchemas;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // pre hibernate
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Roles> roles;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCyphers> userCyphers = new ArrayList<>();

    public List<UserCyphers> getUserCyphers() {
        return userCyphers;
    }

    public List<Roles> getRoles() {
        return roles;
    }

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
