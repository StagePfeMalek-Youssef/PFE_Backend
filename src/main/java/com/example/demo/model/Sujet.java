package com.example.demo.model;


import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Sujet")
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="Id_Sujet")
    private Long idSu;
    @Column(nullable = false, name="Titre_De_Sujet")
    private String sujet;
    @Column(nullable = false, name="Date_Déclaration")
    @Temporal(TemporalType.TIMESTAMP) 
    private Date dateDeclar  = new Date(System.currentTimeMillis());
    @OneToMany(cascade = CascadeType.ALL, mappedBy="sujet")
    private Set<Messages> messages = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_User")
    private User user;

    
    public Sujet() {
    }


    

    public Sujet(String sujet, Date dateDeclar, Set<Messages> messages, User user) {
        this.sujet = sujet;
        this.dateDeclar = dateDeclar;
        this.messages = messages;
        this.user = user;
    }




    

    public Long getIdSu() {
        return idSu;
    }




    public void setIdSu(Long idSu) {
        this.idSu = idSu;
    }




    public String getSujet() {
        return sujet;
    }




    public void setSujet(String sujet) {
        this.sujet = sujet;
    }




    public Date getDateDeclar() {
        return dateDeclar;
    }




    public void setDateDeclar(Date dateDeclar) {
        this.dateDeclar = dateDeclar;
    }




    public Set<Messages> getMessages() {
        return messages;
    }




    public void setMessages(Set<Messages> messages) {
        this.messages = messages;
    }




    public User getUser() {
        return user;
    }




    public void setUser(User user) {
        this.user = user;
    }




    @Override
    public String toString() {
        return "Sujet [dateDeclar=" + dateDeclar + ", idSu=" + idSu + ", sujet=" + sujet + "]";
    }


    
}
