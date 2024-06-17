package uy.com.antel.apis.automotora.controller;

import uy.com.antel.apis.automotora.exceptions.InvalidColorException;
import uy.com.antel.apis.automotora.model.Auto;
import uy.com.antel.apis.automotora.model.ErrorResponse;
import uy.com.antel.apis.automotora.service.AutoService;
import uy.com.antel.apis.automotora.service.ColorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;
    @Autowired
    private ColorService colorService;
  
    
    @PostMapping
    public ResponseEntity<?> createAuto(@Valid @RequestBody Auto auto/*, BindingResult bindingResult*/) {
    	/*
        if (bindingResult.hasErrors()) {
        	       	
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
    	*/
        Auto nuevoAuto = autoService.createAuto(auto);
        return ResponseEntity.status(201).body(nuevoAuto);
    }        
    
    @GetMapping
    public ResponseEntity<List<Auto>> getAllAutos() {
        List<Auto> autos = autoService.getAllAutos();
        return ResponseEntity.ok(autos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable Long id) {
        Auto auto = autoService.getAutoById(id);
        //return auto != null ? ResponseEntity.ok(auto) : ResponseEntity.notFound().build();
        if (auto != null) {
        	return ResponseEntity.ok(auto);
        } else {
        	return ResponseEntity.notFound().build();
        }        
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuto(@PathVariable Long id, @Valid @RequestBody Auto autoDetails) {
    	/*
        Auto updatedAuto = autoService.updateAuto(id, autoDetails);
        return updatedAuto != null ? ResponseEntity.ok(updatedAuto) : ResponseEntity.notFound().build();
        */
        if (!colorService.isValidColor(autoDetails.getColor().toLowerCase())) {
        	ErrorResponse errorResponse = new ErrorResponse("Color no válido: " + autoDetails.getColor());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Auto updatedAuto = autoService.updateAuto(id, autoDetails);
        if (updatedAuto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedAuto);
    	
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable Long id) {
        boolean deleted = autoService.deleteAuto(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
