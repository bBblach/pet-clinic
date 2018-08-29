package org.rart.petclinic.bootstrap;


import org.rart.petclinic.models.*;
import org.rart.petclinic.services.OwnerService;
import org.rart.petclinic.services.PetTypeService;
import org.rart.petclinic.services.SpecialtyService;
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
    private  final SpecialtyService specialtyService;

   @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
       this.ownerService=ownerService;
       this.vetService=vetService;
       this.petTypeService = petTypeService;
       this.specialtyService = specialtyService;
     }

    @Override
    public void run(String... args) throws Exception {

       int count  =petTypeService.findAll().size();
       if(count ==0){
           System.out.println("DATA IS LOADING");
           loadData();
       }else {
           System.out.println("DATA IS ALREADY LOADED");
       }
    }

    private void loadData() {
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

        /* ************  SPECIATLIES  ******************/
        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);


        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        /* ************  VETS *          *****************/
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);


        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }


}
