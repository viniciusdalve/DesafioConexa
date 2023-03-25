package desafioconexa.com.example.conexa.services;

import desafioconexa.com.example.conexa.entites.FilmEntity;
import desafioconexa.com.example.conexa.models.Film;
import desafioconexa.com.example.conexa.models.FilmData;
import desafioconexa.com.example.conexa.repositories.FilmRepository;
import desafioconexa.com.example.conexa.services.feigns.StarWarsFeignService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class StarWarsBaseService implements StarWarsService{

    private final StarWarsFeignService starWarsFeignService;

    private final FilmRepository filmRepository;

    public StarWarsBaseService(StarWarsFeignService starWarsFeignService, FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
        this.starWarsFeignService = starWarsFeignService;
    }


    @Override
    public Page<FilmData> get(String title, Long episode_id, Pageable pageable) {

        Film film = this.starWarsFeignService.get();

        List<FilmData> filteredResults = film.getResults()
                .stream()
                .filter(f -> title == null || f.getTitle().equalsIgnoreCase(title))
                .filter(f -> episode_id == null || f.getEpisode_id().equals(episode_id))
                .collect(toList());

        film.setResults(filteredResults);

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), filteredResults.size());
        List<FilmData> paginatedResults = filteredResults.subList(start, end);
        saveFilms(paginatedResults);

        return new PageImpl<>(paginatedResults, pageable, filteredResults.size());
    }

    public void saveFilms(List<FilmData> filmDataList) {
        filmDataList.forEach(filmData -> {
            FilmEntity film = new FilmEntity();
            film.setTitle(filmData.getTitle());
            film.setEpisode_id(filmData.getEpisode_id());
            film.setDirector(filmData.getDirector());
            film.setRelease_date(filmData.getRelease_date());
            filmRepository.save(film);
        });
    }

}
