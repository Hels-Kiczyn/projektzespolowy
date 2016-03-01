package com.helskiczyn.wisecookfirebase;

/**
 * Created by Jacek on 2016-02-29.
 */
public class Przepis {
    private String nazwa;
    private String opis;

    public Przepis() {}

    public Przepis(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getOpis() {
        return opis;
    }
}

