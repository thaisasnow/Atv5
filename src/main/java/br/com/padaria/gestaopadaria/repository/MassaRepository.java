package br.com.padaria.gestaopadaria.repository;

import br.com.tudocelular.gestaolojacelular.domain.model.Celular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository("massaRepository")
public interface MassaRepository extends JpaRepository<Massa, UUID> {

    @Modifying
    @Transactional
    @Query(value = "update Massa c set c.preco = :preco where c.massaId = :id")
    void updateByPreco(UUID id, float preco);

    Massa findByPreco(float preco);
}
