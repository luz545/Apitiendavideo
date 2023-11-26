package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apitiendavideo.apitiendavideo.entidades.Titulo;

public interface TituloRepositorio extends JpaRepository<Titulo, Long>{
     @Query("SELECT t FROM Titulo t WHERE t.nombre like '%' || ?1 || '%'")
    List<Titulo> buscar(String nombre);
}
