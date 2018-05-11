package control;


public interface GameState {
	void Move(int x,int y);
	void HitSpaceBar(char lastPressed);
	String toString();
}
