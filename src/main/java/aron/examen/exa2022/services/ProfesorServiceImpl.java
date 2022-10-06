/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aron.examen.exa2022.services;

import aron.examen.exa2022.model.Profesor;
import aron.examen.exa2022.repository.ProfesorRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author arons
 */
@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long> implements ProfesorService{

    @Autowired
    ProfesorRepository repositorio;
    
    
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return repositorio;
    }
   
    
}
