package desafioconexa.com.example.conexa.repositories;

import desafioconexa.com.example.conexa.entites.FilmEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface FilmRepository extends CrudRepository<FilmEntity, Long> {

    }



