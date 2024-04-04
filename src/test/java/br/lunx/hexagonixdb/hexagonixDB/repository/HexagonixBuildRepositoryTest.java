package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixBuild;
import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixVersion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@SpringBootTest
public class HexagonixBuildRepositoryTest {

    @Autowired
    private HexagonixBuildRepository hexagonixBuildRepository;

    @Autowired
    private HexagonixVersionRepository hexagonixVersionRepository;


    @Test
    void shouldSaveBuildEntity() {

        var versionEntity = new HexagonixVersion();
        versionEntity.setId("HexagonixSystemI-040420241535");
        versionEntity.setAuxId(UUID.randomUUID());
        versionEntity.setCodename("Raava");
        versionEntity.setDescription("Next RC version");
        versionEntity.setReleaseChannel("CURRENT");
        versionEntity.setGitServer("GitHub");
        versionEntity.setReleaseTag("SystemI-RC1");
        versionEntity.setReleaseDate(Instant.now());

        hexagonixVersionRepository.save(versionEntity);

        var entity = new HexagonixBuild();
        entity.setId(UUID.randomUUID().toString());
        entity.setAuxId(UUID.randomUUID());
        entity.setDescription("Friday build");
        entity.setReleaseChannel("RELEASE");
        entity.setReleaseTag("revision");
        entity.setGitServer("GitHub");
        entity.setCommitted(true);
        entity.setReleaseDate(Instant.now());
        entity.setVersionIds(Collections.singleton(versionEntity.getId()));

        var savedEntity = hexagonixBuildRepository.save(entity);

        assertThat(savedEntity.getId()).isEqualTo(entity.getId());
        assertThat(savedEntity.getAuxId()).isEqualTo(entity.getAuxId());
        assertThat(savedEntity.getCommitted()).isEqualTo(entity.getCommitted());
        assertThat(savedEntity.getDescription()).isEqualTo(entity.getDescription());
        assertThat(savedEntity.getReleaseDate()).isEqualTo(entity.getReleaseDate());
        assertThat(savedEntity.getVersionIds()).isEqualTo(Collections.singleton(versionEntity.getId()));
    }

}
