<<<<<<< HEAD
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
package Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeradorDeId {
<<<<<<< HEAD

=======
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
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
<<<<<<< HEAD
=======

    public static void main(String[] args) {
        GeradorDeId gerador = new GeradorDeId();

        // Exemplo de uso
        for (int i = 0; i < 10; i++) {
            int novoId = gerador.gerarNovoId();
            System.out.println("Novo ID gerado: " + novoId);
        }
    }
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
}
