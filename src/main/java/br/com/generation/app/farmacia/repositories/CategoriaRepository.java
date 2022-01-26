

package br.com.generation.app.farmacia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.app.farmacia.models.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findAllByCategoriaContainingIgnoreCase (String Categoria);
}

