package ankhmorpork.GameLoad;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ankhmorpork.Game.*;
import ankhmorpork.GameObjects.*;

public class GamLoad {

	public void LoadGame()
	{
		
	Area[] AreaList = new Area[13];	
	AreaList[0]=new Area(0,0,"Not on Board",0);
	AreaList[1]=new Area(1,6,"Dolly Sisters",0);
	AreaList[2]=new Area(2,18,"Unreal Estate",0);
	AreaList[3]=new Area(3,12,"Dragon's Landing",0);
	AreaList[4]=new Area(4,18,"Small Gods",0);
	AreaList[5]=new Area(5,6,"The Scours",0);
	AreaList[6]=new Area(6,12,"The Hippo",0);
	AreaList[7]=new Area(7,6,"The Shades",0);
	AreaList[8]=new Area(8,6,"Dimwel",0);
	AreaList[9]=new Area(9,12,"Longwall",0);
	AreaList[10]=new Area(10,12,"Isle of Gods",0);
	AreaList[11]=new Area(11,18,"Seven Sleepers",0);
	AreaList[12]=new Area(12,12,"Nap Hill",0);
	System.out.println("Welcome to Ankh-Morpork");	
	//ankhmorpork.Game Ankh = new ankhmorpork.Game();
	Game Ankh = new Game();
	//public ArrayList<Player> lstPlayers = new ArrayList<Player>();
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
	System.out.println("Welcome to Ankh-Morpork");	
	System.out.println("Enter number of Players:");
	Integer input=0;
    try {
		input = Integer.parseInt(br.readLine());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
    	
	for(int i=1;i<=input;i++)
	{
		try
		{
		System.out.println("Enter Name for Player "+i);
		String Name = br.readLine();
		System.out.println("Enter Color for Player "+i);
		String Color = br.readLine();
		Player objPlayer = new Player(i,Name,Color);
		Ankh.lstPlayers.add(objPlayer);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	for(Player objPlayer: Ankh.lstPlayers)
	{
		int i=1;
		System.out.println("Player "+ i + " Details");
		System.out.println("Player ID: "+objPlayer.getPlayer_id()+" Player Name:"+objPlayer.getPlayer_name()+" Player Color:"+objPlayer.getPlayer_color());
		System.out.println("Minion Details of Player "+i);
		for(Minion objMinion:objPlayer.lstMinions)
		{
			System.out.println("MinionID:"+objMinion.getMinion_id()+" MinionArea: "+objMinion.getArea_id()+" MinionColor: "+objMinion.getColor()+" PlayerID: "+objMinion.getPlayer_id());
		}
		i++;		
	}
	System.out.println("Similar for rest");
	}
}
