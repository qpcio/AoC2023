package Day5;

public class SeedGroup {
    long startId;
    long length;

    public SeedGroup(String startId, String length){
        this.startId = Long.parseLong(startId);
        this.length = Long.parseLong(length);
    }
}
