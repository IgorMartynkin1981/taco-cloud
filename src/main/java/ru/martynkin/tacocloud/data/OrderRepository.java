package ru.martynkin.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.martynkin.tacocloud.TacoOrder;

public interface OrderRepository 
         extends CrudRepository<TacoOrder, Long> {

}
