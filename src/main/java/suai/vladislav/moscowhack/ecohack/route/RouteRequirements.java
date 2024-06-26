package suai.vladislav.moscowhack.ecohack.route;

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
@Table(name = "RouteRequirements")
public class RouteRequirements {
    @Id
    @GeneratedValue
    private Integer id;

    private String securityRules;

    private String residenceRules;

    @JsonManagedReference(value = "routeRequirements")
    @OneToMany(mappedBy = "routeRequirements")
    private List<Route> routes;
}
