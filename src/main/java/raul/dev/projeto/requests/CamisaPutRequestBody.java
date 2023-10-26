package raul.dev.projeto.requests;

//import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import raul.dev.projeto.classe.Estampa;
import raul.dev.projeto.classe.Modelo;

@Data
public class CamisaPutRequestBody {
    private Long id;
    private Modelo modelo;
    private Estampa estampa;
    private Double preco_uni;
    private String tamanho;
    private String image;
}
