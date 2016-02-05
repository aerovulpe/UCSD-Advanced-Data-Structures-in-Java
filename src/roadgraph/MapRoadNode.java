package roadgraph;

import java.util.ArrayList;
import java.util.List;

import geography.GeographicPoint;

/**
 * Class to represent intersections as nodes, extends GeographicPoint for
 * coordinate functionality
 */
public class MapRoadNode extends GeographicPoint implements Comparable<MapRoadNode> {

	private static final long serialVersionUID = -8732196262810800084L;
	private List<MapRoadEdge> edges = new ArrayList<>();
	private double timeFromStartNode;
	private double straightLineTimeToGoalNode;

	public MapRoadNode(double latitude, double longitude) {
		super(latitude, longitude);
	}

	public static MapRoadNode fromGeographicPoint(GeographicPoint point) {
		return new MapRoadNode(point.x, point.y);
	}

	void addEdge(MapRoadNode to, String roadName, String roadType, double maxSpeed, double length) {
		edges.add(new MapRoadEdge(to, roadName, roadType, maxSpeed, length));
	}

	List<MapRoadEdge> getEdges() {
		return edges;
	}

	int numOfEdges() {
		return edges.size();
	}

	public double getTimeFromStartNode() {
		return timeFromStartNode;
	}

	void setTimeFromStartNode(double timeFromStartNode) {
		this.timeFromStartNode = timeFromStartNode;
	}

	void setStraightDistanceToGoalNode(GeographicPoint goal) {
		this.straightLineTimeToGoalNode = distance(goal);
	}

	void setStraightDistanceToGoalNode(double distance) {
		this.straightLineTimeToGoalNode = distance;
	}

	@Override
	public int compareTo(MapRoadNode o) {
		double result = (timeFromStartNode + straightLineTimeToGoalNode)
				- (o.timeFromStartNode + o.straightLineTimeToGoalNode);
		return result < 0 ? -1 : result == 0 ? 0 : 1;
	}

}
