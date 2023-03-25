package desafioconexa.com.example.conexa;

import desafioconexa.com.example.conexa.entites.FilmEntity;
import desafioconexa.com.example.conexa.models.Film;
import desafioconexa.com.example.conexa.models.FilmData;
import desafioconexa.com.example.conexa.repositories.FilmRepository;
import desafioconexa.com.example.conexa.services.StarWarsBaseService;
import desafioconexa.com.example.conexa.services.feigns.StarWarsFeignService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StarWarsServiceTests {

	@Mock
	private StarWarsFeignService starWarsFeignService;

	@Mock
	private FilmRepository filmDataRepository;

	@InjectMocks
	private StarWarsBaseService filmService;

	private Film mockFilm;
	private List<FilmData> mockFilmData;

	@BeforeEach
	public void setUp() {
		mockFilmData = Arrays.asList(
				new FilmData("A New Hope", 1L, "", new Date()),
				new FilmData("Test Film", 2L, "", new Date()),
				new FilmData("Test Film 2", 3L, "", new Date())
		);
		mockFilm = new Film(mockFilmData);
	}

	@Test
	public void testGetAllFilms() {
		// Given
		when(starWarsFeignService.get()).thenReturn(mockFilm);

		// When
		Page<FilmData> result = filmService.get(null, null, PageRequest.of(0, 10));

		// Then
		assertEquals(3, result.getTotalElements());
	}

	@Test
	public void testGetFilmsByTitle() {
		// Given
		when(starWarsFeignService.get()).thenReturn(mockFilm);

		// When
		Page<FilmData> result = filmService.get("A New Hope", null, PageRequest.of(0, 10));

		// Then
		assertEquals(1, result.getTotalElements());
	}

	@Test
	public void testGetFilmsByEpisodeId() {
		// Given
		when(starWarsFeignService.get()).thenReturn(mockFilm);

		// When
		Page<FilmData> result = filmService.get(null, 2L, PageRequest.of(0, 10));

		// Then
		assertEquals(1, result.getTotalElements());
	}

	@Test
	public void testGetFilmsByTitleAndEpisodeId() {
		// Given
		when(starWarsFeignService.get()).thenReturn(mockFilm);

		// When
		Page<FilmData> result = filmService.get("A New Hope", 1L, PageRequest.of(0, 10));

		// Then
		assertEquals(1, result.getTotalElements());
	}

	@Test
	public void testSaveFilms() {
		List<FilmData> films = Arrays.asList(
				new FilmData("Episode I", 1L, "George Lucas", new Date()),
				new FilmData("Episode II", 2L, "George Lucas", new Date())
		);

		FilmRepository filmRepository = Mockito.mock(FilmRepository.class);
		StarWarsBaseService filmService = new StarWarsBaseService(starWarsFeignService,filmRepository);
		filmService.saveFilms(films);

		Mockito.verify(filmRepository, Mockito.times(films.size())).save(Mockito.any(FilmEntity.class));
	}

	@Test
	public void testSaveFilmsWithCorrectData() {
		List<FilmData> films = Arrays.asList(
				new FilmData("Episode I", 1L, "George Lucas", new Date()),
				new FilmData("Episode II", 2L, "George Lucas", new Date())
		);

		FilmRepository filmRepository = Mockito.mock(FilmRepository.class);
		StarWarsBaseService filmService = new StarWarsBaseService(starWarsFeignService,filmRepository);
		filmService.saveFilms(films);

		ArgumentCaptor<FilmEntity> argument = ArgumentCaptor.forClass(FilmEntity.class);
		Mockito.verify(filmRepository, Mockito.times(films.size())).save(argument.capture());

		List<FilmEntity> savedFilms = argument.getAllValues();
		for (int i = 0; i < films.size(); i++) {
			FilmData filmData = films.get(i);
			FilmEntity savedFilm = savedFilms.get(i);
			assertEquals(filmData.getTitle(), savedFilm.getTitle());
			assertEquals(filmData.getEpisode_id(), savedFilm.getEpisode_id());
			assertEquals(filmData.getDirector(), savedFilm.getDirector());
			assertEquals(filmData.getRelease_date(), savedFilm.getRelease_date());
		}
	}





}
