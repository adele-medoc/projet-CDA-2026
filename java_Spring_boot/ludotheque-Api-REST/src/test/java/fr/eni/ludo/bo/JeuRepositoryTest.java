package fr.eni.ludo.bo;

import fr.eni.ludo.repository.GenreRepository;
import fr.eni.ludo.repository.JeuRepository;
import fr.eni.ludo.service.JeuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    JeuRepository jeuRepository;

    @Autowired
    GenreRepository genreRepository;
    @Autowired
    JeuService jeuService;
    @Test
    public void creaJeuBdd(){
        Jeu jeu = new Jeu();
        jeu.setTitre("dany");
        jeu.setReference("A1e2r2t3y3u45");
        jeu.setAge_min(12);
        jeu.setDescription("Dany fera tout pour vous faire échouer...\n" +
                "Dany est un jeu de communication et de déduction dans un univers onirique. ");
        jeu.setTarif_jour(2.5);

        Jeu j = jeuRepository.save(jeu);

        assertThat(j.getId_jeu()).isEqualTo(1);
        assertThat(j.getDuree()).isNotNull();
    }

    @Test
    public void creaJeuBddEtGenre(){

        Genre genre = new Genre();
        genre.setLibelle("jeu d'ambiance");
        Genre genreBdd = genreRepository.save(genre);

        Genre genre2 = new Genre();
        genre.setLibelle("jeu asymétrique");
        Genre genreBdd2 = genreRepository.save(genre2);

        Jeu jeu = new Jeu();
        jeu.setTitre("dany");
        jeu.setReference("A1e2r2t3y3u45");
        jeu.setAge_min(12);
        jeu.setDescription("Dany fera tout pour vous faire échouer...\n" +
                "Dany est un jeu de communication et de déduction dans un univers onirique. ");
        jeu.setTarif_jour(2.5);
        jeu.getGenres().add(genreBdd);
        jeu.getGenres().add(genreBdd2);

        Jeu j = jeuRepository.save(jeu);

        assertThat(j).isNotNull();
        assertThat(j.getGenres()).isNotNull();
    }
    @Test
    public void CreaJeuBll(){

        List<Genre> genres = new ArrayList<>();
        Genre genre = new Genre();
        genre.setLibelle("jeu d'ambiance");
        Genre genreBdd = genreRepository.save(genre);

        Genre genre2 = new Genre();
        genre.setLibelle("jeu asymétrique");
        Genre genreBdd2 = genreRepository.save(genre2);
        genres.add(genreBdd2);
        genres.add(genreBdd);
        Jeu j = jeuService.creerJeu("dany","1234567891234",12,"description",20,20,genres);
        assertThat(j.getId_jeu()).isNotNull();
        assertThat(j.getTitre()).isEqualTo("dany");

    }
}
