package com.bootproject.workouttracker.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        Integer id,
        @NotEmpty String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive Integer miles,
        Location location) {
    public Run {
        // custom input validation
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("Completed time must be after started time");
        }
    }
}
