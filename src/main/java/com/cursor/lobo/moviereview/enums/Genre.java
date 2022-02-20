package com.cursor.lobo.moviereview.enums;

public enum Genre {
    SCI_FI("Science fiction"), ACT("Action"), CMD("Comedy"), DRM("Drama"),
    CRT("Cartoon"), HRR("Horror"), FML_MV("Family movie"), DTC_FI("Detective fiction");

    String genre;

    private Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}