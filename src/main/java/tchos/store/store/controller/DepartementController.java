package tchos.store.store.controller;

import lombok.RequiredArgsConstructor;
import tchos.store.store.services.DepartementService;
import tchos.store.store.services.EmployeService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/departement")
public class DepartementController {

    private final DepartementService departementService;
    private final EmployeService employeService;
}