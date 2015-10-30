package tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.Script;


@Script.Manifest(name="chop'n'drop", description="cuts willow logs and drops just like the Powerbot tutorial")
public class PowerChopper extends PollingScript<ClientContext>{
	
	private List<Task> taskList = new ArrayList<Task>();
	
	@Override
	public void start() {
		taskList.addAll(Arrays.asList(new Chop(ctx), new Drop(ctx)));
	}

	@Override
	public void poll() {
		for (Task task : taskList) {
			if (task.activate()) {
				// execute task
				task.execute();
			}
		}
		
	}

}
