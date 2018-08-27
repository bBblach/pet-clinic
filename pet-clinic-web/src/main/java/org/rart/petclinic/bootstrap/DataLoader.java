package org.rart.petclinic.bootstrap;


import org.rart.petclinic.models.Owner;
import org.rart.petclinic.models.Vet;
import org.rart.petclinic.services.OwnerService;
import org.rart.petclinic.services.VetService;
import org.rart.petclinic.services.map.OwnerServiceMap;
import org.rart.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;



    public DataLoader() {
        ownerService= new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Artur");
        owner1.setLastName("Douglas");

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Hubert");
        owner1.setLastName("Moore");

        Owner owner3 = new Owner();
        owner1.setId(3L);
        owner1.setFirstName("Richard");
        owner1.setLastName("Bach");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);
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
