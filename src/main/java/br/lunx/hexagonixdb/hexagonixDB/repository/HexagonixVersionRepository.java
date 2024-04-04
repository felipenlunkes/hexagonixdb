package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixVersion;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface HexagonixVersionRepository extends
        Repository<HexagonixVersion, String>,
        PagingAndSortingRepository<HexagonixVersion, String>,
        JpaSpecificationExecutor<HexagonixVersion> {
}
