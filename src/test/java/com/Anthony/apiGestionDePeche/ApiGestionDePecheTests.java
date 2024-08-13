package com.Anthony.apiGestionDePeche;

import com.Anthony.apiGestionDePeche.modele.*;
import com.Anthony.apiGestionDePeche.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiGestionDePecheTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private SortieRepository sortieRepository;

    @Autowired
    private LeurreRepository leurreRepository;

    @Autowired
    private PriseRepository priseRepository;

    @Autowired
    private PoissonRepository poissonRepository;

    private Utilisateur utilisateur;
    private Leurre leurre;
    private Sortie sortie;
    private Poisson poisson;

    @BeforeEach
    void setUp() {
        // Réinitialisation des données avant chaque test
        utilisateurRepository.deleteAll();
        sortieRepository.deleteAll();
        leurreRepository.deleteAll();
        priseRepository.deleteAll();
        poissonRepository.deleteAll();

        // Création des objets pour les tests
        utilisateur = new Utilisateur();
        utilisateur.setNom("Dupont");
        utilisateur.setPrenom("Jean");
        utilisateur.setIdentifiant("jdupont");
        utilisateur.setMotDePasse("password");
        utilisateur = utilisateurRepository.save(utilisateur);

        leurre = new Leurre();
        leurre.setNom("Leurre1");
        leurre = leurreRepository.save(leurre);

        sortie = new Sortie();
        sortie.setDateHeure(LocalDateTime.of(2024, 5, 20, 14, 30));
        sortie.setSpot("Océan Atlantique");
        sortie.setMeteo("Ensoleillé avec brise marine");
        sortie.setMaree(true);
        sortie.setCommentaire("Sortie en mer agréable");
        sortie.setUtilisateur(utilisateur);
        sortie = sortieRepository.save(sortie);

        poisson = new Poisson();
        poisson.setNom("Bar");
        poisson = poissonRepository.save(poisson);
    }

    @Test
    public void testCreationUtilisateur() throws Exception {
        // Test de création d'un utilisateur
        mockMvc.perform(post("/utilisateur/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nom\": \"Doe\", \"prenom\": \"John\", \"identifiant\": \"jdoe\", \"motDePasse\": \"secret\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", is("Doe")))
                .andExpect(jsonPath("$.prenom", is("John")))
                .andExpect(jsonPath("$.identifiant", is("jdoe")));
    }

    @Test
    public void testModificationUtilisateur() throws Exception {
        // Test de modification d'un utilisateur
        mockMvc.perform(put("/utilisateur/update/" + utilisateur.getIdUtilisateur())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nom\": \"Durand\", \"prenom\": \"Jacques\", \"identifiant\": \"jdupont\", \"motDePasse\": \"newpassword\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", is("Durand")))
                .andExpect(jsonPath("$.prenom", is("Jacques")))
                .andExpect(jsonPath("$.identifiant", is("jdupont")));
    }

    @Test
    public void testCreationSortie() throws Exception {
        // Test de création d'une sortie en mer
        mockMvc.perform(post("/sortie/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dateHeure\": \"2024-05-21T10:00:00\", \"spot\": \"Golfe de Gascogne\", \"meteo\": \"Nuageux avec houle légère\", \"maree\": true, \"commentaire\": \"Sortie en mer réussie\", \"utilisateur\": {\"idUtilisateur\": " + utilisateur.getIdUtilisateur() + "}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.spot", is("Golfe de Gascogne")));
    }

    @Test
    public void testCreationPrise() throws Exception {
        // Test de création d'une prise
        mockMvc.perform(post("/prise/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"taille\": 15, \"poids\": 2.8, \"remarque\": \"Très bon leurre\", \"leurre\": {\"idLeurre\": " + leurre.getIdLeurre() + "}, \"sortie\": {\"idSortie\": " + sortie.getIdSortie() + "}, \"poisson\": {\"idPoisson\": " + poisson.getIdPoisson() + "}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.poids", is(2.8)));
    }


    @Test
    public void testLeurreStatistics() throws Exception {
        // Création d'une prise pour générer des statistiques
        Prise prise = new Prise();
        prise.setTaille((byte) 50);
        prise.setPoids(3.5);
        prise.setRemarque("Belle prise, bon leurre");
        prise.setLeurre(leurre);
        prise.setSortie(sortie);
        prise.setPoisson(poisson);
        priseRepository.save(prise);

        // Test des statistiques du leurre en mer
        mockMvc.perform(get("/statistique/leurre")
                .param("year", "2024"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nomLeurre", is("Leurre1")))
                .andExpect(jsonPath("$[0].nombreDePrises", is(1)));
    }
}
