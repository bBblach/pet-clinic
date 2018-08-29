package org.rart.petclinic.services.map;


import org.rart.petclinic.models.Owner;
import org.rart.petclinic.models.Pet;
import org.rart.petclinic.services.OwnerService;
import org.rart.petclinic.services.PetService;
import org.rart.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

/*
 * Mimicing what jpa is doing in the background
 *
 * */
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {



    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        /*chyba logika poniższych operacji polega na tym że jeżeli do np użytkownika jest przypisane jakieś zwierze ale
        * to zwierze nie ma id to nie zostało zapisane
        * Bo dopiero wywołanie metodyt T save(T object) nadaje obiektowi ID chyba że mty zrobimy to ręcznie */
        if(object !=null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() !=null){
                        if (pet.getPetType().getId() == null){  // if if is null so that pet type has not been saved to our map yet
                            pet.setPetType(petTypeService.save(pet.getPetType())); // kompletnie tego nie rozumiem
                            // bierzemy pet type któ©e jest przypisane ale nie zapisane i je zapisujemy
                        }
                    }else{
                        throw  new RuntimeException("Pet type is required");
                    }
                    if (pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else {
            return null;
        }


    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public int size() {
       return super.size();
    }
}
