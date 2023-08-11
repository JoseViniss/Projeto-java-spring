package raul.dev.projeto.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import raul.dev.projeto.classe.Modelo;
import raul.dev.projeto.repository.ModeloRepository;
import raul.dev.projeto.requests.ModeloPutRequestBody;
import raul.dev.projeto.requests.ModeloPutRequestBody;

@Service
@RequiredArgsConstructor
public class ModeloServices {

    private final ModeloRepository modeloRpository;

    private static List<Modelo> modelos;

    public List<Modelo> listAll(){
        return modeloRpository.findAll();
    }

    public Modelo findById(long id){
        return modeloRpository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Peça não encontrada"));

    }

    public Modelo save(ModeloPutRequestBody modeloPosRequestBody) {
        Modelo modelo = Modelo.builder()
        .nome(modeloPosRequestBody.getNome())
        .image(modeloPosRequestBody.getImage())
        .camisas(modeloPosRequestBody.getCamisas())
        .build();
        return modeloRpository.save(modelo);
    }

    public void delete(long id) {
        modeloRpository.delete(findById(id));
    }

    public void replace(ModeloPutRequestBody modeloPutRequestBody) {
        Modelo savedModelo = findById(modeloPutRequestBody.getId());
        Modelo modelo = Modelo.builder()
        .nome(modeloPutRequestBody.getNome())
        .image(modeloPutRequestBody.getImage())
        .camisas(modeloPutRequestBody.getCamisas())
        .build();
        modeloRpository.save(modelo);
    }
}
