package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "RouteVisitingConditionsXRouteInformation")
public class RouteVisitingConditionsXRouteInformation {
    //
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeVisitingConditionsId")
    private RouteVisitingConditions routeVisitingConditions;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeInformationId")
    private RouteInformation routeInformation;
}
