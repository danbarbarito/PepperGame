package main;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Particles {
	public ParticleSystem ps;
	public FireEmitter fe;

	public Particles()
	{
		ps = new ParticleSystem("data/particle.png",1500);
		fe = new FireEmitter(100,100);
		ps.addEmitter(fe);
		fe.setEnabled(true);
		ps.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}
	
	public void render()
	{
		ps.render();
	}
	public void update(int delta)
	{
		ps.update(delta);
	}
}
