package raul.dev.projeto.requests;

import java.util.List;

import lombok.Data;
import raul.dev.projeto.classe.Camisa;

@Data
public class ModeloPosRequestBody {
    
    private String nome;
    private String image;
    private List<Camisa> camisas;

}
