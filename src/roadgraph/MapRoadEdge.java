package roadgraph;

/**
 * Class to represent roads as edges
 */
public class MapRoadEdge {
	private MapRoadNode to;
	private String roadName;
	private String roadType;
	private double length;

	public MapRoadEdge(MapRoadNode to, String roadName, String roadType, double length) {
		this.to = to;
		this.roadName = roadName;
		this.roadType = roadType;
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
