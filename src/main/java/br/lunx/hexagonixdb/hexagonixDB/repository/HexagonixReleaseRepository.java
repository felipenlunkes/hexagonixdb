package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixRelease;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface HexagonixReleaseRepository extends
        Repository<HexagonixRelease, String>,
        PagingAndSortingRepository<HexagonixRelease, String>,
        JpaSpecificationExecutor<HexagonixRelease> {
}
