package raul.dev.projeto.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import raul.dev.projeto.classe.Camisa;
import raul.dev.projeto.requests.CamisaPosRequestBody;
import raul.dev.projeto.requests.CamisaPutRequestBody;
import raul.dev.projeto.services.CamisaServices;
import raul.dev.projeto.util.DateUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("camisas")
@Log4j2
@RequiredArgsConstructor

public class CamisaController {
    
    private final DateUtil dateUtil;
    private final CamisaServices camisaServices;

    @GetMapping(path = "/index")
    public ResponseEntity<List<Camisa>> list(){
        log.info(dateUtil.dataLocalHora(LocalDateTime.now()));
       return new ResponseEntity<>(camisaServices.listAll(), HttpStatus.OK) ;
    } 

    @GetMapping(path = "/{id}")
    public ResponseEntity<Camisa> findById(@PathVariable long id){
       return ResponseEntity.ok(camisaServices.findById(id));  
    } 

    @PostMapping(path = "/post")
    public ResponseEntity<Camisa> save(@RequestBody CamisaPosRequestBody camisa){
        return new ResponseEntity<>(camisaServices.save(camisa), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        camisaServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CamisaPutRequestBody camisaPutRequestBody) {
        camisaServices.replace(camisaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
