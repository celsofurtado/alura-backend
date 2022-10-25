package br.pro.celsofurtado.desafio.controller;

import br.pro.celsofurtado.desafio.model.Video;
import br.pro.celsofurtado.desafio.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
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

        if (optionalVideo.isPresent()) {
            return ResponseEntity.ok(optionalVideo.get());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/videos")
    public ResponseEntity<Video> save(@RequestBody @Valid Video video, UriComponentsBuilder uriComponentsBuilder) {

        Video newVideo = videoService.save(video);
        URI uri = uriComponentsBuilder.path("/api/videos/{id}").buildAndExpand(newVideo.getId()).toUri();

        return ResponseEntity.created(uri).body(newVideo);

    }

    @DeleteMapping("/videos/{id}")
    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        Optional<Video> video = videoService.findVideoById(id);

        if (video.isPresent()) {
            videoService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }

}
