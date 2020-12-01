package pt.iade.aulas.tutorialgit.controllers;

import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pt.iade.aulas.tutorialgit.models.*;
import pt.iade.aulas.tutorialgit.models.exeptions.NotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path="/api/materials/")


public class MaterialController {


        private Logger logger = LoggerFactory.getLogger(pt.iade.aulas.tutorialgit.controllers.MaterialController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Material> getAllMaterials() {
        logger.info("Getting all materials");
        return MaterialsRepository.getAllMaterials();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Material searchMaterial(@PathVariable int id) throws NotFoundException {
        logger.info("Searching for material with id" + id);
        Material mat = MaterialsRepository.getMaterial(id);
        if(mat == null){
            throw new NotFoundException("" + id, "Material", "id");
        }
        return mat;
    }

    @GetMapping(path = "/{id}/state", produces = MediaType.APPLICATION_JSON_VALUE)
    public MaterialState getMaterialState(@PathVariable int id) throws NotFoundException {
        logger.info("Searching for material with id" + id);
        MaterialState mat = MaterialsRepository.getMaterial(id).getState();
        if(mat == null){
            throw new NotFoundException("" + id, "MaterialState not found", "id");
        }
        return mat;
    }


}
