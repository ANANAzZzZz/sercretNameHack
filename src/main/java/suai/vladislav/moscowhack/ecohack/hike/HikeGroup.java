package suai.vladislav.moscowhack.ecohack.hike;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.ecohack.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@Entity
@Table(name = "HikeGroup")
public class HikeGroup {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer membersCount;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isPrivate;
    private String password;

//    @JsonManagedReference(value = "hikeGroup")
//    @OneToMany(mappedBy = "hikeGroup")
//    private List<HikeGroupXUser> hikeGroupXUsers;

    @JsonManagedReference(value = "hikeGroupsCrossUsers")
    @ManyToMany
    @JoinTable(
            name = "HikeGroupCrossUser",
            joinColumns = @JoinColumn(name = "HikeGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "User_id")
    )
    private List<User> usersInHikeGroups;

    @JsonManagedReference
    @OneToMany(mappedBy = "hikeGroup")
    private List<HikeInvite> hikeInvites;

    @JsonManagedReference
    @OneToMany(mappedBy = "hikeGroup")
    private List<HikeRequest> hikeRequests;

    @JsonBackReference(value = "HikeGroupCreator")
    @ManyToOne
    @JoinColumn(name = "creatorId")
    private User creatorUser;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;

    public HikeGroup(Integer membersCount, LocalDateTime startTime,LocalDateTime endTime, boolean aPrivate, String password, Optional<User> byId, Optional<Route> byId1) {
        this.membersCount = membersCount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isPrivate = aPrivate;
        this.password = password;
        this.creatorUser = byId.orElse(null);
        this.route = byId1.orElse(null);
    }

    public List<User> getUsersInHikeGroups() {
        return usersInHikeGroups;
    }

    public List<HikeInvite> getHikeInvites() {
        return hikeInvites;
    }

    public List<HikeRequest> getHikeRequests() {
        return hikeRequests;
    }

    public User getCreatorUser() {
        return creatorUser;
    }

    public Route getRoute() {
        return route;
    }
}
