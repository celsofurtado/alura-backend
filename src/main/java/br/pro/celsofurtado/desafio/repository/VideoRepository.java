package br.pro.celsofurtado.desafio.repository;

import br.pro.celsofurtado.desafio.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
