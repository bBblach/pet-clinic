package org.rart.petclinic.services.map;

import org.apache.log4j.Logger;
import org.rart.petclinic.models.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity,ID extends  Long> {

    final static Logger logger = Logger.getLogger(AbstractMapService.class);
    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return  new HashSet<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if (object !=null){
            if (object.getId() == null){ // dlaczego tu musi być null a nie może być 0 ? Chyba dlatego że typ id to Long a więc obiekt a więc domyślenie jest null
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
         map.remove(id);
    }
    void delete(T object){

        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


    private Long getNextId(){

        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }

    int size(){
        int size =  map.size();
        return size;
    }

}
