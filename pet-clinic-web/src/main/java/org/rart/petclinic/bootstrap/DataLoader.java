package org.rart.petclinic.bootstrap;


import org.rart.petclinic.models.Owner;
import org.rart.petclinic.models.PetType;
import org.rart.petclinic.models.Vet;
import org.rart.petclinic.services.OwnerService;
import org.rart.petclinic.services.PetTypeService;
import org.rart.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private  final PetTypeService petTypeService;

   @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
       this.ownerService=ownerService;
       this.vetService=vetService;
       this. petTypeService = petTypeService;

    }

    @Override
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

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Hubert");
        owner2.setLastName("Moore");

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Richard");
        owner3.setLastName("Bach");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

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


    }
}
