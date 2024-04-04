package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixBugfix;
import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixVersion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;

@Testcontainers
@SpringBootTest
public class HexagonixBugfixRepositoryTest {

    @Autowired
    private HexagonixBugfixRepository hexagonixBugfixRepository;

    @Autowired
    private HexagonixVersionRepository hexagonixVersionRepository;

    @Test
    void shouldSaveHexagonixBugfixEntity() {

        var versionEntity = new HexagonixVersion();
        versionEntity.setId("SystemI");
        versionEntity.setAuxId(UUID.randomUUID());
        versionEntity.setDescription("Improvements");
        versionEntity.setCommitted(true);
        versionEntity.setCodename("Raava");
        versionEntity.setReleaseChannel("CURRENT");
        versionEntity.setReleaseTag("rc1");
        versionEntity.setReleaseDate(Instant.now());
        versionEntity.setGitServer("GitHub");

        hexagonixVersionRepository.save(versionEntity);

        var entity = new HexagonixBugfix();
        entity.setId("1.0-bugfix1");
        entity.setAuxId(UUID.randomUUID());
        entity.setCommitted(true);
        entity.setDescription("General protection fault");
        entity.setResolution("Turn off");
        entity.setReleaseDate(Instant.now());
        entity.setVersionIds(Collections.singleton(versionEntity.getId()));

        var saved = hexagonixBugfixRepository.save(entity);

        assertThat(saved.getId()).isEqualTo(entity.getId());
        assertThat(saved.getAuxId()).isEqualTo(entity.getAuxId());
        assertThat(saved.getCommitted()).isEqualTo(entity.getCommitted());
        assertThat(saved.getDescription()).isEqualTo(entity.getDescription());
        assertThat(saved.getResolution()).isEqualTo(entity.getResolution());
        assertThat(saved.getReleaseDate()).isEqualTo(entity.getReleaseDate());
        assertThat(saved.getVersionIds()).isEqualTo(Collections.singleton(versionEntity.getId()));
    }

    @Test
    void shouldFindBugfixById() {

        var instant = Instant.now();

        var entity = new HexagonixBugfix();
        entity.setId("2.0-bugfix2");
        entity.setAuxId(UUID.randomUUID());
        entity.setCommitted(true);
        entity.setDescription("General protection fault");
        entity.setResolution("Turn off");
        entity.setReleaseDate(instant);

        hexagonixBugfixRepository.save(entity);

        var bugFixEntryFoundById = hexagonixBugfixRepository.findById(entity.getId());

        assertTrue(bugFixEntryFoundById.isPresent());

        var bugFixFound = bugFixEntryFoundById.get();

        assertThat(bugFixFound.getId()).isEqualTo(entity.getId());
        assertThat(bugFixFound.getAuxId()).isEqualTo(entity.getAuxId());
        assertThat(bugFixFound.getCommitted()).isEqualTo(entity.getCommitted());
        assertThat(bugFixFound.getDescription()).isEqualTo(entity.getDescription());
        assertThat(bugFixFound.getResolution()).isEqualTo(entity.getResolution());
        assertThat(bugFixFound.getReleaseDate().truncatedTo(ChronoUnit.SECONDS))
                .isEqualTo(entity.getReleaseDate().truncatedTo(ChronoUnit.SECONDS));
    }
}
