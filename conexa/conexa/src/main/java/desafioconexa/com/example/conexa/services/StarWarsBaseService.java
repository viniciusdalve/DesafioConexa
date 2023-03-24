package desafioconexa.com.example.conexa.services;

import desafioconexa.com.example.conexa.models.Film;
import desafioconexa.com.example.conexa.models.FilmData;
import desafioconexa.com.example.conexa.services.feigns.StarWarsFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsBaseService implements StarWarsService{

    @Autowired
    private StarWarsFeignService starWarsFeignService;

    @Override
    public List<FilmData> get(String title, Long episode_id) {

        Film film = this.starWarsFeignService.get();

        List<FilmData> filteredResults = film.getResults()
                .stream()
                .filter(f -> title == null || f.getTitle().equalsIgnoreCase(title))
                .filter(f -> episode_id == null || f.getEpisode_id().equals(episode_id))
                .collect(Collectors.toList());

        film.setResults(filteredResults);

        return filteredResults;
    }

}
