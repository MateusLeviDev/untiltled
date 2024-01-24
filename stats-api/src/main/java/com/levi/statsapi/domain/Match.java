package com.levi.statsapi.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RestController
@Entity(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "score_team_one")
    private Integer scoreTeamOne;

    @Column(name = "score_team_two")
    private Integer scoreTeamTwo;


    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_one_id")
    private Team teamOne;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_two_id")
    private Team teamTwo;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_supported_id")
    private Team supportedTeam;

}
