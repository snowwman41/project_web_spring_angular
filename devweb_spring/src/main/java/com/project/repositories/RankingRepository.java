package com.project.repositories;
import com.project.entities.RankingRow;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RankingRepository extends JpaRepository<RankingRow, UUID> {

    @EntityGraph(attributePaths = {"team"})
    @NonNull Optional<RankingRow> findById(@NonNull UUID teamId);

    List<RankingRow> findAllByOrderByPointsDescGoalDifferenceDescGoalForCountDesc();

    @EntityGraph(attributePaths = {"team"})
    List<RankingRow> findAllByOrderByRankAsc();
}