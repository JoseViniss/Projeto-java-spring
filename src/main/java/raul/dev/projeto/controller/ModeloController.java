package raul.dev.projeto.controller;

import java.time.LocalDateTime;
import java.util.List;

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

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import raul.dev.projeto.classe.Modelo;
import raul.dev.projeto.requests.ModeloPutRequestBody;
import raul.dev.projeto.services.ModeloServices;
import raul.dev.projeto.util.DateUtil;

@RestController
@RequestMapping("modelos")
@Log4j2
@RequiredArgsConstructor

public class ModeloController {
    
    private final DateUtil dateUtil;
    private final ModeloServices modeloServices;

    @GetMapping
    public ResponseEntity<List<Modelo>> list(){
        log.info(dateUtil.dataLocalHora(LocalDateTime.now()));
       return new ResponseEntity<>(modeloServices.listAll(), HttpStatus.OK) ;
    } 

    @GetMapping(path = "/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable long id){
       return ResponseEntity.ok(modeloServices.findById(id));  
    } 

    @PostMapping
    public ResponseEntity<Modelo> save(@RequestBody ModeloPutRequestBody modelo){
        return new ResponseEntity<>(modeloServices.save(modelo), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        modeloServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ModeloPutRequestBody modeloPutRequestBody) {
        modeloServices.replace(modeloPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
