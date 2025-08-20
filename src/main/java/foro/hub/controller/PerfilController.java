package foro.hub.controller;

import foro.hub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class PerfilController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopic> registrarTopic(@RequestBody @Valid DatosRegistroTopic datosRegistroTopic,
                                                               UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicRepository.save(new Topic(datosRegistroTopic));
        DatosRespuestaTopic datosRespuestaTopic = new DatosRespuestaTopic(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechacreacion(), topic.getEstatus(),
                topic.getAutor(),topic.getCurso());

        URI url = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopic);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopic>> listadoTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicRepository.findByActivoTrue(paginacion).map(DatosListadoTopic::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopic(@RequestBody @Valid DatosActualizarTopic datosActualizarTopic) {
        Topic topic = topicRepository.getReferenceById(datosActualizarTopic.id());
        topic.actualizarDatos(datosActualizarTopic);
        return ResponseEntity.ok(new DatosRespuestaTopic(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechacreacion(), topic.getEstatus(),
                topic.getAutor(),topic.getCurso()));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.desactivarTopic();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopic> retornaDatosTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        var datosTopic = new DatosRespuestaTopic(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechacreacion(), topic.getEstatus(),
                topic.getAutor(),topic.getCurso());
        return ResponseEntity.ok(datosTopic);
    }

}
