package ankhmorpork.GameObjects;

public class Demon {

	Integer demon_id;
	Integer player_id;
	String color;
	Boolean active;	
	Integer area_id;
	public Integer getDemon_id() {
		return demon_id;
	}
	public void setDemon_id(Integer demon_id) {
		this.demon_id = demon_id;
	}
	public Integer getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(Integer player_id) {
		this.player_id = player_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}	
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	
}
