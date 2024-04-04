package br.lunx.hexagonixdb.hexagonixDB.contract;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "hexagonix_bugfix")
@Entity(name = "HexagonixBugfix")
public class HexagonixBugfix {

    @Id
    @Column(name = "fix_id")
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "committed")
    private Boolean committed;

    @Column(name = "release_date")
    private Instant releaseDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "version_has_fix", joinColumns = @JoinColumn(name = "fix_id"))
    @Column(name = "version_id")
    private Set<String> versionIds;

}
