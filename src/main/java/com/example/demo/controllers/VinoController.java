package com.example.demo.controllers;


import com.example.demo.models.Maridaje;
import com.example.demo.models.Resenia;
import com.example.demo.models.Varietal;
import com.example.demo.models.Vino;
import com.example.demo.repository.BodegaRepository;
import com.example.demo.repository.MaridajeRepository;
import com.example.demo.repository.ReseniaRepository;
import com.example.demo.repository.TipoUvaRepository;
import com.example.demo.repository.VarietalRepository;
import com.example.demo.repository.VinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Bodega-4/vinos")
public class VinoController {

    @Autowired
    private VinoRepository vinoRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private ReseniaRepository reseniaRepository;

    @Autowired
    private VarietalRepository varietalRepository;

    @Autowired
    private MaridajeRepository maridajeRepository;

    @Autowired
    private TipoUvaRepository tipoUvaRepository;

    @GetMapping
    public ResponseEntity<?> getVinos() {
        List<Vino> vinos = vinoRepository.findAll();
        if (vinos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay vinos disponibles");
        } else {
            return ResponseEntity.ok(vinos);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> save(@RequestBody Vino vino) {
        try {
            // Guardar la bodega si no existe
            if (vino.getBodega() != null && vino.getBodega().getId() == null) {
                bodegaRepository.save(vino.getBodega());
            }

            // Guardar las reseñas si no existen
            if (vino.getResenia() != null) {
                for (Resenia resenia : vino.getResenia()) {
                    if (resenia.getId() == null) {
                        reseniaRepository.save(resenia);
                    }
                }
            }

            // Guardar los varietales y sus tipos de uva si no existen
            if (vino.getVarietal() != null) {
                for (Varietal varietal : vino.getVarietal()) {
                    if (varietal.getTipoUva() != null && varietal.getTipoUva().getId() == null) {
                        tipoUvaRepository.save(varietal.getTipoUva());
                    }
                    if (varietal.getId() == null) {
                        varietalRepository.save(varietal);
                    }
                }
            }

            // Guardar los maridajes si no existen
            if (vino.getMaridaje() != null) {
                for (Maridaje maridaje : vino.getMaridaje()) {
                    if (maridaje.getId() == null) {
                        maridajeRepository.save(maridaje);
                    }
                }
            }

            // Guardar el vino
            vinoRepository.save(vino);

            return ResponseEntity.ok("Vino agregado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar el vino: " + e.getMessage());
        }
    }
}
