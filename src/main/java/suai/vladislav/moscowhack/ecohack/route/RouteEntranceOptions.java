package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RouteEntranceOptions")
public class RouteEntranceOptions {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "routeEntranceOptions")
    private List<RouteInformation> routeInformation;

    private String title;
    private String content;
}
