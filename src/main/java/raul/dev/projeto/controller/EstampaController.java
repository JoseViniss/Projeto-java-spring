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
import raul.dev.projeto.services.EstampaServices;
import raul.dev.projeto.util.DateUtil;
import raul.dev.projeto.classe.Estampa;
import raul.dev.projeto.requests.EstampaPosRequestBody;
import raul.dev.projeto.requests.EstampaPutRequestBody;

@RestController
@RequestMapping("estampas")
@Log4j2
@RequiredArgsConstructor

public class EstampaController {
    
    private final DateUtil dateUtil;
    private final EstampaServices estampaServices;

    @GetMapping
    public ResponseEntity<List<Estampa>> list(){
        log.info(dateUtil.dataLocalHora(LocalDateTime.now()));
       return new ResponseEntity<>(estampaServices.listAll(), HttpStatus.OK) ;
    } 

    @GetMapping(path = "/{id}")
    public ResponseEntity<Estampa> findById(@PathVariable long id){
       return ResponseEntity.ok(estampaServices.findById(id));  
    } 

    @PostMapping
    public ResponseEntity<Estampa> save(@RequestBody EstampaPosRequestBody estampa){
        return new ResponseEntity<>(estampaServices.save(estampa), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        estampaServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody EstampaPutRequestBody estampaPutRequestBody) {
        estampaServices.replace(estampaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
