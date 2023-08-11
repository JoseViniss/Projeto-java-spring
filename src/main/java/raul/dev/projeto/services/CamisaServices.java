package raul.dev.projeto.services;


import java.util.List;
//import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import raul.dev.projeto.classe.Camisa;
import raul.dev.projeto.repository.CamisaRepository;
import raul.dev.projeto.requests.CamisaPosRequestBody;
import raul.dev.projeto.requests.CamisaPutRequestBody;

@Service
@RequiredArgsConstructor
public class CamisaServices {

    private final EstampaServices estampaServices;
    
    private final CamisaRepository camisaRpository;

    private static List<Camisa> camisas;

    public List<Camisa> listAll(){
        return camisaRpository.findAll();
    }

    public Camisa findById(long id){
        return camisaRpository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Peça não encontrada"));

    } 

    public Camisa save(CamisaPosRequestBody camisaPosRequestBody) {
        Camisa camisa = Camisa.builder()
        .estampa(camisaPosRequestBody.getEstampa())
        .modelo(camisaPosRequestBody.getModelo())
        .preco_uni(camisaPosRequestBody.getPreco_uni())
        .tamanho(camisaPosRequestBody.getTamanho())
        .build();
        return camisaRpository.save(camisa);
    }

    public void delete(long id) {
        camisaRpository.delete(findById(id));
    }

    public void replace(CamisaPutRequestBody camisaPutRequestBody) {
        Camisa savedCamisa = findById(camisaPutRequestBody.getId());
        Camisa camisa = Camisa.builder()
        .estampa(camisaPutRequestBody.getEstampa())
        .modelo(camisaPutRequestBody.getModelo())
        .preco_uni(camisaPutRequestBody.getPreco_uni())
        .tamanho(camisaPutRequestBody.getTamanho())
        .build();
        camisaRpository.save(camisa);
    }

}
