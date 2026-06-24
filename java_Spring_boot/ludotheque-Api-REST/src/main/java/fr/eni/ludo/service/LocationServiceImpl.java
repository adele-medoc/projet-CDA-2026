package fr.eni.ludo.service;

import fr.eni.ludo.bo.Exemplaire;
import fr.eni.ludo.bo.Jeu;
import fr.eni.ludo.bo.Location;
import fr.eni.ludo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void LouerJeu(Exemplaire exemplaireAlouer) throws Exception {
        if(exemplaireAlouer.isDisponible() && exemplaireAlouer.isLouable()){
            Location l = new Location();
            
//            locationRepository.save();
        }else{
            throw new Exception("impossible de louer l'exemplaire car il est indisponible");
        }
    }
}
