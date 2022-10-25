package br.pro.celsofurtado.desafio.controller;

import br.pro.celsofurtado.desafio.model.Video;
import br.pro.celsofurtado.desafio.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public String teste() {
        return "<h2><strong>Desafio Alura - Back-end</strong></h2><hr><br>Bem-vindo a API Videos do Desafio Alura!";
    }

    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoService.findAll();
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> findVideoById(@PathVariable Long id) {
        Optional<Video> optionalVideo = videoService.findVideoById(id);
        if(optionalVideo.isPresent()) {
            return ResponseEntity.ok(optionalVideo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
