package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Gps")
public class Gps {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer ord;

    @JsonBackReference(value = "gpsDesc")
    @ManyToOne
    @JoinColumn(name = "routeDescriptionId")
    private RouteDescription routeDescription;

    @JsonManagedReference(value = "gps")
    @OneToMany(mappedBy = "gps")
    private List<GpsPoint> gpsPoints;
}
