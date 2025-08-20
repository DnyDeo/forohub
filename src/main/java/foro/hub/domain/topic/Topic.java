
package foro.hub.domain.topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechacreacion;
    private String estatus;
    private String autor;
    private String curso;

    private Boolean activo;


    public Topic(DatosRegistroTopic datosRegistroTopic) {
        this.activo = true;
        this.titulo = datosRegistroTopic.titulo();
        this.mensaje = datosRegistroTopic.mensaje();
        this.fechacreacion =datosRegistroTopic.fechacreacion();
        this.estatus = datosRegistroTopic.estatus();
        this.autor = datosRegistroTopic.autor();
        this.curso = datosRegistroTopic.curso();

    }

    public void actualizarDatos(DatosActualizarTopic datosActualizarTopic) {
        if (datosActualizarTopic.mensaje() != null) {
            this.mensaje = datosActualizarTopic.mensaje();
            this.estatus = datosActualizarTopic.estatus();
        }
    }

    public void desactivarTopic() {
        this.activo = false;
    }
}
