/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aron.examen.exa2022.repository;

import aron.examen.exa2022.model.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author arons
 */
public interface ProfesorRepository extends MongoRepository<Profesor, Long>{
    
}
