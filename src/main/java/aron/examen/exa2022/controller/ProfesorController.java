/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aron.examen.exa2022.controller;

import aron.examen.exa2022.model.Profesor;
import aron.examen.exa2022.services.ProfesorService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author arons
 */
@RestController
@RequestMapping("/api/Profesor")
public class ProfesorController {
    
    @Autowired
    private ProfesorService servicio;
    
     @GetMapping("/listaProfesor")
      @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Se listo Correctamente", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "400", description = "Los Parametros ingresados no son correctos", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "500", description = "La base esta mal", content = {
            @Content(mediaType = "aplication/json")})
    })
    public ResponseEntity<List<Profesor>> listar() {
        List<Profesor> lista = servicio.findByAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/creaProfesor")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Se listo Correctamente", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "400", description = "Los Parametros ingresados no son correctos", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "500", description = "La base esta mal", content = {
            @Content(mediaType = "aplication/json")})
    })
    public ResponseEntity<String> crear(@RequestBody Profesor p) {
        if(p.getNombre_profesor().matches("^[a-zA-Z]*") && p.getDireccion_profesor().matches("^[a-zA-Z]*") ){
            if(p.getTelefono_profesor().matches("^[0-9]*")){
                 servicio.save(p);
                return new ResponseEntity<>("Sus campos ingresados son correctos", HttpStatus.OK);
            }else{
                 return new ResponseEntity<>("Campos ingresados no validos solo numeros", HttpStatus.BAD_REQUEST);
            }     
        }else{
              return new ResponseEntity<>("Campos ingresados no validos solo letras", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscarProfesor/{id}")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Se listo Correctamente", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "400", description = "Los Parametros ingresados no son correctos", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "500", description = "La base esta mal", content = {
            @Content(mediaType = "aplication/json")})
    })
    public ResponseEntity<Profesor> buscar(@PathVariable Long id) {
        Profesor objeto = servicio.findById(id);
        return new ResponseEntity<>(objeto, HttpStatus.OK);
    }

    @PutMapping("/actualizarProfesor/{id}")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Se listo Correctamente", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "400", description = "Los Parametros ingresados no son correctos", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "500", description = "La base esta mal", content = {
            @Content(mediaType = "aplication/json")})
    })
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor per) {
        Profesor objeto = servicio.findById(id);
        if (objeto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                objeto.setNombre_profesor(per.getNombre_profesor());
                objeto.setDireccion_profesor(per.getDireccion_profesor());
                objeto.setTelefono_profesor(per.getDireccion_profesor());
                return new ResponseEntity<>(servicio.save(objeto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminarProfesor/{id}")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Se listo Correctamente", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "400", description = "Los Parametros ingresados no son correctos", content = {
            @Content(mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "500", description = "La base esta mal", content = {
            @Content(mediaType = "aplication/json")})
    })
    public ResponseEntity<Profesor> eliminar(@PathVariable Long id) {
        servicio.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
