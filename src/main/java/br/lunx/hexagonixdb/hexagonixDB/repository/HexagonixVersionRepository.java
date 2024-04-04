package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixVersion;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HexagonixVersionRepository extends
        CrudRepository<HexagonixVersion, String>,
        PagingAndSortingRepository<HexagonixVersion, String>,
        JpaSpecificationExecutor<HexagonixVersion> {
}
