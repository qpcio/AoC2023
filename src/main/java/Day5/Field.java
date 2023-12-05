package Day5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Field {
    List<Seed> seeds = new ArrayList<>();
    List<SeedGroup> seedGroups = new ArrayList<>();

    List<Mapping> seed2soil = new ArrayList<>();
    List<Mapping> soil2fert = new ArrayList<>();
    List<Mapping> fert2water = new ArrayList<>();
    List<Mapping> water2light = new ArrayList<>();
    List<Mapping> light2temp = new ArrayList<>();
    List<Mapping> temp2hum = new ArrayList<>();
    List<Mapping> hum2location = new ArrayList<>();

    public long task1(){
        long result = seeds.get(0).location;
        for(Seed s:seeds) {
            if(s.location<result)result=s.location;
        }
        return result;
    }

    public long task2(){
        Seed seed = new Seed(seedGroups.get(0).startId);
        processSeed(seed);
        long result = seed.location;
        for(SeedGroup sg:seedGroups){
            int index = seedGroups.indexOf(sg)+1;
            System.out.println("Starting group "+index+" of "+seedGroups.size());
            for(long i=0;i<sg.length;i++){
                
                 seed=new Seed(sg.startId+i);
                 processSeed(seed);
                 if(seed.location<result)result = seed.location;
            }
        }
        return result;
    }


    public void processEverything() {
        for (Seed s : seeds) {
            processSeed(s);
        }

    }

    private void processSeed(Seed s) {
        boolean changed = false;
        for (Mapping m : seed2soil) {
            if (m.contains(s.id)) {
                s.soil = m.outputFor(s.id);
                changed = true;
                break;
            }
        }
        if(!changed){
            s.soil = s.id;
        }
        changed = false;
        for (Mapping m : soil2fert) {
            if (m.contains(s.soil)) {
                s.fertilizer = m.outputFor(s.soil);
                changed = true;
                break;
            }
        }
        if(!changed){
            s.fertilizer = s.soil;
        }
        changed = false;
        for (Mapping m : fert2water) {
            if (m.contains(s.fertilizer)) {
                s.water = m.outputFor(s.fertilizer);
                changed = true;
                break;
            }
        }
        if(!changed){
            s.water = s.fertilizer;
        }
        changed = false;
        for (Mapping m : water2light) {
            if (m.contains(s.water)) {
                s.light = m.outputFor(s.water);
                changed = true;
                break;
            }
        }
        if(!changed){
            s.light = s.water;
        }
        changed = false;
        for (Mapping m : light2temp) {
            if (m.contains(s.light)) {
                s.temperature = m.outputFor(s.light);
                changed = true;
                break;
            }
        }
        if(!changed){
            s.temperature = s.light;
        }
        changed = false;
        for (Mapping m : temp2hum) {
            if (m.contains(s.temperature)) {
                s.humidity = m.outputFor(s.temperature);
                changed = true;
                break;
            }
        }
        if(!changed){
            s.humidity = s.temperature;
        }
        changed = false;
        for (Mapping m : hum2location) {
            if (m.contains(s.humidity)) {
                s.location = m.outputFor(s.humidity);
                changed = true;
                break;
            }
        }
        if(!changed){
            s.location = s.humidity;
        }
    }


    public Field(String filePath) {
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("")) continue;
                else if (line.startsWith("seeds:")) {
                    String[] inputline = line.split(" ");
                    for (int i = 1; i < inputline.length; i+=2) {
                        seeds.add(new Seed(inputline[i]));
                        if(i%2==1){
                               seedGroups.add(new SeedGroup(inputline[i],inputline[i+1]));
                        }
                    }
                } else if (line.startsWith("seed-to-soil")) {
                    line = scanner.nextLine();
                    do {
                        seed2soil.add(new Mapping(line));
                        line = scanner.nextLine();
                    } while (!line.equals(""));
                } else if (line.startsWith("soil-to-fertilizer")) {
                    line = scanner.nextLine();
                    do {
                        soil2fert.add(new Mapping(line));
                        line = scanner.nextLine();
                    } while (!line.equals(""));
                } else if (line.startsWith("fertilizer-to-water")) {
                    line = scanner.nextLine();
                    do {
                        fert2water.add(new Mapping(line));
                        line = scanner.nextLine();
                    } while (!line.equals(""));
                } else if (line.startsWith("water-to-light")) {
                    line = scanner.nextLine();
                    do {
                        water2light.add(new Mapping(line));
                        line = scanner.nextLine();
                    } while (!line.equals(""));
                } else if (line.startsWith("light-to-temperature")) {
                    line = scanner.nextLine();
                    do {
                        light2temp.add(new Mapping(line));
                        line = scanner.nextLine();
                    } while (!line.equals(""));
                } else if (line.startsWith("temperature-to-humidity")) {
                    line = scanner.nextLine();
                    do {
                        temp2hum.add(new Mapping(line));
                        line = scanner.nextLine();
                    } while (!line.equals(""));
                } else if (line.startsWith("humidity-to-location")) {
                    line = scanner.nextLine();
                    hum2location.add(new Mapping(line));
                    do {
                        if (scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            hum2location.add(new Mapping(line));
                        }
                    } while (!line.equals("") && scanner.hasNextLine());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
