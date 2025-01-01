package com.kickoff.batch.config.feign.api.temp;

public record Score(
        String winner,
        String duration,
        FullTime fullTime,
        HalfTime halfTime
) {
    public record FullTime(String home, String away) {}
    public record HalfTime(int home, int away) {}
}
