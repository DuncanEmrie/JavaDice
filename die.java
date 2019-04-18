package application;
import java.util.Random;
public class die {
private int face;

	die() {setFace();}

	public void setFace() {Random gen = new Random();
						   face = gen.nextInt(6) + 1;}

	public int getFace() {return face;}
}
