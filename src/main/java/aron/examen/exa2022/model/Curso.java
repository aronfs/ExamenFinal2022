/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aron.examen.exa2022.model;

import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author arons
 */
@Getter
@Setter
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long curso_id;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prof_id;

    private String nombre_curso;

    private int nivel_curso;

    private String descripcion_curso;

}
