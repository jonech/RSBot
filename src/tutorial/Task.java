package tutorial;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;


public abstract class Task <C extends ClientContext> extends ClientAccessor<C>{
	// abstract class for task
	
	public Task(C ctx) {
		super(ctx);
	}

	public abstract boolean activate();
	
	public abstract void execute();

}
