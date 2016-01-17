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
	private double distanceFromStartNode;
	private double straightDistanceToGoalNode;

	public MapRoadNode(double latitude, double longitude) {
		super(latitude, longitude);
	}

	public static MapRoadNode fromGeographicPoint(GeographicPoint point) {
		return new MapRoadNode(point.x, point.y);
	}

	void addEdge(MapRoadNode to, String roadName, String roadType, double length) {
		edges.add(new MapRoadEdge(to, roadName, roadType, length));
	}

	List<MapRoadEdge> getEdges() {
		return edges;
	}

	int numOfEdges() {
		return edges.size();
	}

	double getDistanceFromStartNode() {
		return distanceFromStartNode;
	}

	void setDistanceFromStartNode(double distanceFromStartNode) {
		this.distanceFromStartNode = distanceFromStartNode;
	}

	void setStraightDistanceToGoalNode(GeographicPoint goal) {
		this.straightDistanceToGoalNode = distance(goal);
	}

	void setStraightDistanceToGoalNode(double distance) {
		this.straightDistanceToGoalNode = distance;
	}

	@Override
	public int compareTo(MapRoadNode o) {
		double result = (distanceFromStartNode + straightDistanceToGoalNode)
				- (o.distanceFromStartNode + o.straightDistanceToGoalNode);
		return result < 0 ? -1 : result == 0 ? 0 : 1;
	}

}
