package pt.iade.aulas.tutorialgit.models;

public enum MaterialState {
OK(true),LENT(false),REPAIR(false),BROKEN(false),BLOCKED(false);

 private final boolean usable;

   private MaterialState(boolean is){
    this.usable = is;
}

public boolean isUsable(){
       return this.usable;
}
}
