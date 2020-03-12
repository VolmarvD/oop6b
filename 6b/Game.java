import java.util.Calendar;
import java.util.Objects;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr){
        this.naam = nm;
        this.releaseJaar = rJ;
        this. nieuwprijs = nwpr;
    }

    public String getNaam(){return naam;}

    public double huidigeWaarde(){
        int jaar = Calendar.getInstance().get(Calendar.YEAR);

        return nieuwprijs* Math.pow(0.7, jaar-releaseJaar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;


        return releaseJaar == game.releaseJaar &&
                Objects.equals(naam, game.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, releaseJaar, nieuwprijs);
    }



    @Override
    public String toString() {
        String s =  naam + ", uitgegeven in " + releaseJaar +"; " + String.format("nieuwprijs: €%.2f nu voor: €%.2f", nieuwprijs, huidigeWaarde()) ;

        return  s;
    }
}
