/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Dono;
import Model.Pet;
import java.io.*;
import java.util.ArrayList;

public class PetDados implements Serializable{
    private static ArrayList<Pet> pets = new ArrayList<>();
    

    public void cadastrarPet(Pet pet) {
        pets.add(pet);

        // Serializar a lista de usuários em um arquivo
        try{
            FileOutputStream outFile = new FileOutputStream("pets_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(PetDados.pets);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarPets() {
        try {
            FileInputStream inFile = new FileInputStream("pets_lista.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
            ArrayList<Pet> petsCarregados = (ArrayList<Pet>) objectInputStream.readObject();
            objectInputStream.close();
            //pets.clear();
            pets.addAll(petsCarregados);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Pet> obterPetsDoDono(Dono dono) {
        ArrayList<Pet> petsDoDono = new ArrayList<>();

        // Percorre todos os pets e adiciona à lista apenas os que pertencem ao dono especificado
        for (Pet pet : pets) {
            if (pet.getIdDono().equals(dono)) {
                petsDoDono.add(pet);
            }
        }

        return petsDoDono;
    }
    
}
