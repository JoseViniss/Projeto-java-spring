package raul.dev.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raul.dev.projeto.classe.Camisa;

public interface CamisaRepository extends JpaRepository<Camisa, Long> {

}
