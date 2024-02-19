package com.example.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aufgaben")
public class Aufgabe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="titel")
    private String titel;

    @Column(name="beschreibung")
    private String beschreibung;

    @Column(name="status")
    private String status;

    @Column(name="deadline")
    private String deadline;

    @Column(name="mitarbeiter")
    private String mitarbeiter;

    @Column(name="projektleiter")
    private String projektleiter;

    public Aufgabe() {

    }

    public Aufgabe(int id, String titel, String beschreibung, String status, String deadline, String mitarbeiter, String projektleiter) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.deadline = deadline;
        this.mitarbeiter = mitarbeiter;
        this.projektleiter = projektleiter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(String mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public String getProjektleiter() {
        return projektleiter;
    }

    public void setProjektleiter(String projektleiter) {
        this.projektleiter = projektleiter;
    }

    @Override
    public String toString() {
        return "Aufgabe{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", status='" + status + '\'' +
                ", deadline='" + deadline + '\'' +
                ", mitarbeiter='" + mitarbeiter + '\'' +
                ", projektleiter='" + projektleiter + '\'' +
                '}';
    }
}
