package com.example.project.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "projekte")
public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="projektname")
    private String projektName;

    @Column(name="erstelldatum")
    private String erstellDatum;

    @Column(name="status")
    private String status;

    @Column(name="beschreibung")
    private String beschreibung;

    @Column(name="deadline")
    //@Temporal(TemporalType.DATE)
    private String deadline;

    @Column(name="ersteller")
    private String ersteller;

    @Column(name="projektleiter")
    private String projektleiter;

    public Projekt() {

    }

    public Projekt(int id, String projektName, String erstellDatum, String status, String beschreibung, String deadline, String ersteller, String projektleiter) {
        this.id = id;
        this.projektName = projektName;
        this.erstellDatum = erstellDatum;
        this.status = status;
        this.beschreibung = beschreibung;
        this.deadline = deadline;
        this.ersteller = ersteller;
        this.projektleiter = projektleiter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) {
        this.projektName = projektName;
    }

    public String getErstellDatum() {
        return erstellDatum;
    }

    public void setErstellDatum(String erstellDatum) {
        this.erstellDatum = erstellDatum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String   deadline) {
        this.deadline = deadline;
    }

    public String getErsteller() {
        return ersteller;
    }

    public void setErsteller(String ersteller) {
        this.ersteller = ersteller;
    }

    public String getProjektleiter() {
        return projektleiter;
    }

    public void setProjektleiter(String projektleiter) {
        this.projektleiter = projektleiter;
    }

    @Override
    public String toString() {
        return "Projekt{" +
                "id=" + id +
                ", projektName='" + projektName + '\'' +
                ", erstellDatum=" + erstellDatum +
                ", status='" + status + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", deadline=" + deadline +
                ", ersteller='" + ersteller + '\'' +
                ", projektleiter='" + projektleiter + '\'' +
                '}';
    }
}
