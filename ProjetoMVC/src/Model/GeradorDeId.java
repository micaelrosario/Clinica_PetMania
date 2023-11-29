package Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeradorDeId {

    private Set<Integer> idsExistentes;
    private Random random;

    public GeradorDeId() {
        idsExistentes = new HashSet<>();
        random = new Random();
    }

    public int gerarNovoId() {
        int novoId;
        do {
            novoId = random.nextInt(1000);  // Altere conforme necessário para o intervalo desejado
        } while (idsExistentes.contains(novoId));

        idsExistentes.add(novoId);
        return novoId;
    }
}
