import problem.Problem;
import problem.h000.d000.*;
import problem.h000.d040.*;
import problem.h000.d010.*;
import problem.h000.d020.*;
import problem.h000.d030.*;
import problem.h000.d050.*;
import problem.h000.d060.Problem067;

public class Main {
    private static final Problem[] PROBLEMS = new Problem[]{
            new Problem001(), new Problem002(), new Problem003(), new Problem004(), new Problem005(),
            new Problem006(), new Problem007(), new Problem008(), new Problem009(), new Problem010(),
            new Problem011(), new Problem012(), new Problem013(), new Problem014(), new Problem015(),
            new Problem016(), new Problem017(), new Problem018(), new Problem019(), new Problem020(),
            new Problem021(), new Problem022(), new Problem023(), new Problem024(), new Problem025(),
            new Problem026(), new Problem027(), new Problem028(), new Problem029(), new Problem030(),
            new Problem031(), new Problem032(), new Problem033(), new Problem034(), new Problem035(),
            new Problem036(), new Problem037(), new Problem038(), new Problem039(), new Problem040(),
            new Problem041(), new Problem042(), new Problem043(), new Problem044(), new Problem045(),
            new Problem046(), new Problem047(), new Problem048(), new Problem049(), new Problem050(),
            new Problem051(), new Problem052(), new Problem053(), new Problem054(),
            new Problem067()
    };

    public static void main(String[] args) {
        for (int i = 0; i < PROBLEMS.length; i++) {
            Problem problem = PROBLEMS[i];
            long start = System.currentTimeMillis();
            long result = problem.solve();
            long end = System.currentTimeMillis();

            System.out.println(problem.getClass().getSimpleName() + ": " + result + " in " + (end - start) + "ms");
        }
    }
}
