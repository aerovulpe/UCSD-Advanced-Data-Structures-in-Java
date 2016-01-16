package roadgraph;

import geography.GeographicPoint;

/**
 * Class to represent intersections as nodes, extends GeographicPoint for
 * coordinate functionality
 */
public class MapRoadNode extends GeographicPoint implements Comparable<MapRoadNode> {

	private static final long serialVersionUID = -8732196262810800084L;
	private double distanceFromStartNode;
	private double straightDistanceToGoalNode;

	public MapRoadNode(double latitude, double longitude) {
		super(latitude, longitude);
	}

	public static MapRoadNode fromGeographicPoint(GeographicPoint point) {
		return new MapRoadNode(point.x, point.y);
	}

	double getDistanceFromStartNode() {
		return distanceFromStartNode;
	}

	void setDistanceFromStartNode(double distanceFromStartNode) {
		this.distanceFromStartNode = distanceFromStartNode;
	}

	void setStraightDistanceToGoalNode(GeographicPoint goal) {
		this.straightDistanceToGoalNode = Math.abs(distance(goal));
	}

	void setStraightDistanceToGoalNode(double distance) {
		this.straightDistanceToGoalNode = distance;
	}

	@Override
	public int compareTo(MapRoadNode o) {
		// System.out.println(this + " : g(n) = " + distanceFromStartNode);
		// System.out.println(this + " : h(n) = " + straightDistanceToGoalNode);
		// System.out.println(this + " : f(n) = " + (distanceFromStartNode +
		// straightDistanceToGoalNode));
		// System.out.println(o + " : g(n) = " + o.distanceFromStartNode);
		// System.out.println(o + " : h(n) = " + o.straightDistanceToGoalNode);
		// System.out.println(o + " : f(n) = " + (o.distanceFromStartNode +
		// o.straightDistanceToGoalNode));

		double result = (distanceFromStartNode + straightDistanceToGoalNode)
				- (o.distanceFromStartNode + o.straightDistanceToGoalNode);
		return result < 0 ? -1 : result == 0 ? 0 : 1;
	}

}
