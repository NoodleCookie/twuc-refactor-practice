package com.twu.refactoring;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private MovieType type;
    private String title;
    private int priceCode;

    public MovieType getType() {
        return type;
    }

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        getMovieTpye(priceCode);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
        getMovieTpye(priceCode);
    }

    private void getMovieTpye(int priceCode) {
        switch (priceCode) {
            case 0:
                type = MovieType.REGULAR;
                break;
            case 1:
                type = MovieType.NEW_RELEASE;
                break;
            default:
                type = MovieType.CHILDREN;
        }
    }

    public String getTitle() {
        return title;
    }
}

