package desafioconexa.com.example.conexa.controllers;


import desafioconexa.com.example.conexa.models.Film;
import desafioconexa.com.example.conexa.models.FilmData;
import desafioconexa.com.example.conexa.parameters.FilmDataPresenter;
import desafioconexa.com.example.conexa.presenters.FilmPresenter;
import desafioconexa.com.example.conexa.services.StarWarsService;
import desafioconexa.com.example.conexa.services.feigns.StarWarsFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/v1/starwars")
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;


    @GetMapping("/films")
    public ResponseEntity getFilms(@RequestParam(value = "title", required = false) String title,
                                   @RequestParam(value = "episode_id", required = false) Long episode_id,
                                   @PageableDefault(page = 0, size = 10) Pageable pageable) {

        List<FilmData> results = this.starWarsService.get(title, episode_id);

        return new ResponseEntity(results.stream().map(a -> new FilmDataPresenter(a)), HttpStatus.OK);
    }
}
