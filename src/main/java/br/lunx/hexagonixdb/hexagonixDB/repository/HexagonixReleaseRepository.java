package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixRelease;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HexagonixReleaseRepository extends
        CrudRepository<HexagonixRelease, String>,
        PagingAndSortingRepository<HexagonixRelease, String>,
        JpaSpecificationExecutor<HexagonixRelease> {
}
