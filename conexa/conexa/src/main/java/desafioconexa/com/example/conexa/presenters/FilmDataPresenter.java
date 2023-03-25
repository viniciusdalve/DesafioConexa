package desafioconexa.com.example.conexa.presenters;

import desafioconexa.com.example.conexa.models.FilmData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilmDataPresenter {
    private String title;

    private Long episode_id;

    private String director;

    private Date release_date;

    public FilmDataPresenter() {
    }

    public FilmDataPresenter(FilmData a) {
        this.title = a.getTitle();
        this.episode_id = a.getEpisode_id();
        this.director = a.getDirector();
        this.release_date = a.getRelease_date();
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

    public String getRelease_date() {
        if (release_date == null) {
            return null;
        }
        SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
        return sdfOutput.format(release_date);
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}