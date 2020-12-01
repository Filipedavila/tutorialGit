package pt.iade.aulas.tutorialgit.controllers;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pt.iade.aulas.tutorialgit.models.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    @RestController
    @RequestMapping(path="/api/statistics/")


    public class SatisticsController {


        private Logger logger = LoggerFactory.getLogger(pt.iade.aulas.tutorialgit.controllers.MaterialController.class);
        private static final int NHISTSLOTS = 5;

        @GetMapping(path = "/histogram//{type}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
        public HistogramSlot[] getHistogramList(@PathVariable("type") String type,
                                               @PathVariable("number") int number) {
            logger.info("Getting Histogram info");
            Statistical stats;
            if(type.equalsIgnoreCase("student"))
                stats = StudentRepository.getStudent(number);
            else stats = UnitRepository.getUnit(number);
            return stats.getHistogram(NHISTSLOTS);
        }
        @GetMapping(path = "/{type}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
        public StatisticResult getStats(@PathVariable("type") String type,
                                               @PathVariable("number") int number) {
            logger.info("Getting Histogram info");
            StatisticResult stats;
            if(type.equalsIgnoreCase("student")) {
                Student std = StudentRepository.getStudent(number);
                stats = new StatisticResult(std.getMax(), std.getMin(),std.getAverage(),std.getRange());
            } else{
                Unit unit =  UnitRepository.getUnit(number);
                stats = new StatisticResult(unit.getMax(), unit.getMin(),unit.getAverage(),unit.getRange());
            }
            return stats;
        }
}
