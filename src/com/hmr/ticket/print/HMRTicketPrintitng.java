package com.hmr.ticket.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import com.hmr.data.HMRData;
import com.hmr.ticket.algorithm.DijkstraAlgorithm;
import com.hmr.ticket.model.Vertex;

/**
 * 
 * @author Ranadheer Machineni
 * 
 *         This class is the Main class which takes input stations and calculate
 *         the price
 */
public class HMRTicketPrintitng {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("Enter Source Station Code:%n");
		try {
			String sourceStation = br.readLine().toUpperCase();
			System.out.printf("Enter Destination Station Code:%n");
			String destinationStation = br.readLine().toUpperCase();

			if (!HMRData.vertexMap.containsKey(sourceStation)
					|| !HMRData.vertexMap.containsKey(destinationStation)) {
				System.out.println("Enter valid source and destinations.");
			}
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(HMRData.graph);
			dijkstra.execute(HMRData.vertexMap.get(sourceStation));
			LinkedList<Vertex> path = dijkstra.getPath(HMRData.vertexMap
					.get(destinationStation));
			int distance = path.size();

			double price = calculateThePrice(path);

			printTicket(HMRData.vertexMap.get(sourceStation).getName(),
					HMRData.vertexMap.get(destinationStation).getName(), price,
					distance - 1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static double calculateThePrice(LinkedList<Vertex> path) {

		double price = HMRData.ZERO;
		Vertex prevStation = path.poll();
		int stationCount = (int) HMRData.ZERO;

		while (path.size() > HMRData.ZERO) {
			Vertex nextStation = path.poll();
			stationCount++;
			if (stationCount <= HMRData.FIXED_NUMBER_STATIONS) {
				price = HMRData.FIXED_COST;
			} else if ((HMRData.interChangeList.contains(nextStation) && HMRData.line1
					.contains(prevStation))
					|| HMRData.line1.contains(nextStation)) {
				price += HMRData.LINE1_COST;
			} else if ((HMRData.interChangeList.contains(nextStation) && HMRData.line2
					.contains(prevStation))
					|| HMRData.line2.contains(nextStation)) {
				price += HMRData.LINE2_COST;
			} else if ((HMRData.interChangeList.contains(nextStation) && HMRData.line3
					.contains(prevStation))
					|| HMRData.line3.contains(nextStation)) {
				price += HMRData.LINE3_COST;
			}
			prevStation = nextStation;
		}

		return price;
	}

	private static void printTicket(String sourceStation,
			String destinationStation, double price, int distance) {
		System.out
				.printf("************************************************************************************%n ");
		System.out
				.printf("                 	Hyderabad Metro Rail 		                        %n");
		System.out.printf("Source:    %-20s    Distance ( stations): %2d\n",
				sourceStation, distance);
		System.out.printf("Destination:  %-20s Cost : %.2f\n",
				destinationStation, price);
		System.out
				.printf("************************************************************************************%n ");

	}

}
