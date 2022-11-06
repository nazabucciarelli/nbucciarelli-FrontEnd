/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nbucciarelli.nbucciarelli.Controller;

import com.nbucciarelli.nbucciarelli.Dto.dtoPersona;
import com.nbucciarelli.nbucciarelli.Entity.Persona;
import com.nbucciarelli.nbucciarelli.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nazareno
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return iPersonaService.getPersonas();
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona getPersonaPerfil(){
        return iPersonaService.findPersona((long)1);
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona p) {
        iPersonaService.savePersona(p);
        return "Persona creada exitosamente.";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "Persona borrada exitosamente.";
    }

    @PutMapping("/personas/editar/1")
    public Persona editPersona( @RequestBody dtoPersona dtoPer) {
        Persona p = iPersonaService.findPersona((long)1);

        p.setNombre(dtoPer.getNombre());
        p.setApellido(dtoPer.getApellido());
        p.setImg(dtoPer.getImg());
        p.setProfesion(dtoPer.getProfesion());
        p.setSobremi(dtoPer.getSobremi());
        p.setUrlcv(dtoPer.getUrlcv());


        iPersonaService.savePersona(p);
        return p;

    }
}
