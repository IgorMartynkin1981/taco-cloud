package ru.martynkin.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.martynkin.tacocloud.Taco;


public interface TacoRepository 
         extends CrudRepository<Taco, Long> {

}
