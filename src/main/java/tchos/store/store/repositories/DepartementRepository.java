package tchos.store.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tchos.store.store.models.Departement;

import java.util.UUID;

// JpaRepository<Departement, UUID> Departement = Nom entite et UUID = type de la clef primaire
@Repository
public interface DepartementRepository extends JpaRepository<Departement, UUID> {
    // Pour eviter les doublons sur les departements en BD
    boolean existsDistinctByLibelleDepartement(String libelleDepartement);
}