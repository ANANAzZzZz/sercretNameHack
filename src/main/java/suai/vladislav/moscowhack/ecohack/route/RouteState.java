package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RouteState")
public class RouteState {
    @Id
    @GeneratedValue
    private Integer id;

    private String arrangement;

    private String routeQuality;

    private String waterSources;

    private String mobileConnection;

    @JsonManagedReference(value = "routeState")
    @OneToMany(mappedBy = "routeState")
    private List<Route> routes;
}
