package Day5;

public class Mapping {
    long inputStart;
    long outputStart;
    long length;

    public boolean contains(long input){
        return input>=inputStart && input<inputStart+length;
    }

    public long outputFor(long input){
        long delta = input - inputStart;
        return outputStart+delta;
    }
    public Mapping(String mapping){
        String[] mappings = mapping.split(" ");
        this.inputStart = Long.parseLong(mappings[1]);
        this.outputStart = Long.parseLong(mappings[0]);
        this.length = Long.parseLong(mappings[2]);
    }
}
