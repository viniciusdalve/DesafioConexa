package desafioconexa.com.example.conexa.controllers;

import desafioconexa.com.example.conexa.models.FilmData;
import desafioconexa.com.example.conexa.presenters.FilmDataPresenter;
import desafioconexa.com.example.conexa.services.StarWarsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/starwars")
public class StarWarsController {

    private final StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }
    @GetMapping("/films")
    public ResponseEntity getFilms(@RequestParam(value = "title", required = false) String title,
                                   @RequestParam(value = "episode_id", required = false) Long episode_id,
                                   @PageableDefault(page = 0, size = 10) Pageable pageable) {

        Page<FilmData> results = this.starWarsService.get(title, episode_id, pageable);

        return ResponseEntity.ok(results.stream().map(FilmDataPresenter::new));
    }
}
