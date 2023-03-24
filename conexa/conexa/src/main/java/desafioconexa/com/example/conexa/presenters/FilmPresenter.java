package desafioconexa.com.example.conexa.presenters;

import desafioconexa.com.example.conexa.models.FilmData;

import java.util.List;

public class FilmPresenter {

    private List<FilmData> results;

    public FilmPresenter() {
    }

    public FilmPresenter(List<FilmData> results) {
        this.results = results;
    }

    public List<FilmData> getResults() {
        return results;
    }

    public void setResults(List<FilmData> results) {
        this.results = results;
    }
}
