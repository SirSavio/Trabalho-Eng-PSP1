package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Player;
import main.Scenery;

class SceneryTest {
	Scenery scenery = new Scenery();
	
	Player attack200 = new Player('A', 200);
	Player attack500 = new Player('A', 500);
	Player attack1000 = new Player('A', 1000);
	
	Player defende200 = new Player('D', 200);
	Player defende500 = new Player('D', 500);
	Player defende1000 = new Player('D', 1000);
	
	@Test
	void sameLineTest() {
		scenery.addPlayer(attack500);
		scenery.addPlayer(attack1000);
		scenery.addPlayer(defende200);
		scenery.addPlayer(defende500);
		
		assertEquals('N', scenery.verify());
	}
	
	
	@Test
	void sameLineTest2() {
		scenery.addPlayer(attack200);
		scenery.addPlayer(attack200);
		scenery.addPlayer(defende200);
		scenery.addPlayer(defende200);
		
		assertEquals('N', scenery.verify());
	}
	  
	@Test
	void impedidoTest() {
		scenery.addPlayer(attack200);
		scenery.addPlayer(attack500);
		scenery.addPlayer(defende500);
		scenery.addPlayer(defende1000);
		
		assertEquals('Y', scenery.verify());
	}
	
	@Test
	void impedidoTest2() {
		scenery.addPlayer(attack500);
		scenery.addPlayer(attack500);
		scenery.addPlayer(defende500);
		scenery.addPlayer(defende1000);
		
		assertEquals('Y', scenery.verify());
	}
	  
	  @Test 
	  void oneAttackerOneDefendeTest (){
		  scenery.addPlayer(attack500);
		  scenery.addPlayer(defende500);
		  
		  assertEquals('N', scenery.verify());
	  }
	  
	  @Test 
	  void oneAttackerOneDefendeTest2 (){
		  scenery.addPlayer(attack200);
		  scenery.addPlayer(defende500);
		  
		  assertEquals('Y', scenery.verify());
	  }
	  
	  @Test 
	  void oneAttackerOneDefendeTest3 (){
		  scenery.addPlayer(attack500);
		  scenery.addPlayer(defende200);
		  
		  assertEquals('N', scenery.verify());
	  }
	  
	  @Test 
	  void oneAttackerTwoDefendeTest (){
		  scenery.addPlayer(attack500);
		  scenery.addPlayer(defende500);
		  scenery.addPlayer(defende1000);
		  
		  assertEquals('Y', scenery.verify());
	  }
	  
	  @Test 
	  void oneAttackerTwoDefendeTest2 (){
		  scenery.addPlayer(attack200);
		  scenery.addPlayer(defende500);
		  scenery.addPlayer(defende1000);
		  
		  assertEquals('Y', scenery.verify());
	  }
	  
	  @Test 
	  void oneAttackerTwoDefendeTest3 (){
		  scenery.addPlayer(attack500);
		  scenery.addPlayer(defende500);
		  scenery.addPlayer(defende500);
		  
		  assertEquals('N', scenery.verify());
	  }
	  
	  @Test 
	  void onlyAttackers (){
		  scenery.addPlayer(attack500);
		  scenery.addPlayer(attack200);
		  
		  assertEquals('N', scenery.verify());
	  }
	  
	  @Test 
	  void onlyDefenders (){
		  scenery.addPlayer(defende500);
		  scenery.addPlayer(defende200);
		  
		  assertEquals('Y', scenery.verify());
	  }
}
