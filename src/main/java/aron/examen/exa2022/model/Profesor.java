/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aron.examen.exa2022.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author arons
 */
@Getter
@Setter
@Document(collection = "Profesor")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prof_id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dep_id;

    private String nombre_profesor;

    private String direccion_profesor;

    private String telefono_profesor;

    private List<Curso> Curso;
    private List<Departamento> Departamento;

}
