package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixBuild;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HexagonixBuildRepository extends
        CrudRepository<HexagonixBuild, String>,
        PagingAndSortingRepository<HexagonixBuild, String>,
        JpaSpecificationExecutor<HexagonixBuild> {
}
