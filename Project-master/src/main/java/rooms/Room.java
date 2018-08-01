package rooms;
import javax.persistence.*;

@Entity
@Table(name="room")

public class Room {
	
	@Id
	public Long id;
	
	@Column(name="capacity")
	public int cap;
	
	
	public String name;
	
	@Column(name="availability")
	public char a;
	
	@Column(name="board")
	public char b;
	
	public String floor;
	
	public char projector;
	
	
	
	

}
