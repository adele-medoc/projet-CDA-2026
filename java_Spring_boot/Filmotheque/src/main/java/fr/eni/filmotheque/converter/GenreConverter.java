package fr.eni.filmotheque.converter;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.service.GenreService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter implements Converter<String, Genre>  {

    @Autowired
    GenreService genreService;

    @Override
    public Genre convert(String idgenre) {
        long id = Long.parseLong(idgenre);
        return genreService.consulterGenresById(id);
    }
}
