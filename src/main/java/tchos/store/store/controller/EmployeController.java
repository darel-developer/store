package tchos.store.store.controller;

import lombok.RequiredArgsConstructor;
import tchos.store.store.services.EmployeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import tchos.store.store.models.nomPoste;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employes")
public class EmployeController {

    private final EmployeService employeService;

    @GetMapping
    public String listEmployes(Model model) {
        model.addAttribute("employes", employeService.getAllEmployes());
        return "employe/listemploye";
    }

    @GetMapping("/new")
    public String addEmploye(Model model) {
        model.addAttribute("employe", new tchos.store.store.dto.EmployeDTO(
            null, "", "", null, null, null, ""
        ));
        model.addAttribute("postes", nomPoste.values());
        // Remplacez cette liste par la vraie liste de départements si besoin
        model.addAttribute("departements", List.of("RH", "Finance", "IT", "Commercial"));
        return "employe/addemploye";
    }

}