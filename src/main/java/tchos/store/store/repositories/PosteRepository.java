package tchos.store.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tchos.store.store.models.Poste;
import tchos.store.store.models.nomPoste;

// import java.util.List;
import java.util.UUID;

/** JpaRepository<Poste, UUID> Poste = Nom entite
 et UUID = type de la clef primaire de l'entité Poste */

@Repository
public interface PosteRepository extends JpaRepository<Poste, UUID> {
    // Pour eviter les doublons sur les postes en BD
    boolean existsDistinctByLibellePoste(nomPoste libellePoste);
}