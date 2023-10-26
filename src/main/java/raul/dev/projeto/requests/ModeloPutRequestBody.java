package raul.dev.projeto.requests;

import java.util.List;

import lombok.Data;
import raul.dev.projeto.classe.Camisa;

@Data
public class ModeloPutRequestBody {

    private long id;
    private String nome;
    private String image;
    
}
