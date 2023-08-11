package raul.dev.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raul.dev.projeto.classe.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
