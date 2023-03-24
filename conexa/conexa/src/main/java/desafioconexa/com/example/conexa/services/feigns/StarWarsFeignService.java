package desafioconexa.com.example.conexa.services.feigns;

import desafioconexa.com.example.conexa.models.Film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "StarWarsFeignService", url = "https://swapi.dev/api")
public interface StarWarsFeignService {

    @GetMapping(value = "/films")
    Film get();

}


