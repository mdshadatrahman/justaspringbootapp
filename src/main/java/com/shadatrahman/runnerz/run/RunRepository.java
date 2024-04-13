package com.shadatrahman.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<Run>();

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.INDOOR));
    }

    List<Run> findALl() {
        return runs;
    }

    Optional<Run> findById(int id) {
        return runs.stream().
                filter(run -> run.id() == id)
                .findFirst();
    }

    Run create(Run run) {
        runs.add(run);
        return run;
    }

    Optional<Run> update(int id, Run run) {
        Optional<Run> found = findById(id);
        found.ifPresent(value -> runs.set(runs.indexOf(value), run));
        return found;
    }

    void delete(int id) {
        runs.removeIf(run -> run.id() == id);
    }


}
