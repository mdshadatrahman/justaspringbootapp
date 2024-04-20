package com.shadatrahman.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findALl();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isPresent()) {
            return run.get();
        } else {
            throw new RunNotFoundException();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Run create(@RequestBody Run run) {
        return runRepository.create(run);
    }

    @PutMapping("/{id}")
    Run update(@PathVariable Integer id, @RequestBody Run run) {
        Optional<Run> updatedRun = runRepository.update(id, run);
        if (updatedRun.isPresent()) {
            return updatedRun.get();
        }
        throw new RunNotFoundException();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }
}
