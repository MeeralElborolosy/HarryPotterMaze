package control;


public interface GameState {
	void Move(int x,int y);
	void HitSpaceBar();
	String toString();
}
