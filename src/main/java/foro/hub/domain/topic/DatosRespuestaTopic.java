package foro.hub.domain.topic;

public record DatosRespuestaTopic(Long id,
                                  String titulo,
                                  String mensaje,
                                  String fechacreacion,
                                  String estatus,
                                  String autor,
                                  String curso) {
}
