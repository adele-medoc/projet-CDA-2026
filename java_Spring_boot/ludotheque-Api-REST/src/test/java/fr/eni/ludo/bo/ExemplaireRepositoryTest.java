package fr.eni.ludo.bo;

import fr.eni.ludo.repository.ExemplaireRepository;
import fr.eni.ludo.repository.GenreRepository;
import fr.eni.ludo.repository.JeuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ExemplaireRepositoryTest {

    @Autowired
    JeuRepository jeuRepository;
    @Autowired
    ExemplaireRepository exemplaireRepository;
    @Autowired
    GenreRepository genreRepository;

    @Test
    public void ajoutExemplaire(){
        Genre genre = new Genre();
        genre.setLibelle("jeu d'ambiance");
        Genre genreBdd = genreRepository.save(genre);

        Jeu jeu = new Jeu();
        jeu.setTitre("dany");
        jeu.setReference("A1e2r2t3y3u45");
        jeu.setAge_min(12);
        jeu.setDescription("Dany fera tout pour vous faire échouer...\n" +
                "Dany est un jeu de communication et de déduction dans un univers onirique. ");
        jeu.setTarif_jour(2.5);
        jeu.setDuree(25);
        jeu.getGenres().add(genre);
        Jeu j = jeuRepository.save(jeu);

        Exemplaire exDany = new Exemplaire();
        exDany.setJeu(jeu);
        exDany.setCode_barre("codebarre");
        exDany.setLouable(true);

        exemplaireRepository.save(exDany);

        Exemplaire exemplaireFromBD = exemplaireRepository.findById(exDany.getId_exemplaire()).orElse(null);
        assertThat(exemplaireFromBD).isNotNull();
        assertThat(exemplaireFromBD.getId_exemplaire()).isNotNull();
        assertThat(exemplaireFromBD.getCode_barre()).isEqualTo(exDany.getCode_barre());
        assertThat(exemplaireFromBD.isLouable()).isEqualTo(exDany.isLouable());
//        assertThat(exemplaireFromBD.getJeu()).isEqualTo(exDany.getJeu()); --> adresse mémoire différente
    }
}
