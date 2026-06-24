package fr.eni.ludo.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 100)
    private String nom;
    @Column(length = 100)
    private String prenom;
    @Column(length = 100)
    private String email;
    @Column(nullable = true,length = 20)
    private String telephone;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
    private Adresse adresse;
//
//    @OneToMany(mappedBy = "location")
//    private List<Location> locations;

    public Client(String nom, String prenom, String email, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    public Client(Adresse adresse, String telephone, String email, String prenom, String nom) {
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
    }
}
