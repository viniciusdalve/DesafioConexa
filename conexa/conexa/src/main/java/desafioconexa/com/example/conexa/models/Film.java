package desafioconexa.com.example.conexa.models;

import java.util.List;


public class Film {


    private List<FilmData> results;


    public Film() {
    }


    public Film(List<FilmData> results) {
        this.results = results;
    }


    public List<FilmData> getResults() {
        return results;
    }


    public void setResults(List<FilmData> results) {
        this.results = results;
    }
}




