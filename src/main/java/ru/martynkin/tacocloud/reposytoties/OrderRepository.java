package ru.martynkin.tacocloud.reposytoties;

import ru.martynkin.tacocloud.TacoOrder;

import java.util.Optional;

public interface OrderRepository {

  TacoOrder save(TacoOrder order);

  Optional<TacoOrder> findById(Long id);

}
