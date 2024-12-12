package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
	
}
public class Run1_ser {
	
	public static void main(String[] args) throws Exception {
		
	
	NFSGame userobj1=new NFSGame("jagadish", 20, 6000, 3);
	FileOutputStream fileout=new FileOutputStream("./f.txt");
	ObjectOutputStream objout=new ObjectOutputStream(fileout);
	objout.writeObject(userobj1);
	System.out.println("++++++++++END++++++++++++++");
	}
}
