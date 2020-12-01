package pt.iade.aulas.tutorialgit.models;

import java.util.List;

public interface Statistical {

    double getAverage();

    double getMax();

    double getMin();

    // relação de use do UML é por este metodo que devolve HistogramSlot
    HistogramSlot[] getHistogram(Integer nSlots);

    default  double getRange(){
        return getMax() - getMin();
    };

    default  double getGroupAverage ( List<Statistical> group){
        double sum=0;
        for ( Statistical stat : group)
            sum+= stat.getAverage();
        return sum / group.size();
    }



}
