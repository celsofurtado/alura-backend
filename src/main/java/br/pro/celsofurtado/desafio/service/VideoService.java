package br.pro.celsofurtado.desafio.service;

import br.pro.celsofurtado.desafio.model.Video;
import br.pro.celsofurtado.desafio.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Optional<Video> findVideoById(Long id) {
        return videoRepository.findById(id);
    }

}
