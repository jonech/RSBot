package tutorial;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;


public class Chop extends Task<ClientContext>{
	
	// store tree id in an array
	private int[] treeIds = {38616, 38627, 58006};
	
	public Chop(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		
		return (ctx.backpack.select().count() < 28) &&
				(!ctx.objects.select().id(treeIds).isEmpty()) &&
				(ctx.players.local().animation() == -1);
	}

	@Override
	public void execute() {
		GameObject tree = ctx.objects.nearest().poll();
		
		if (tree.inViewport()) {
			tree.interact("Chop");
		}
		else {
			ctx.movement.step(tree);
			ctx.camera.turnTo(tree);
		}
	}

}
