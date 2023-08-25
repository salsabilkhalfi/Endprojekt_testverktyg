package com.example.spring_thymeleaf.service;

import com.example.spring_thymeleaf.entities.LapTime;
import com.example.spring_thymeleaf.repo.LapTimeRepo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LapTimeServiceTest {

    LapTimeRepo lapTimeRepo = mock(LapTimeRepo.class);
    List<LapTime> allLapTimes = Arrays.asList(
            new LapTime(1),
            new LapTime(15),
            new LapTime(2),
            new LapTime(16),
            new LapTime(3),
            new LapTime(5.5),
            new LapTime(7),
            new LapTime(13),
            new LapTime(5),
            new LapTime(7)
    );


    @Test
    public void testSortLapTimesInDescendingOrder() {

        when(lapTimeRepo.findAll()).thenReturn(allLapTimes);
        LapTimeService lapTimeService = new LapTimeService(lapTimeRepo);

        System.out.println("All Lap Times:");
        for (LapTime lapTime : allLapTimes) {
            System.out.println(lapTime.getLapTime());
        }

        List<LapTime> topLapTimes = lapTimeService.findLapTimes();

        System.out.println("Top 5 Lap Times:");
        for (LapTime lapTime : topLapTimes) {
            System.out.println(lapTime.getLapTime());
        }

        assertEquals(5, topLapTimes.size());
        for (int i = 1; i < topLapTimes.size(); i++) {
            assertTrue(topLapTimes.get(i - 1).getLapTime() <= topLapTimes.get(i).getLapTime());
        }
    }
}