package control;

public class Game_State implements GameState{

	static Game_State state=new Game_State();

	@Override
	public void Move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitSpaceBar() {
		
	}

	@Override
	public String toString() {
		return null;
	}
	public static Game_State getState()
	{
		return state;
	}
}
