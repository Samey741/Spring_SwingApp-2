package com.example.cipherSpringAPP.DatabaseSchemas;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_list")
public class UserCyphers {

    public UserCyphers() {
    }

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
    @CreationTimestamp
    @Column(name = "created_on")
    private Date createdOn;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;


    public UserCyphers(String plaintext, String cryptedText, String decryptedText, String cipherType, Users user) {
        this.plaintext = plaintext;
        this.cryptedText = cryptedText;
        this.decryptedText = decryptedText;
        this.cipherType = cipherType;
        this.user = user;
    }
}