package desafioconexa.com.example.conexa.parameters;


import desafioconexa.com.example.conexa.models.Film;
import java.util.List;


public class FilmParameter {


    private List<Film> results;


    public FilmParameter() {
    }


    public FilmParameter(List<Film> results) {
        this.results = results;
    }


    public List<Film> getResults() {
        return results;
    }


    public void setResults(List<Film> results) {
        this.results = results;
    }
}
