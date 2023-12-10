package Day9;

import Day8.Day8;

import java.util.ArrayList;
import java.util.List;

public class DataLine {
    List<Integer> data = new ArrayList<>();
    List<Integer[]> deltas = new ArrayList<>();

    public DataLine(String line) {
        String[] s = line.split(" ");
        for (int i = 0; i < s.length; i++) {
            data.add(Integer.parseInt(s[i]));
        }
        countDeltas();
    }

    public void countDeltas() {
        do {
            if (deltas.size() == 0) {
                deltas.add(new Integer[data.size() - 1]);
                for(int i=0 ; i<data.size()-1;i++){
                    deltas.get(deltas.size() - 1)[i] = data.get(i+1)-data.get(i);
                }
            } else {
                deltas.add(new Integer[deltas.get(deltas.size() - 1).length - 1]);
                for (int i = 0; i < deltas.get(deltas.size() - 1).length; i++) {
                    deltas.get(deltas.size() - 1)[i] = deltas.get(deltas.size() - 2)[i + 1] - deltas.get(deltas.size() - 2)[i];
                }
            }

        } while (!allDeltasAreZeros());
    }

    private boolean allDeltasAreZeros() {
        Integer[] delta = deltas.get(deltas.size() - 1);
        for (int i = 0; i < delta.length; i++) {
            if (delta[i] != 0) return false;
        }
        return true;
    }

    public int extrapolate(){
        int lastvalue = 0;

        for( int i = deltas.size()-2;i>=0;i--){
            lastvalue = lastvalue+deltas.get(i)[deltas.get(i).length-1];

        }
        return lastvalue+data.get(data.size()-1);
    }

    public int extrapolateBack(){
        int lastvalue = 0;
        for( int i = deltas.size()-2;i>=0;i--){
            lastvalue = deltas.get(i)[0]-lastvalue;
        }
        return data.get(0)-lastvalue;
    }


}
