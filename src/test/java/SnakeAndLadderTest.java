import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SnakeAndLadderTest {
	
	SnakeAndLadder snakeAndLadderGame;
	
	@Before
	public void setUp(){
		snakeAndLadderGame = new SnakeAndLadder();
		snakeAndLadderGame.init();
	}

	@Test
	public void testPlayerScoreWhenSnakeBites(){
		snakeAndLadderGame.getPlayer1().setCurrentScore(89);
		snakeAndLadderGame.moveTheObject(4, snakeAndLadderGame.getPlayer1());
		Assert.assertEquals(73, snakeAndLadderGame.getPlayer1().getCurrentScore());
	}
	
	@Test
	public void testPlayerScoreWhenLadderFound(){
		snakeAndLadderGame.getPlayer1().setCurrentScore(25);
		snakeAndLadderGame.moveTheObject(3, snakeAndLadderGame.getPlayer1());
		Assert.assertEquals(84, snakeAndLadderGame.getPlayer1().getCurrentScore());
	}
	
	@Test
	public void testPlayerScoreWhenNothingFound(){
		snakeAndLadderGame.getPlayer1().setCurrentScore(27);
		snakeAndLadderGame.moveTheObject(6, snakeAndLadderGame.getPlayer1());
		Assert.assertEquals(33, snakeAndLadderGame.getPlayer1().getCurrentScore());
	}
	
	@Test
	public void testPlayerScoreWhenObjectCouldNotBeMoved(){
		snakeAndLadderGame.getPlayer1().setCurrentScore(98);
		snakeAndLadderGame.moveTheObject(5, snakeAndLadderGame.getPlayer1());
		Assert.assertEquals(98, snakeAndLadderGame.getPlayer1().getCurrentScore());
	}
	
	@Test
	public void testPlayerScoreWhenReachesMaxValue(){
		snakeAndLadderGame.getPlayer1().setCurrentScore(98);
		snakeAndLadderGame.moveTheObject(2, snakeAndLadderGame.getPlayer1());
		Assert.assertEquals(100, snakeAndLadderGame.getPlayer1().getCurrentScore());
	}
	
	@Test
	public void testDiceRollBetweenOneToSix(){
		for (int i = 0; i < 30; i++) {
			int diceValue = snakeAndLadderGame.rollDice();
			Assert.assertEquals(true, diceValue >= 1 && diceValue <= 6);
		}
	}
	
	
}
