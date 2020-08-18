package de.lexoland.api.easings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lex305
 */
public class Easing {
	
	public static List<Easing> activeEasings = new ArrayList<>();
	
	private final EasingType type; 
	private final double multiplierY;
	private final double time;
	private final TriConsumer<Double, Double, Double> onUpdate;
	private boolean stopped = false;
	private double position = 0;
	private double lastY = 0;
	
	private Easing(EasingType type, double multiplierY, double time, TriConsumer<Double, Double, Double> onUpdate) {
		this.type = type;
		this.multiplierY = multiplierY;
		this.time = time;
		this.onUpdate = onUpdate;
	}
	
	private void tickEasing(final float delta) {
		position += delta;
		if(position >= time) {
			position = time;
			cancel();
		}

		final double x = position / time;
		final double y = type.ease(x) * multiplierY;
		final double dy = y - lastY;
		onUpdate.accept(x, y, dy);
		
		lastY = y;
	}
	
	/**
	 * Cancels the operation.
	 */
	public void cancel() {
		stopped = true;
	}
	
	/**
	 * @return the multiplier for the y axis
	 */
	public double getMultiplierY() {
		return multiplierY;
	}
	
	/**
	 * @return the easing time
	 */
	public double getTime() {
		return time;
	}
	
	/**
	 * @return the easing type
	 */
	public EasingType getType() {
		return type;
	}
	
	/**
	 * @return the position of the easing time
	 */
	public double getPosition() {
		return position;
	}
	
	/**
	 * @return the value if the easing operation is stopped or not
	 */
	public boolean isStopped() {
		return stopped;
	}
	
	
	/**
	 * A very important method. Run this method in your game loop. 
	 * @param delta  the delta value of your game loop
	 */
	public static void tick(final float delta) {
		List<Easing> stoppedEasings = new ArrayList<>();
		for(Easing easing : activeEasings) {
			easing.tickEasing(delta);
			if(easing.isStopped())
				stoppedEasings.add(easing);
		}
		activeEasings.removeAll(stoppedEasings);
	}
	
	/**
	 * Starts an easing animation.
	 * @return the Easing object
	 * @param type  the easing type
	 * @param time  the time
	 * @param onUpdate  every game tick this consumer is executed<br>  T is the x axis [x]<br>  U is the y axis [y * multiplierY]<br>  E is the difference of the last y value and now
	 */
	public static Easing start(EasingType type, double time, TriConsumer<Double, Double, Double> onUpdate) {
		return start(type, 1, time, onUpdate);
	}
	
	/**
	 * Starts an easing animation.
	 * @return the Easing object
	 * @param type  the easing type
	 * @param multiplierY  the y multiplier
	 * @param time  the time
	 * @param onUpdate  every game tick this consumer is executed<br>  value 1 is the x axis [x]<br>  value 2 is the y axis [y * multiplierY]<br>  value 3 is the difference of the last y value and now
	 */
	public static Easing start(EasingType type, double multiplierY, double time, TriConsumer<Double, Double, Double> onUpdate) {
		Easing easing = new Easing(type, multiplierY, time, onUpdate);
		activeEasings.add(easing);
		return easing;
	}
	
	@FunctionalInterface
	public static interface TriConsumer<T, U, E> {
		public void accept(T t, U u, E e);
	}

}
