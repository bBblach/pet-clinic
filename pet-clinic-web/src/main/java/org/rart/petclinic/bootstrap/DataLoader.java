package org.rart.petclinic.bootstrap;


import org.rart.petclinic.models.Owner;
import org.rart.petclinic.models.Vet;
import org.rart.petclinic.services.OwnerService;
import org.rart.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


   @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
       this.ownerService=ownerService;
       this.vetService=vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
        vet1.setId(2L);
        vet1.setFirstName("Zbigniew");
        vet1.setLastName("Boczek");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("*************** Loaded Vets ************************* ");


    }
}
