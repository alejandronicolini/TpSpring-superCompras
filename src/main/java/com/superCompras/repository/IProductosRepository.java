package com.superCompras.repository;

import com.superCompras.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<Producto, Long> {  //  <objeto a persistir, tipo de dato>


}
