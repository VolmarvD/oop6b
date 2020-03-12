import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<>();

    public Persoon(String nm, double bud){
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget(){return budget;}

    public boolean koop (Game g){
        if(budget >= g.huidigeWaarde() && !mijnGames.contains(g) ){
            mijnGames.add(g);
            budget -=g.huidigeWaarde();
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (!koper.mijnGames.contains(g) && koper.budget >= g.huidigeWaarde() && mijnGames.contains(g)) {
            koper.budget -= g.huidigeWaarde();
            koper.mijnGames.add(g);
            budget+= g.huidigeWaarde();
            mijnGames.remove(g);
            return true;
        }
        else{return false;}
    }


    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> teKoop){
        ArrayList<Game> bezitNiet = new ArrayList<>();
        for (Game spel : teKoop){
            boolean inBezit = false;
            for (Game mijnGame : mijnGames){
                if (mijnGame == spel){
                    inBezit = true;
                    break;
                }
            }
            if (!inBezit){
                bezitNiet.add(spel);
            }
        }
        return bezitNiet;
    }


    @Override
    public String toString() {
        String s = naam + String.format(" heeft een budget van €%.2f", budget) + " en bezit de volgende games:";
        if (mijnGames.size()>0) {
            for (Game g : mijnGames) {
                s += "\n" + g  ;
            }
        }
        return s;
    }
}
