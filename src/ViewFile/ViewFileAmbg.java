package ViewFile;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import PresentationUtilityCommon.PresentationUtility;
import ankhmorpork.GameObjects.Area;
import ankhmorpork.GameObjects.Player;

public class ViewFileAmbg {

	public static void main(String[] args) {

		String sb = dataToStoreInTextFile();
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("/home/me/Documents"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".ambg");
	            fw.write(sb.toString());
	            fw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public static String ViewState(){
		return dataToStoreInTextFile();
	}
	
	public static String dataToStoreInTextFile(){
		String saveTheDetailsInTextFile = "";
		
		saveTheDetailsInTextFile += playerGeneralInfo(InitializePlayers());
		saveTheDetailsInTextFile += "\n\n";
		saveTheDetailsInTextFile += areaDetails();
		saveTheDetailsInTextFile += "\n\n";
		saveTheDetailsInTextFile += playerDetails(InitializePlayers());
		saveTheDetailsInTextFile += "\n\n";
		saveTheDetailsInTextFile += totalAmountBankOwns();
		
		return saveTheDetailsInTextFile;
	}
	
	/**
	 * The method below is just an random input to play with the method
	 * @return
	 */
	
	public static ArrayList<Player> InitializePlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		
		Player player1 = new Player(1, "naresh", "blue");
		Player player2 = new Player(2, "vijay", "green");
		Player player3 = new Player(3, "ashish", "red");
		
		player1.setPlayer_active(true);
		player1.setPlayer_amount((float)1000.00);
		player1.setPlayer_color("red");
		player1.setPlayer_id(1);
		player1.setPlayer_personality_card_id(1);
		
		player2.setPlayer_active(true);
		player2.setPlayer_amount((float)2000.00);
		player2.setPlayer_color("blue");
		player2.setPlayer_id(2);
		player2.setPlayer_personality_card_id(2);
		
		player3.setPlayer_active(true);
		player3.setPlayer_amount((float)3000.00);
		player3.setPlayer_color("green");
		player3.setPlayer_id(3);
		player3.setPlayer_personality_card_id(3);
		
		players.add(player1);
		players.add(player2);
		players.add(player3);		
		
		return players;
	}
	
	public static String playerGeneralInfo(ArrayList<Player> players){
		
		String playerGeneralInfoStr = "Game State";
		int i = players.size()-1;
		
		playerGeneralInfoStr += "\n-----------------";
		playerGeneralInfoStr += "\nThere are "+players.size()+" players:";
		
		for(Player player: players){
			playerGeneralInfoStr += "\nPlayer "+(players.size() -i)+", "+ player.getPlayer_color()+", "+ PresentationUtility.getPersonalityCardNameById(player.getPlayer_personality_card_id());
			i -= 1;
		}
		return playerGeneralInfoStr;
	}

	public static String areaDetails(){
		
		String areaDetails = "\n\nCurrent State of the Game Board: ";
		areaDetails += "\n\t\tarea\t\t\t\t\t\tminions\t\t\ttrouble?\t\t\tbuildings?\t\t\tdemons\t\ttrolls";
		
		for(int i = 1; i < 12; i++){
			areaDetails += "\n\t"+paddingToMakeSixteen(PresentationUtility.getCityAreaCardNameById(i))+"\t\t\t\t"
					+Area.getListOfMinionsByAreaId(i)+ "\t\t\t"
					+Area.getListOfTroubleMakersByAreaId(i)+ "\t\t\t\t\t"
					+Area.getListOfBuildingsByAreaId(i)+ "\t\t\t\t\t"
					+Area.getListOfDemonsByAreaId(i)+ "\t\t\t\t"
					+Area.getListOfTrollsByAreaId(i)+ "\t";
		}
		return areaDetails;
	}
	
	public static String paddingToMakeSixteen(String areaName){
		
		String emptyString = "";
		if(areaName.length() < 16){
			for(int i = 1; i <= 16-areaName.length(); i++){
				emptyString += " ";
			}
		}
		return areaName+emptyString;
	}
	
	public static String playerDetails(ArrayList<Player> players){
		
		String playerDetails = "";
		int i = players.size()-1;
		for(Player player: players){
			playerDetails += "\nPlayer "+(players.size() -i)+"'s current Inventory:";
			playerDetails += "\n\n\t- "+player.lstMinions.size()+" minions, "+player.lstBuildings.size()+" buildings, "+player.lstMinions.size()+" dollars ";
			playerDetails += "\n\n\t-City Area Cards: ";
			playerDetails += "\n\t\t"; //TODO: Have to print City Area Cards, which player has how much
			playerDetails += "\n\n\t-Player Cards: ";
			playerDetails += "\n\t\tGreen Cards "; 
			playerDetails += "\n\t\tBrown Cards ";
			playerDetails += "\n";
			i -= 1;
		}

		return playerDetails;
		
	}
	
	public static String totalAmountBankOwns(){
		String totalAmountStr = "The bank has "+74+" Ankh-Morpork dollars.";
		
		return totalAmountStr;
		
	}

}
