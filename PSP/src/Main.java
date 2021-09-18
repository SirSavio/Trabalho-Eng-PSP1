import java.util.Scanner;
import main.Player;
import main.Scenery;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scenery scenery = new Scenery();
		int attackQuantity;
		int defendeQuantity;

		attackQuantity = in.nextInt();
		defendeQuantity = in.nextInt();

		while (attackQuantity != 0 && defendeQuantity != 0) {
			if (attackQuantity < 1 || defendeQuantity < 2) {
				System.out.println(
						"Para conseguir descobrir de está ou não impedido, pelo menos um atacando e dois defensores");
				continue;
			}
			for (int i = 0; i < attackQuantity; i++) {
				Player attack = new Player('A', in.nextInt());
				scenery.addPlayer(attack);
			}
			for (int i = 0; i < defendeQuantity; i++) {
				Player defende = new Player('D', in.nextInt());
				scenery.addPlayer(defende);
			}

			System.out.println(scenery.verify());
			scenery.clear();

			attackQuantity = in.nextInt();
			defendeQuantity = in.nextInt();
		}
	}
}
