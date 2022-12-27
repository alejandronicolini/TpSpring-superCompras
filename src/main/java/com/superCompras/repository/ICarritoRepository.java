package com.superCompras.repository;

import com.superCompras.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Long> {  //  <objeto a persistir, tipo de dato>


}
