package tchos.store.store.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import tchos.store.store.models.Departement;
import tchos.store.store.repositories.DepartementRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartementService {

    private final DepartementRepository DepartementRepository;

    // Ajouter un nouveau département en BD
    public Departement addDepartement(Departement departement) {
        return DepartementRepository.save(departement);
    }

    // Recupérer la liste de tous les postes qui existent dans la BD
    public List<Departement> allDepartements() {
        return DepartementRepository.findAll();
    }

    // Recupérer un poste qui existe dans la BD par son ID
    public Optional<Departement> getDepartementById(UUID id) {
        return DepartementRepository.findById(id);
    }

    // Modifier les informations sur un poste (existingDepartement) dejà existant en BD
    public Departement updateDepartement(UUID id, Departement updatedDepartement) {
        return DepartementRepository.findById(id).map(
                existingDepartement -> {
                    existingDepartement.setLibelleDepartement(updatedDepartement.getLibelleDepartement());
                    return DepartementRepository.save(existingDepartement);
                }
        ).orElseThrow(() -> new RuntimeException("Département non trouvé !"));
    }

    // Supprimer de la BD un poste par son ID
    public void deleteDepartement(UUID id) {
        // Si le département a supprimer n'existe pas il faut afficher un message
        if (!DepartementRepository.existsById(id)) {
            throw new EntityNotFoundException("Le département avec id " + id + " n'existe pas !");
        }
        DepartementRepository.deleteById(id);
    }
}