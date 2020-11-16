package pt.iade.aulas.tutorialgit.controllers;

import com.sun.jna.platform.win32.ShTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.aulas.tutorialgit.models.*;
import pt.iade.aulas.tutorialgit.models.exeptions.AlreadyExistsException;
import pt.iade.aulas.tutorialgit.models.exeptions.NotFoundException;

import java.util.List;

    @RestController
    @RequestMapping(path="/api/java/units")
    public class UnitController {

        private Logger logger = LoggerFactory.getLogger(pt.iade.aulas.tutorialgit.controllers.UnitController.class);


        @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Unit> getUnits()  {
            logger.info("Returning all Units");
          return UnitRepository.getUnits();
        }

        @GetMapping(path = "{unitId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Unit getUnit( @PathVariable("unitId") int unitId)
                throws NotFoundException {
            logger.info("Sending unit with id " + unitId      );
            Unit unit = UnitRepository.getUnit(unitId);
            if (unit != null) {
                return unit;
            }
                else throw new NotFoundException("Unit " , "Does not exist -", "with id" + + unitId);

        }

        @PostMapping (path = "/create/{unitId}",consumes={MediaType.APPLICATION_JSON_VALUE},  produces = {MediaType.APPLICATION_JSON_VALUE})
        public Unit createUnit( @RequestBody Unit unit,@PathVariable int unitId)     throws AlreadyExistsException {
            logger.info("Create unit " + unit +
                    " with id number " + unitId);
            Unit unitTest = UnitRepository.getUnit(unitId);
            if (unitTest == null) {
                UnitRepository.createUnit(unit);
                return unit;
            } else {
                throw new AlreadyExistsException("Error ", "" + unitId, "Unit already Exists");
            }
        }





        @DeleteMapping (path = "/delete/{id}")
        public Unit deleteUnit(@PathVariable("id") int number, @PathVariable int unitId) throws NotFoundException {
            logger.info("Deleting Unit with idn " +
                    number + " in unit with id " + unitId);
            Unit unitTest = UnitRepository.getUnit(unitId);

            if (unitTest != null) {
                UnitRepository.removeStudent(unitId);

            } else{ throw new NotFoundException("" + unitId, "Unit", "id");

        }
            return  unitTest;
    }
}

