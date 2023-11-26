package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.entidades.Region;

@Repository
public interface RegionRepositorio extends JpaRepository<Region, Long> {

    @Query("SELECT r FROM Region r WHERE r.nombre like '%' || ?1 || '%'")
    List<Region> buscar(String nombre);

}