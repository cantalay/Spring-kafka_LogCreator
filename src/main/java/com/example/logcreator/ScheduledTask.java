package com.example.logcreator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.logcreator.service.LogCreatorService;


@Component
public class ScheduledTask {

    @Autowired
    private LogCreatorService logCreatorService;

    @Scheduled(fixedRate = 200)
    public void scheduleTaskWithFixedRate() {
        logCreatorService.writeLogToFile();
    }

}
