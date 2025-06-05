package com.project.services;

import com.project.dto.MatchCreationDTO;
import com.project.dto.MatchDTO;
import com.project.dto.RankingRowDTO;
import com.project.dto.TeamDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface SoccerService {
    List<RankingRowDTO> getRanking();
    default RankingRowDTO getRankingRow(UUID teamId) {
        return new RankingRowDTO(
                new TeamDTO(teamId, "Marseille"),
                3, 38, 22, 10, 6, 111, 92, 19, 72);
    }
    default List<MatchDTO> getMatches(UUID teamId) {
        return List.of(new MatchDTO(
                        UUID.randomUUID(),
                        new TeamDTO(teamId, "Toulon"),
                        new TeamDTO(UUID.randomUUID(), "Le Havre"),
                        1, 4, LocalDate.of(2048, 8, 3), LocalTime.of(21, 0)
                ), new MatchDTO(
                        UUID.randomUUID(),
                        new TeamDTO(UUID.randomUUID(), "Le Havre"),
                        new TeamDTO(teamId, "Toulon"),
                        3, 1, LocalDate.of(2048, 8, 10), LocalTime.of(21, 0)
                )
        );
    }
    default List<TeamDTO> getTeams() {
        return List.of();
    }

    default void addTeam(TeamDTO teamDTO) {
        throw new UnsupportedOperationException();
    }
    default void addMatch(MatchCreationDTO matchCreationDTO) {
        throw new UnsupportedOperationException();
    }
}