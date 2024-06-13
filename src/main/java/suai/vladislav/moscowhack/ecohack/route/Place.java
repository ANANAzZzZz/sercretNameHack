package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.ParkPhoto;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Place")
public class Place {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonManagedReference(value = "placeS")
    @OneToMany(mappedBy = "placeS")
    private List<RouteLength> routeLengthS;

    @JsonManagedReference(value = "placeE")
    @OneToMany(mappedBy = "placeE")
    private List<RouteLength> routeLengthE;

    private String name;
}
