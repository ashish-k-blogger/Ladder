import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadder {
	
	public static final int MAX_VALUE = 100;
	List<Snake> snakeList = null;
	List<Ladder> ladderList = null;
	Player player1 = null;
	Player player2 = null;
	
	public void init() {
		String snakes = "17-7,99-78,93-73,87-24,64-60,62-19,54-34";
		String ladders = "4-14,9-31,28-84,40-59,51-67,63-81,71-91";
		String[] snakesArr = snakes.split(",");
		String[] laddersArr = ladders.split(",");
		player1 = new Player("A");
		player2 = new Player("B");
		createSnakeList(snakesArr);
		createLadderList(laddersArr);
		
	}


	private void createLadderList(String[] laddersArr) {
		ladderList = new ArrayList<Ladder>();
		for(String s: laddersArr) {
			String[] values = s.split("-");
			int startValue = Integer.parseInt(values[0]);
			int endValue = Integer.parseInt(values[1]);
			Ladder ladder = new Ladder(startValue, endValue);
			ladderList.add(ladder);
		}
	}


	private void createSnakeList(String[] snakesArr) {
		snakeList = new ArrayList<Snake>();
		for(String s: snakesArr) {
			String[] values = s.split("-");
			int startValue = Integer.parseInt(values[0]);
			int endValue = Integer.parseInt(values[1]);
			Snake snake = new Snake(startValue, endValue);
			snakeList.add(snake);
		}
	}
	
	
	public int rollDice() {
		int diceValue = 0;
		
		while( diceValue == 0) {
			diceValue = (int)(Math.random()*100);
			diceValue = diceValue%7;
		}
		return diceValue;
	}
	
	public void game()  {
		int i=0;
		while( player1.getCurrentScore() != 100 && player2.getCurrentScore() != 100 ) {
			int diceValue = rollDice();
			if( i %2 == 0) {
				moveTheObject(diceValue,player1);
			}
			else{
				moveTheObject(diceValue,player2);
			}
			i++;
		}
	}
	
	public void moveTheObject(int diceValue, Player player){
		int score = player.getCurrentScore() + diceValue;
		
		if( score < MAX_VALUE ) {
			System.out.println(player.getName() + " got " +diceValue+ " and moved to: " +score);
			player.setCurrentScore(score);	
		}
		
		if( score == MAX_VALUE ) {
			System.out.println(player.getName() + " got " +diceValue+ ".WINNER!!");
			player.setCurrentScore(score);
			return;
		}
		if( score > MAX_VALUE ) {
			System.out.println(player.getName() + " got " +diceValue+ " so he cannot be moved and he is still at : " +player.getCurrentScore());
			return;
		}
		for(Snake snake : snakeList){
			if(snake.isExist(score)){
				int scoreAfterBite = snake.bite();
				player.setCurrentScore(scoreAfterBite);
				System.out.println(" Snake bit " +player.getName() + " at " + score + " and he slipped at " + scoreAfterBite);	
				break;
			}
		}
		for(Ladder ladder : ladderList){
			if(ladder.isExist(score)){
				int scoreAfterClimbing = ladder.climb();
				player.setCurrentScore(scoreAfterClimbing);
				System.out.println(" " + player.getName() + " found ladder" + " at " + score + " and he jumped at " + scoreAfterClimbing);	
				break;
			}
		} 
	}
 
	
	public static void main(String[] args) throws Exception {
		SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
		snakeAndLadder.init();
		snakeAndLadder.game();
	}


	public Player getPlayer1() {
		return player1;
	}


	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
 
}
 

 
