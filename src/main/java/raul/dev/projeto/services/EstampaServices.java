package raul.dev.projeto.services;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import raul.dev.projeto.classe.Estampa;
import raul.dev.projeto.repository.EstampaRepository;
import raul.dev.projeto.requests.EstampaPosRequestBody;
import raul.dev.projeto.requests.EstampaPutRequestBody;

@Service
@RequiredArgsConstructor
public class EstampaServices {

    private final EstampaRepository estampaRpository;

    private static List<Estampa> estampas;

    public List<Estampa> listAll(){
        return estampaRpository.findAll();
    }

    public Estampa findById(long id){
        return estampaRpository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Peça não encontrada"));

    }

    public Estampa save(EstampaPosRequestBody estampaPosRequestBody) {
        Estampa estampa = Estampa.builder()
        .nome(estampaPosRequestBody.getNome())
        .image(estampaPosRequestBody.getImage())
        .camisas(estampaPosRequestBody.getCamisas())
        .build();
        return estampaRpository.save(estampa);
    }

    public void delete(long id) {
        estampaRpository.delete(findById(id));
    }

    public void replace(EstampaPutRequestBody estampaPutRequestBody) {
        Estampa savedEstampa = findById(estampaPutRequestBody.getId());
        Estampa estampa = Estampa.builder()
        .nome(estampaPutRequestBody.getNome())
        .image(estampaPutRequestBody.getImage())
        .camisas(estampaPutRequestBody.getCamisas())
        .build();
        estampaRpository.save(estampa);
    }
}
