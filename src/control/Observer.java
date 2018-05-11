package control;

import java.util.ArrayList;

public class Observer {
	ArrayList<Observers> observers;
	static Observer observer=new Observer();
	private Observer()
	{
		observers=new ArrayList();
		observers.add(HealthObserver.getHealthObserver());
		observers.add(ArmorObserver.getArmorObserver());
		observers.add(BulletsObserver.getBulletsObserver());
	}
	public static Observer getObserver()
	{
		return observer;
	}
	public void addObserver(Observers newObserver)
	{
		this.observers.add(newObserver);
	}
	public void updateObservers()
	{
		for(Observers x: observers)
		{
			x.update();
		}
	}
}
