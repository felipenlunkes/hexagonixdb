package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixBugfix;
import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixVersion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
@SpringBootTest
public class HexagonixVersionRepositoryTest {

    @Autowired
    private HexagonixBugfixRepository hexagonixBugfixRepository;

    @Autowired
    private HexagonixVersionRepository hexagonixVersionRepository;

    @Test
    void shouldSaveVersion() {

        var bugFixEntity = new HexagonixBugfix();
        bugFixEntity.setId("040420230315");
        bugFixEntity.setDescription("Memory leak");
        bugFixEntity.setResolution("VM correction");
        bugFixEntity.setCommitted(false);
        bugFixEntity.setReleaseDate(Instant.now());

        hexagonixBugfixRepository.save(bugFixEntity);

        var entity = new HexagonixVersion();
        entity.setId("HexagonixSystemI-040420240313");
        entity.setCodename("Raava");
        entity.setDescription("Next RC version");
        entity.setReleaseChannel("CURRENT");
        entity.setGitServer("GitHub");
        entity.setReleaseTag("SystemI-RC1");
        entity.setReleaseDate(Instant.now());
        entity.setFixIds(Collections.singleton(bugFixEntity.getId()));

        var savedVersion = hexagonixVersionRepository.save(entity);

        assertThat(savedVersion.getId()).isEqualTo(entity.getId());
        assertThat(savedVersion.getCommitted()).isEqualTo(entity.getCommitted());
        assertThat(savedVersion.getDescription()).isEqualTo(entity.getDescription());
        assertThat(savedVersion.getReleaseDate()).isEqualTo(entity.getReleaseDate());
        assertThat(savedVersion.getFixIds()).isEqualTo(Collections.singleton(bugFixEntity.getId()));
    }



}
