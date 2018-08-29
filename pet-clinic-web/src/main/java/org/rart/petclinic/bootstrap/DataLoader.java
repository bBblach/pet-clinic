package org.rart.petclinic.bootstrap;


import org.rart.petclinic.models.Owner;
import org.rart.petclinic.models.Pet;
import org.rart.petclinic.models.PetType;
import org.rart.petclinic.models.Vet;
import org.rart.petclinic.services.OwnerService;
import org.rart.petclinic.services.PetTypeService;
import org.rart.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private  final PetTypeService petTypeService;

   @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
       this.ownerService=ownerService;
       this.vetService=vetService;
       this.petTypeService = petTypeService;


    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAdress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelphone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAdress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelphone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }

   /* @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);



        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Artur");
        owner1.setLastName("Douglas");
        owner1.setCity("New York");
        owner1.setAdress("Central Perk");
        owner1.setTelphone("0700");

        Pet artursPet = new Pet();
        artursPet.setPetType(savedDogType);
        artursPet.setOwner(owner1);
        artursPet.setBirthDate(LocalDate.now());
        artursPet.setName("Rosco");
        owner1.getPets().add(artursPet);


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Hubert");
        owner2.setLastName("Moore");
        owner2.setCity("New York");
        owner2.setAdress("Central Perk");
        owner2.setTelphone("0700");

        Pet hubertPet = new Pet();
        hubertPet.setPetType(savedCatType);
        hubertPet.setOwner(owner2);
        hubertPet.setBirthDate(LocalDate.now());
        hubertPet.setName("Fiona");
        owner2.getPets().add(hubertPet);

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("No of owners = " + ownerService.size());
        System.out.println("*************** Loaded Owners ************************* ");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Marian");
        vet1.setLastName("Paździoch");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zbigniew");
        vet2.setLastName("Boczek");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("*************** Loaded Vets ************************* ");


    }*/
}
