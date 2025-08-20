package foro.hub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopic(@NotNull Long id, String mensaje, String estatus) {
}
