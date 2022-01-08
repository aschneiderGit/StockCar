package esiea.metier;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import esiea.metier.Voiture.Carburant;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

class VoitureTest {
    final int V1_ID = 0;
    final String V1_MARQUE = "Honda";
    final String V1_MODELE = "Civic";
    final String V1_FINITION = "R";
    final Carburant V1_CARBURANT = Carburant.get("E");
    final int V1_KM = 40000;
    final int V1_ANNEE = 2020;
    final int V1_PRIX = 40000;
    final String STRING = "string";
    final String ENTIER = "entier";
    Voiture v1;

    @BeforeEach
    void setUp() {
        v1 = new Voiture();
        v1.setId(V1_ID);
        v1.setMarque(V1_MARQUE);
        v1.setModele(V1_MODELE);
        v1.setFinition(V1_FINITION);
        v1.setCarburant(V1_CARBURANT);
        v1.setAnnee(V1_ANNEE);
        v1.setPrix(V1_PRIX);
        v1.setKm(V1_KM);

    }

    @Test
    void GetterTest() {
        assertEquals(V1_ID, v1.getId());
        assertEquals(V1_MARQUE, v1.getMarque());
        assertEquals(V1_MODELE, v1.getModele());
        assertEquals(V1_FINITION, v1.getFinition());
        assertEquals(V1_CARBURANT, v1.getCarburant());
        assertEquals(V1_ANNEE, v1.getAnnee());
        assertEquals(V1_PRIX, v1.getPrix());
        assertEquals( V1_KM, v1.getKm());
    }

    @Test
    void testToString() {
        assertEquals(v1.toString(), """
                {"id":0,"marque":"Honda","modele":"Civic","finition":"R","carburant":"ESSENCE","km":40000,"annee":2020,"prix":40000} """);
    }
    @Test
    void checkID() {
        assertTrue(v1.check());
        v1.setId(-1);
        assertFalse(v1.check());
    }

    @Test
    void checkMarque() {
        assertTrue(v1.check());
        v1.setMarque("");
        assertFalse(v1.check());
        v1.setMarque(null);
        assertFalse(v1.check());
    }

    @Test
    void checkModele() {
        assertTrue(v1.check());
        v1.setModele("");
        assertFalse(v1.check());
        v1.setModele(null);
        assertFalse(v1.check());
    }

    @Test
    void checkFinition() {
        assertTrue(v1.check());
        v1.setFinition("");
        assertFalse(v1.check());
        v1.setFinition(null);
        assertFalse(v1.check());
    }

    @Test
    void checkCarburant() {
        assertTrue(v1.check());
        v1.setCarburant(null);
        assertFalse(v1.check());
    }

    @Test
    void checkKm() {
        assertTrue(v1.check());
        v1.setKm(-1);
        assertFalse(v1.check());
    }

    @Test
    void checkAnnee() {
        assertTrue(v1.check());
        v1.setAnnee(-1);
        assertFalse(v1.check());
        v1.setAnnee(1899);
        assertFalse(v1.check());
        v1.setAnnee(1899);
        assertFalse(v1.check());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        v1.setAnnee(calendar.get(Calendar.YEAR)+1);
        assertFalse(v1.check());
    }

    @Test
    void checkPrix() {
        assertTrue(v1.check());
        v1.setPrix(-1);
        assertFalse(v1.check());
    }
    @Test
    void getTypeDonnee() {
        assertEquals(ENTIER, Voiture.getTypeDonnee("km"));
        assertEquals("", Voiture.getTypeDonnee(null));
        assertEquals(STRING, Voiture.getTypeDonnee("modele"));
    }

    @Test
    void enumCarburantTest() {
        assertEquals("ESSENCE", Carburant.get("E").name());
        assertEquals("HYBRIDE", Carburant.get("H").name());
        assertEquals("ELECTRIQUE", Carburant.get("W").name());
        assertEquals("DIESEL", Carburant.get("D").name());
    }
}
