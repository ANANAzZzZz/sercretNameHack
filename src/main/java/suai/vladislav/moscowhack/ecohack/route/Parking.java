package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Parking")
public class Parking {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private String title;

    private float latitude;

    private float longitude;

    @JsonBackReference(value = "Parking")
    @ManyToOne
    @JoinColumn(name = "routeDescriptionId")
    private RouteDescription routeDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "parking")
    private List<ParkingPhoto> parkingPhotos;
}
