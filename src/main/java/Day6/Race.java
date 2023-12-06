package Day6;

public class Race {
    private long time;
    private long recordedDistance;

    public long noOfWaysToWin(){
        int result = 0 ;
        for(int i=1;i<time;i++){
            if(recordedDistance<(time-i)*i){
                result++;
            }
        }
        return result;
    }

    public Race(long time, long recordedDistance) {
        this.time = time;
        this.recordedDistance = recordedDistance;
    }
}
