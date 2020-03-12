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
    public Game zoekGameOpNaam(String game){
        for (Game spel : mijnGames){
            if (spel.getNaam().equals(game)) {
                return spel;
            }
        }
        return null;
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
