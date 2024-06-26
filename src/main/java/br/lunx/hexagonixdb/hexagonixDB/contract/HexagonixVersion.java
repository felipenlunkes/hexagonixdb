package br.lunx.hexagonixdb.hexagonixDB.contract;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Table(name = "hexagonix_version")
@Entity(name = "HexagonixVersion")
public class HexagonixVersion {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "aux_id")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID auxId;

    @Column(name = "description")
    private String description;

    @Column(name = "codename")
    private String codename;

    @Column(name = "release_channel")
    private String releaseChannel;

    @Column(name = "release_tag")
    private String releaseTag;

    @Column(name = "git_server")
    private String gitServer;

    @Column(name = "committed")
    private Boolean committed;

    @Column(name = "release_date")
    private Instant releaseDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "version_has_fix", joinColumns = @JoinColumn(name = "version_id"))
    @Column(name = "fix_id")
    private Set<String> fixIds;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "version_has_build", joinColumns = @JoinColumn(name = "version_id"))
    @Column(name = "build_id")
    private Set<String> buildIds;

}
