package br.com.padaria.gestaopadaria.service;

import br.com.tudocelular.gestaolojacelular.domain.model.Celular;
import br.com.tudocelular.gestaolojacelular.repository.CelularRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MassaService {
    private final MassaRepository massaRepository;
    public MassaService(MassaRepository massaRepository) {
        this.massaRepository = massaRepository;
    }

    public Massa save(Massa massa){
        return massaRepository.save(massa);
    }

    public List<Massa> findAll(){
        return massaRepository.findAll();
    }

    public Massa findById(UUID id){
        return massaRepository.findById(id).orElse(new Massa());
    }

    public void deleteById(UUID id){
        massaRepository.deleteById(id);
    }

    public void update(UUID id, float preco) {
        massaRepository.updateByPreco(id, preco);
    }

    public Massa findByPreco(float preco) {
        return massaRepository.findByPreco(preco);
    }
}
