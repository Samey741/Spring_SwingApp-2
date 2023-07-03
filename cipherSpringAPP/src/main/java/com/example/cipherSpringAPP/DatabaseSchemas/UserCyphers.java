package com.example.cipherSpringAPP.DatabaseSchemas;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_list")
public class UserCyphers {

    public Long getId() {
        return id;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public String getCryptedText() {
        return cryptedText;
    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public String getCipherType() {
        return cipherType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;

    @Column(name = "plaintext")
    private String plaintext;

    @Column(name = "cryptedtext")
    private String cryptedText;

    @Column(name = "decriptedtext")
    private String decryptedText;

    @Column(name = "ciphertype")
    private String cipherType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    public void setUser(Users user) {
        this.user = user;
    }
}