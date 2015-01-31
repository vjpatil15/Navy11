package ankhmorpork.GameObjects;

public class Troll {

	Integer troll_id;
	Integer player_id;
	String color;
	Boolean active;
	Integer area_id;
	public Integer getTroll_id() {
		return troll_id;
	}
	public void setTroll_id(Integer troll_id) {
		this.troll_id = troll_id;
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
