package desafioconexa.com.example.conexa.services;

import desafioconexa.com.example.conexa.models.Film;
import desafioconexa.com.example.conexa.models.FilmData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StarWarsService {

    Page<FilmData> get(String title, Long episode_id, Pageable pageable);
}
