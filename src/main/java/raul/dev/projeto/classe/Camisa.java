package raul.dev.projeto.classe;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "camisa")
@Getter
@Setter

public class Camisa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double preco_uni;
    private String tamanho;

    @ManyToMany
    @JoinTable(
        name = "Tabela Auxiliar",
        joinColumns = {@JoinColumn(name = "id_camisa", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "id_estampa", referencedColumnName = "id")}
    )
    private List<Estampa> estampa;

    @ManyToMany
    @JoinTable(
        name = "Tabela Auxiliar",
        joinColumns = {@JoinColumn(name = "id_camisa", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "id_estampa", referencedColumnName = "id")}
    )
    private List<Modelo> modelo;


}
