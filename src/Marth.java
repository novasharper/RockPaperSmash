import java.util.Random;

/**
 * Created by darrien on 12/19/15.
 */
public class Marth extends Champion {
    public Marth (String playerName){
        super("stats/MarthStats.txt");
        charName = playerName;
    }

    // Same as standard attack, but with 30% chance of triggering special
    @Override
    public double attack(Champion rhs){
        isSpecial = false;
        if (getActionFlag() == 0){
            Random rand = new Random();
            if (rand.nextDouble() <= .3){
                return specialAttack(rhs);
            }
        }

        // Chaingrabs against spacies are especially deadly with Marth
        if (getActionFlag() == 1 && rhs.getAttribute().equals("spacie")){
            if (rhs.getPercentDmg() < 80){
                rhs.takeDamage(46);
                return getGrabKB();
            }
            else{
                rhs.takeDamage(getGrabDmg() * 1.25);
                return getGrabKB();
            }
        }

        rhs.takeDamage(stats[getActionFlag()][0]);
        return stats[getActionFlag()][1];
    }

    // 30% chance of occurring, doubles Marth's attack power, and increases KB by 1.25
    @Override
    public double specialAttack(Champion rhs){
        isSpecial = true;
        rhs.takeDamage(getAtkDmg() * 2);
        return getAtkKB() * 1.25;
    }

    @Override
    public String getChampionName(){
        return "MARTH";
    }
}
