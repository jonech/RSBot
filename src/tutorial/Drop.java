package tutorial;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;




public class Drop extends Task<ClientContext> {
	
	// id for log
	private int logId = 1511;
	
	public Drop(ClientContext ctx) {
		super(ctx);
	}

	
	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28;
	}

	@Override
	public void execute() {
		for (Item i: ctx.backpack.id(logId)) {
			i.interact("Drop");
		}
	}
	
}
