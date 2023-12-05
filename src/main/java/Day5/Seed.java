package Day5;

public class Seed {
    long id;
    long soil;
    long fertilizer;
    long water;
    long light;
    long temperature;
    long humidity;
    long location;

    public Seed(String id){
        this.id = Long.parseLong(id);

    }

    public Seed(long id){
        this.id = id;
    }
}
