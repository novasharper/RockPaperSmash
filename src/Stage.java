import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by darrien on 12/19/15.
 */
public abstract class Stage {

    /*
        +---------------+-------------+
        | HoriztonalLen | VerticalLen |
        +---------------+-------------+
     */
    private double[] stageStats;

    public Stage(String statsFile){
        try{
            BufferedReader br = new BufferedReader(new FileReader(statsFile));
            stageStats[0] = Double.parseDouble(br.readLine());
            stageStats[1] = Double.parseDouble(br.readLine());

        }catch(java.io.IOException e){
            // Restart program when failure - add later
            System.out.println("Invalid parameters. Process failed.");
            System.exit(1);
        }
    }

    public double getHorizontalLen() {
        return stageStats[0];
    }

    public double getVerticalLen() {
        return stageStats[1];
    }
}