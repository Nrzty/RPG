package com.rpg.rpg_api.service.batalha;

import com.rpg.rpg_api.exception.batalha.PersonagensMortosException;
import com.rpg.rpg_api.model.Batalha;
import com.rpg.rpg_api.model.Personagem;
import com.rpg.rpg_api.model.enums.Status;
import com.rpg.rpg_api.repository.batalha.BatalhaRepository;
import com.rpg.rpg_api.repository.personagem.PersonagemRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BatalhaServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(
        BatalhaServiceImpl.class
    );

    private final BatalhaRepository batalhaRepository;
    private final PersonagemRepository personagemRepository;

    public BatalhaServiceImpl(
        BatalhaRepository batalhaRepository,
        PersonagemRepository personagemRepository
    ) {
        this.batalhaRepository = batalhaRepository;
        this.personagemRepository = personagemRepository;
    }

    public Batalha simular(Long atacanteId, Long defensorId) {
        LocalDateTime inicioBatalha = LocalDateTime.now();
        List<String> logsDaBatalha = new ArrayList<>();

        Personagem atacante = buscarPersonagemPorId(atacanteId, "atacante");
        Personagem defensor = buscarPersonagemPorId(defensorId, "defensor");

        if (verificarSeHaMortos(List.of(atacante, defensor))) {
            throw new PersonagensMortosException();
        }

        Personagem primeiro = calcularVelocidade(atacante, defensor);
        Personagem segundo = primeiro != defensor ? defensor : atacante;

        int turnos = 0;

        while (
            primeiro.getStatus() == Status.VIVO &&
            segundo.getStatus() == Status.VIVO
        ) {
            int danoDoAtacante = executarTurno(primeiro, segundo);
            int danoDoDefensor = executarTurno(segundo, primeiro);
            turnos++;
        }

        Personagem vencedor =
            primeiro.getStatus() == Status.MORTO ? segundo : primeiro;
        Personagem perdedor =
            segundo.getStatus() == Status.MORTO ? primeiro : segundo;

        Batalha batalha = new Batalha.Builder()
            .atacante(primeiro)
            .defensor(segundo)
            .vencedor(vencedor)
            .perdedor(perdedor)
            .turnosSimulados(turnos)
            .logDaBatalha(logsDaBatalha)
            .dataHora(inicioBatalha)
            .build();

        return batalhaRepository.salvar(batalha);
    }

    private Personagem buscarPersonagemPorId(Long id, String papel) {
        return personagemRepository
            .buscarPorId(id)
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "O " + papel + " não pode ser encontrado"
                )
            );
    }

    private boolean verificarSeHaMortos(List<Personagem> personagens) {
        return personagens
            .stream()
            .anyMatch(personagem -> personagem.getStatus() != Status.VIVO);
    }

    private int calcularDano(Personagem atacante, Personagem defensor) {
        return Math.max(0, atacante.getAtaque() - defensor.getDefesa());
    }

    private int executarTurno(Personagem atacante, Personagem defensor) {
        int dano = calcularDano(atacante, defensor);
        defensor.receberDano(dano);
        return dano;
    }

    private Personagem calcularVelocidade(
        Personagem atacante,
        Personagem defensor
    ) {
        return atacante.getVelocidade() > defensor.getVelocidade()
            ? atacante
            : defensor;
    }
}
