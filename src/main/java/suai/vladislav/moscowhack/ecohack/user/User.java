package suai.vladislav.moscowhack.ecohack.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.ecohack.hike.HikeInvite;
import suai.vladislav.moscowhack.ecohack.hike.HikeRequest;
import suai.vladislav.moscowhack.ecohack.incident.Incident;
import suai.vladislav.moscowhack.ecohack.incident.IncidentStatus;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    private String lastname;
    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<HikeInvite> hikeInvites;

    @OneToMany(mappedBy = "userCreator")
    private List<HikeInvite> hikeInvitesCreator;

    @OneToMany(mappedBy = "user")
    private List<HikeRequest> hikeRequests;

    @OneToMany(mappedBy = "userCreator")
    private List<HikeRequest> hikeRequestsCreator;

    @JsonBackReference(value = "hikeGroupsCrossUsers")
    @ManyToMany(mappedBy = "usersInHikeGroups")
    private List<HikeGroup> hikeGroupsUsers;

   @JsonManagedReference(value = "HikeGroupCreator")
    @OneToMany(mappedBy = "creatorUser")
    private List<HikeGroup> hikeGroups;

//    @JsonManagedReference(value = "hikeGroupUser")
//    @OneToMany(mappedBy = "user")
//    private List<HikeGroupXUser> hikeGroupXUsers;

    @OneToMany(mappedBy = "user")
    private List<IncidentStatus> incidentStatuses;

    @JsonBackReference(value = "employeeCrossUser")
    @ManyToMany(mappedBy = "user")
    private List<Incident> incidents;

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }
}
