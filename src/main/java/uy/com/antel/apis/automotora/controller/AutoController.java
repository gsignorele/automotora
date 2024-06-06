package uy.com.antel.apis.automotora.controller;



import uy.com.antel.apis.automotora.model.Auto;
import uy.com.antel.apis.automotora.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto) {
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
        return auto != null ? ResponseEntity.ok(auto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auto> updateAuto(@PathVariable Long id, @RequestBody Auto autoDetails) {
        Auto updatedAuto = autoService.updateAuto(id, autoDetails);
        return updatedAuto != null ? ResponseEntity.ok(updatedAuto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuto(@PathVariable Long id) {
        boolean deleted = autoService.deleteAuto(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
