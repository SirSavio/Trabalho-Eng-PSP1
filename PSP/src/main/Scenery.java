package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Scenery {

	private List<Player> players;

	@Override
	public int hashCode() {
		return Objects.hash(players);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scenery other = (Scenery) obj;
		return Objects.equals(players, other.players);
	}

	public Scenery(List<Player> players) {
		super();
		this.players = players;
	}

	public Scenery() {
		super();
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}

	public void clear() {
		this.players.clear();
	}

	public char verify() {
		Collections.sort(this.players, Comparator.comparing(Player::getDistance));
		boolean isImpedido = false;

		Player moreCloseAttack = new Player('A');
		Player moreCloseDefende = new Player('D');
		Player secondMoreCloseDefende = new Player('D');

		for (Player player : this.players) {
			if (player.getType() == 'A' && moreCloseAttack.getDistance() == 0) {
				moreCloseAttack.setDistance(player.getDistance());
			} else if (player.getType() == 'D' && moreCloseDefende.getDistance() == 0) {
				moreCloseDefende.setDistance(player.getDistance());
			} else if (player.getType() == 'D' && secondMoreCloseDefende.getDistance() == 0) {
				secondMoreCloseDefende.setDistance(player.getDistance());
			}
		}

		if (moreCloseAttack.getDistance() < moreCloseDefende.getDistance()
				|| moreCloseAttack.getDistance() < secondMoreCloseDefende.getDistance())
			isImpedido = true;

		return isImpedido ? 'Y' : 'N';
	}
}
