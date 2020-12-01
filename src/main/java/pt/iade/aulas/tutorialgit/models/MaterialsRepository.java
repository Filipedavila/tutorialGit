package pt.iade.aulas.tutorialgit.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MaterialsRepository {
    public static List<Material> materials = new ArrayList<Material>();

    public static void populate(){
        Material t;
        t = new Material("Caneta");

        materials.add(t);
        materials.add(new Material("Secretaria"));

        materials.add(new Material("Televisão"));
        materials.add(new Material("Aquecedor"));

        materials.add(new Material("Mesa"));

    }

    public static List<Material> getAllMaterials(){

        return materials;
    }

    public static Material getMaterial(int id){
        Material res = null;
        for(Material inst : materials){
            if(inst.getId()== id){
                res= inst;
            }

        }
        return res;

    }

    public static MaterialState getMaterialState(Material mat){
        return mat.getState();

    }

    public static void removeMaterial(int id){
        List<Material> removed = getAllMaterials().stream().filter(x->x.getId() == id).collect(Collectors.toList()) ;
        materials = removed;
    }




}
