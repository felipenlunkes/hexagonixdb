package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixBuild;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface HexagonixBuildRepository extends
        Repository<HexagonixBuild, String>,
        PagingAndSortingRepository<HexagonixBuild, String>,
        JpaSpecificationExecutor<HexagonixBuild> {
}
