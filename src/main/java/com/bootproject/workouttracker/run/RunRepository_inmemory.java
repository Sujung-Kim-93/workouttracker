package com.bootproject.workouttracker.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository_inmemory {
    private List<Run> runs = new ArrayList<>();

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 3,
                Location.INDOOR));
        runs.add(new Run(2, "Second run", LocalDateTime.now(), LocalDateTime.now().plus(45, ChronoUnit.MINUTES), 4,
                Location.OUTDOOR));
    }

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }
}
