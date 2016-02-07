package roadgraph;

/**
 * Class to represent roads as edges
 * @author Aaron Nwabuoku
 */
public class MapRoadEdge {
	// Use Canada's urban statutory speed limit (50 km/h) as the default maxSpeed
	public static final int DEFAULT_SPEED_LIMIT = 50;
	public static final int DEFAULT_HIGHWAY_SPEED_LIMIT = 100;
	private final MapRoadNode to;
	private final String roadName;
	private final String roadType;
	private final double maxSpeed;
	private final double length;

	public MapRoadEdge(MapRoadNode to, String roadName, String roadType, double maxSpeed, double length) {
		this.to = to;
		this.roadName = roadName;
		this.roadType = roadType;
		this.maxSpeed = maxSpeed == -1 ? DEFAULT_SPEED_LIMIT : maxSpeed;
		this.length = length;
	}

	public MapRoadNode getTo() {
		return to;
	}

	public String getRoadName() {
		return roadName;
	}

	public String getRoadType() {
		return roadType;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public double getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((roadName == null) ? 0 : roadName.hashCode());
		result = prime * result + ((roadType == null) ? 0 : roadType.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapRoadEdge other = (MapRoadEdge) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (roadName == null) {
			if (other.roadName != null)
				return false;
		} else if (!roadName.equals(other.roadName))
			return false;
		if (roadType == null) {
			if (other.roadType != null)
				return false;
		} else if (!roadType.equals(other.roadType))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

}
