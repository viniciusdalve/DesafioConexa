package desafioconexa.com.example.conexa.models;

import desafioconexa.com.example.conexa.entites.FilmEntity;
import java.util.Date;

public class FilmData {

    private String title;

    private Long episode_id;

    private String director;

    private Date release_date;

    public FilmData() {
    }

    public FilmData(FilmEntity film) {
        this.title = film.getTitle();
        this.episode_id = film.getEpisode_id();
        this.director = film.getDirector();
        this.release_date = film.getRelease_date();
    }

    public FilmData(String title, Long episode_id, String director, Date release_date) {
        this.title = title;
        this.episode_id = episode_id;
        this.director = director;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(Long episode_id) {
        this.episode_id = episode_id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}
