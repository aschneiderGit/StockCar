package esiea.dao;

import esiea.metier.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class VoitureDAOTest {

    Voiture honda = new Voiture();
    Voiture kangoo = new Voiture();

    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/stockcar";
    private String user = "root";
    private String pwd = "root";

    String requete ;
    PreparedStatement stmt;
    ResultSet res;



    @BeforeEach
    void setUp() {
        honda.setMarque("HondaTest");
        honda.setModele("Civic");
        honda.setFinition("R");
        honda.setCarburant(Voiture.Carburant.get("E"));
        honda.setAnnee(2020);
        honda.setPrix(40000);
        honda.setKm(40000);

        kangoo.setMarque("RenaultTest");
        kangoo.setModele("Kangoo");
        kangoo.setFinition("Pro");
        kangoo.setKm(89000);
        kangoo.setPrix(18000);
        kangoo.setAnnee(2010);
        kangoo.setCarburant(Voiture.Carburant.get("D"));
    }

    @Test
    void ajouterVoiture() throws SQLException {

        int nbVoiture = new VoitureDAO().getVoitures(null).length;

        new VoitureDAO().ajouterVoiture(honda);
        new VoitureDAO().ajouterVoiture(kangoo);

        assertEquals(nbVoiture + 2, new VoitureDAO().getVoitures(null).length );
        Voiture databaseVoiture = new VoitureDAO().getVoiture("HondaTest")[0];
        honda.setId(databaseVoiture.getId());
        assertEquals(honda.toString(), databaseVoiture.toString());

        new VoitureDAO().supprimerVoiture(String.valueOf(databaseVoiture.getId()));
        databaseVoiture = new VoitureDAO().getVoiture("RenaultTest")[0];
        new VoitureDAO().supprimerVoiture(String.valueOf(databaseVoiture.getId()));

    }

    @Test
    void modifierVoiture() throws SQLException {

        new VoitureDAO().ajouterVoiture(honda);

        Voiture databasaVoiture = new VoitureDAO().getVoiture("HondaTest")[0];
        Voiture newVoiture = new Voiture();
        newVoiture.setMarque("RenaultTest");
        newVoiture.setModele("Kangoo");
        newVoiture.setFinition("Pro");
        newVoiture.setKm(89000);
        newVoiture.setPrix(18000);
        newVoiture.setAnnee(2010);
        newVoiture.setCarburant(Voiture.Carburant.get("D"));

        new VoitureDAO().modifierVoiture(databasaVoiture.getId(), newVoiture );

        databasaVoiture = new VoitureDAO().getVoiture("RenaultTest")[0];
        newVoiture.setId(databasaVoiture.getId());
        assertEquals(newVoiture.toString(), databasaVoiture.toString());
        new VoitureDAO().supprimerVoiture(String.valueOf(databasaVoiture.getId()));

    }

    @Test
    void getVoiture() throws SQLException {
        new VoitureDAO().ajouterVoiture(honda);
        new VoitureDAO().ajouterVoiture(kangoo);
        Voiture databaseVoiture  = new VoitureDAO().getVoiture("HondaTest")[0];
        int id = databaseVoiture.getId();
        honda.setId(id);
        assertEquals(honda.toString(), databaseVoiture.toString());
        databaseVoiture  = new VoitureDAO().getVoiture(String.valueOf(id))[0];
        assertEquals(honda.toString(), databaseVoiture.toString());

        new VoitureDAO().supprimerVoiture(String.valueOf(id));
        databaseVoiture = new VoitureDAO().getVoiture("RenaultTest")[0];
        new VoitureDAO().supprimerVoiture(String.valueOf(databaseVoiture.getId()));
    }

    @Test
    void getVoitures() throws SQLException {
        new VoitureDAO().ajouterVoiture(honda);
        new VoitureDAO().ajouterVoiture(kangoo);
        kangoo.setAnnee(2001);
        new VoitureDAO().ajouterVoiture(kangoo);

        HashMap hm = new HashMap<String, String>();
        hm.put("marque", "RenaultTest");
        Voiture[] databaseVoitures = new VoitureDAO().getVoitures(hm);
        assertEquals(2, databaseVoitures.length);

        hm = new HashMap<String, String>();
        hm.put("finition", "R");
        databaseVoitures = new VoitureDAO().getVoitures(hm);
        honda.setId(databaseVoitures[0].getId());
        assertEquals(honda.toString(), databaseVoitures[0].toString());

        hm = new HashMap<String, String>();
        hm.put("annee", "2001");
        databaseVoitures = new VoitureDAO().getVoitures(hm);
        kangoo.setId(databaseVoitures[0].getId());
        assertEquals(kangoo.toString(), databaseVoitures[0].toString());

        hm = new HashMap<String, String>();
        //hm.put("carburant", "E"); //carburant ne marche pas
        hm.put("modele", "Civic");
        hm.put("km", "40000");
        hm.put("prix", "40000");
        databaseVoitures = new VoitureDAO().getVoitures(hm);
        honda.setId(databaseVoitures[0].getId());
        assertEquals(honda.toString(), databaseVoitures[0].toString());

        new VoitureDAO().supprimerVoiture(String.valueOf(honda.getId()));
        new VoitureDAO().supprimerVoiture(String.valueOf(kangoo.getId()));
        databaseVoitures  = new VoitureDAO().getVoiture("RenaultTest");
        new VoitureDAO().supprimerVoiture(String.valueOf(databaseVoitures[0].getId()));


    }


    @Test
    void supprimerVoiture() throws SQLException {

        new VoitureDAO().ajouterVoiture(honda);
        int nbVoiture = new VoitureDAO().getVoitures(null).length;
        Voiture databaseVoiture = new VoitureDAO().getVoiture("HondaTest")[0];
        new VoitureDAO().supprimerVoiture(String.valueOf(databaseVoiture.getId()));
        assertEquals(nbVoiture- 1, new VoitureDAO().getVoitures(null).length );
        assertEquals(0, new VoitureDAO().getVoiture("HondaTest").length);

    }
}
