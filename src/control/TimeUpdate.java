package control;

import java.util.TimerTask;

import model.MazePlayer;
import view.MazePane;

public class TimeUpdate extends TimerTask{
	static TimeUpdate time;
	int seconds=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		seconds++;
		MazePane.timer.setText("Time: "+seconds);
	}
	public static TimeUpdate getTimer()
	{
		return time;
	}
	
}
