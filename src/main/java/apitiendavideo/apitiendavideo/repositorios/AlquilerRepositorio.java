package apitiendavideo.apitiendavideo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import apitiendavideo.apitiendavideo.entidades.Alquiler;

public interface AlquilerRepositorio extends JpaRepository<Alquiler, Long>{
    
}
