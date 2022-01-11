package esiea.metier;

import esiea.metier.Voiture;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
//import java.esiea.metier.Voiture.Carburant;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

class VoitureTest {
    final int V1_ID = 0;
    final String V1_MARQUE = "Honda";
    final String V1_MODELE = "Civic";
    final String V1_FINITION = "R";
    final Voiture.Carburant V1_CARBURANT = Voiture.Carburant.get("E");
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
    void toStringTest() {
        assertTrue(new String("{" +
            "\"id\":0," +
            "\"marque\":\"Honda\"," +
            "\"modele\":\"Civic\"," +
            "\"finition\":\"R\"," +
            "\"carburant\":\"ESSENCE\"," +
            "\"km\":40000," +
            "\"annee\":2020," +
            "\"prix\":40000" +
            "}").equals("{" +
            "\"id\":0," +
            "\"marque\":\"Honda\"," +
            "\"modele\":\"Civic\"," +
            "\"finition\":\"R\"," +
            "\"carburant\":\"ESSENCE\"," +
            "\"km\":40000," +
            "\"annee\":2020," +
            "\"prix\":40000" +
            "}"));
    }

        @Test
    void TestcheckID() {
        assertTrue(v1.check());
        v1.setId(-1);
        assertFalse(v1.check());
    }

    @Test
    void TestcheckMarque() {
        assertTrue(v1.check());
        v1.setMarque("");
        assertFalse(v1.check());
        v1.setMarque(null);
        assertFalse(v1.check());
    }

    @Test
    void TestcheckModele() {
        assertTrue(v1.check());
        v1.setModele("");
        assertFalse(v1.check());
        v1.setModele(null);
        assertFalse(v1.check());
    }

    @Test
    void TestcheckFinition() {
        assertTrue(v1.check());
        v1.setFinition("");
        assertFalse(v1.check());
        v1.setFinition(null);
        assertFalse(v1.check());
    }

    @Test
    void TestcheckCarburant() {
        assertTrue(v1.check());
        v1.setCarburant(null);
        assertFalse(v1.check());
    }

    @Test
    void TestcheckKm() {
        assertTrue(v1.check());
        v1.setKm(-1);
        assertFalse(v1.check());
    }

    @Test
    void TestcheckAnnee() {
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
    void TestcheckPrix() {
        assertTrue(v1.check());
        v1.setPrix(-1);
        assertFalse(v1.check());
    }
    @Test
    void TestgetTypeDonnee() {
        assertEquals(ENTIER, Voiture.getTypeDonnee("km"));
        assertEquals("", Voiture.getTypeDonnee(null));
        assertEquals(STRING, Voiture.getTypeDonnee("modele"));
    }

    @Test
    void TestenumCarburantTest() {
        assertEquals("ESSENCE", Voiture.Carburant.get("E").name());
        assertEquals("HYBRIDE", Voiture.Carburant.get("H").name());
        assertEquals("ELECTRIQUE", Voiture.Carburant.get("W").name());
        assertEquals("DIESEL", Voiture.Carburant.get("D").name());
    }
}
