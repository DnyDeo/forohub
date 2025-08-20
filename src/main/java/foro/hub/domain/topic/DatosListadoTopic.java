package foro.hub.domain.topic;

public record DatosListadoTopic(Long id, String titulo,
                                String mensaje,
                                String fechacreacion,
                                String estatus,
                                String autor,
                                String curso) {

    public DatosListadoTopic(Topic topic) {
        this(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechacreacion(), topic.getEstatus(), topic.getAutor(), topic.getCurso());
    }
}


