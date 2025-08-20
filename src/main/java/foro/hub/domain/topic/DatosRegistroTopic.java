package foro.hub.domain.topic;

import jakarta.validation.constraints.NotBlank;


public record DatosRegistroTopic(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String fechacreacion,
        @NotBlank
        String estatus,
        @NotBlank
        String autor,
        @NotBlank
        String curso
        ) {
}
