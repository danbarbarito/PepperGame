package main;
import org.newdawn.slick.*;
import java.io.File;
import java.io.IOException;

import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Particles {
	public ParticleSystem ps;
	public ParticleSystem ps2;
	public ConfigurableEmitter em;
	public File xmlFile;
	public Particles()
	{
		xmlFile = new File("data/emitter.xml");
		ps = new ParticleSystem("data/particle.png");
		ps2 = new ParticleSystem("data/particle.png");
		em = new ConfigurableEmitter("Basic");

		/*try {
			ParticleIO.saveEmitter(xmlFile, em);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ps.addEmitter(em);
		ps2.addEmitter(em);
		ps.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
		ps2.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}

	public void render()
	{
		ps.render();
		ps2.render();
	}
	public void setPositionPlayer(float x, float y)
	{
		ps.setPosition(x, y);
	}
	public void setPositionBuff(float x, float y)
	{
		ps2.setPosition(x,y);
	}
	public void update(int delta)
	{
		ps.update(delta);
		ps2.update(delta);
	}
}
