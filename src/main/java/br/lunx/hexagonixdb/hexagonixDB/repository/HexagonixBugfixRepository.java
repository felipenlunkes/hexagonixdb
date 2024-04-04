package br.lunx.hexagonixdb.hexagonixDB.repository;

import br.lunx.hexagonixdb.hexagonixDB.contract.HexagonixBugfix;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HexagonixBugfixRepository extends
        CrudRepository<HexagonixBugfix, String>,
        PagingAndSortingRepository<HexagonixBugfix, String>,
        JpaSpecificationExecutor<HexagonixBugfix> {
}
