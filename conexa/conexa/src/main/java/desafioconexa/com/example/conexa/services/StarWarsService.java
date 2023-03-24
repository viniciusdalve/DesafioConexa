package desafioconexa.com.example.conexa.services;

import desafioconexa.com.example.conexa.models.Film;
import desafioconexa.com.example.conexa.models.FilmData;

import java.util.List;

public interface StarWarsService {

    List<FilmData> get(String title, Long episode_id);
}
