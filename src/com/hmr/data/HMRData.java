package com.hmr.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hmr.ticket.model.Edge;
import com.hmr.ticket.model.Graph;
import com.hmr.ticket.model.Vertex;
/**
 * 
 * @author Ranadheer Machineni
 * 
 * This class loads the static data
 *
 */
public class HMRData {
	
	public static final double LINE1_COST=2.50; 
	public static final double LINE2_COST=2;
	public static final double LINE3_COST=3;
	public static final double FIXED_COST=10;
	public static final double FIXED_NUMBER_STATIONS=3;
	public static final double ZERO=0;

	public static List<Vertex> nodes;
	public static List<Edge> edges;
	public static Graph graph;
	public static Map<String, Vertex> vertexMap;
	public static List<Vertex> line1 = new ArrayList<Vertex>();
	public static List<Vertex> line2 = new ArrayList<Vertex>();
	public static List<Vertex> line3 = new ArrayList<Vertex>();
	public static List<Vertex> interChangeList = new ArrayList<Vertex>();

	static {
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();

		Map<String, String> stationMap = new HashMap<String, String>();
		stationMap.put("A1", "Miyapur");
		stationMap.put("A2", "JNTU College");
		stationMap.put("A3", "KPHB Colony");
		stationMap.put("A4", "Kukatpally");
		stationMap.put("A5", "Balanagar");
		stationMap.put("A6", "Moosapet");
		stationMap.put("A7", "Bharat Nagar");
		stationMap.put("A8", "Erragadda");
		stationMap.put("A9", "ESI Hospital");
		stationMap.put("A10", "S R Nagar");
		stationMap.put("X1", "Ameerpet");
		stationMap.put("A12", "Punjagutta");
		stationMap.put("A13", "Irrum Manzil");
		stationMap.put("A14", "Khairatabad");
		stationMap.put("A15", "Lakdikapul");
		stationMap.put("A16", "Assembly");
		stationMap.put("A17", "Nampally");
		stationMap.put("A18", "Gandhi Bhavan");
		stationMap.put("A19", "Osmania Medical College");
		stationMap.put("X2", "MG Bus station");
		stationMap.put("A21", "Malakpet");
		stationMap.put("A22", "New Market");
		stationMap.put("A23", "Musarambagh");
		stationMap.put("A24", "Dilsukhnagar");
		stationMap.put("A25", "Chaitanyapuri");
		stationMap.put("A26", "Victoria Memorial");
		stationMap.put("A27", "L B Nagar");

		stationMap.put("B1", "JBS");
		stationMap.put("X3", "Parade Grounds");
		stationMap.put("B3", "Secunderabad");
		stationMap.put("B4", "Gandhi Hospital");
		stationMap.put("B5", "Musheerabad");
		stationMap.put("B6", "RTC Cross Roads");
		stationMap.put("B7", "Chikkadpally");
		stationMap.put("B8", "Narayanguda");
		stationMap.put("B9", "Sultan Bazar");
		stationMap.put("X2", "M G Bus Station");
		stationMap.put("B11", "Salarjung Museum");
		stationMap.put("B12", "Charminar");
		stationMap.put("B13", "Shalibanda");
		stationMap.put("B14", "Shamsher Gunj");
		stationMap.put("B15", "Jungametta");
		stationMap.put("B16", "Falaknuma");

		stationMap.put("C1", "Nagole");
		stationMap.put("C2", "Uppal");
		stationMap.put("C3", "Survey of India");
		stationMap.put("C4", "NGRI");
		stationMap.put("C5", "Habsiguda");
		stationMap.put("C6", "Tarnaka");
		stationMap.put("C7", "Mettuguda");
		stationMap.put("C8", "Secunderabad");
		stationMap.put("X3", "Parade Grounds");
		stationMap.put("C10", "Paradise");
		stationMap.put("C11", "Rasool Pura");
		stationMap.put("C12", "Prakash Nagar");
		stationMap.put("C13", "Begumpet");
		stationMap.put("X1", "Ameerpet");
		stationMap.put("C15", "Madhura Nagar");
		stationMap.put("C16", "Yusuf Guda");
		stationMap.put("C17", "Road No 5 Jubilee Hills");
		stationMap.put("C18", "Jubilee Hills Check Post");
		stationMap.put("C19", "Pedamma Temple");
		stationMap.put("C20", "Madhapur");
		stationMap.put("C21", "Durgam Chervu");
		stationMap.put("C22", "HITEC City");
		stationMap.put("C23", "Shilparamam");

		vertexMap = new HashMap<String, Vertex>();

		for (Entry<String, String> eachStation : stationMap.entrySet()) {
			Vertex location = new Vertex(eachStation.getKey(),
					eachStation.getValue());
			vertexMap.put(eachStation.getKey(), location);
			nodes.add(location);
			if (eachStation.getKey().startsWith("A")) {
				line1.add(location);
			} else if (eachStation.getKey().startsWith("B")) {
				line2.add(location);
			} else if (eachStation.getKey().startsWith("C")) {
				line3.add(location);
			} else {
				interChangeList.add(location);
			}
		}

		addLane("L1", "A1", "A2", 1);
		addLane("L1", "A2", "A3", 1);
		addLane("L1", "A3", "A4", 1);
		addLane("L1", "A4", "A5", 1);
		addLane("L1", "A5", "A6", 1);
		addLane("L1", "A6", "A7", 1);
		addLane("L1", "A7", "A8", 1);
		addLane("L1", "A8", "A9", 1);
		addLane("L1", "A9", "A10", 1);
		addLane("L1", "A10", "X1", 1);
		addLane("L1", "X1", "A12", 1);
		addLane("L1", "A12", "A13", 1);
		addLane("L1", "A13", "A14", 1);
		addLane("L1", "A14", "A15", 1);
		addLane("L1", "A15", "A16", 1);
		addLane("L1", "A16", "A17", 1);
		addLane("L1", "A17", "A18", 1);
		addLane("L1", "A18", "A19", 1);
		addLane("L1", "A19", "X2", 1);
		addLane("L1", "X2", "A21", 1);
		addLane("L1", "A21", "A22", 1);
		addLane("L1", "A22", "A23", 1);
		addLane("L1", "A23", "A24", 1);
		addLane("L1", "A24", "A25", 1);
		addLane("L1", "A25", "A26", 1);
		addLane("L1", "A26", "A27", 1);

		addLane("L2", "B1", "X3", 1);
		addLane("L2", "X3", "B3", 1);
		addLane("L2", "B3", "B4", 1);
		addLane("L2", "B4", "B5", 1);
		addLane("L2", "B5", "B6", 1);
		addLane("L2", "B6", "B7", 1);
		addLane("L2", "B7", "B8", 1);
		addLane("L2", "B8", "B9", 1);
		addLane("L2", "B9", "X2", 1);
		addLane("L2", "X2", "B11", 1);
		addLane("L2", "B11", "B12", 1);
		addLane("L2", "B12", "B13", 1);
		addLane("L2", "B13", "B14", 1);
		addLane("L2", "B14", "B15", 1);
		addLane("L2", "B15", "B16", 1);

		addLane("L3", "C1", "C2", 1);
		addLane("L3", "C2", "C3", 1);
		addLane("L3", "C3", "C4", 1);
		addLane("L3", "C4", "C5", 1);
		addLane("L3", "C5", "C6", 1);
		addLane("L3", "C6", "C7", 1);
		addLane("L3", "C7", "C8", 1);
		addLane("L3", "C8", "X3", 1);
		addLane("L3", "X3", "C10", 1);
		addLane("L3", "C10", "C11", 1);
		addLane("L3", "C11", "C12", 1);
		addLane("L3", "C12", "C13", 1);
		addLane("L3", "C13", "X1", 1);
		addLane("L3", "X1", "C15", 1);
		addLane("L3", "C15", "C16", 1);
		addLane("L3", "C16", "C17", 1);
		addLane("L3", "C17", "C18", 1);
		addLane("L3", "C18", "C19", 1);
		addLane("L3", "C19", "C20", 1);
		addLane("L3", "C20", "C21", 1);
		addLane("L3", "C21", "C22", 1);
		addLane("L3", "C22", "C23", 1);

		graph = new Graph(nodes, edges);
	}

	private static void addLane(String laneId, String string, String string2,
			int duration) {
		Edge lane = new Edge(laneId, vertexMap.get(string),
				vertexMap.get(string2), duration);
		edges.add(lane);
	}

}
