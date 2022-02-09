package com.cursor.lobo.moviereview.enums;

public enum Genre {
    SCI_FI("Science fiction"), ACT("Action"), CMD("Comedy"), DRM("Drama");

    String genre;
    private Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }
}