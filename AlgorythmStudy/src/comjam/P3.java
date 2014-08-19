package comjam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P3 {

	private static final int GRAPH_SIZE_TIMING = 1;

	public static void main(String[] args) throws IOException {
		// step 0 : 초기화한다.
		BufferedReader reader = new BufferedReader(new FileReader(new File("")));
		
		int totalCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < totalCount; i++) {
			// # step 1 : 그래프를 만든다.
			int nodeNum = Integer.parseInt(reader.readLine());
			int graph[][] = new int[nodeNum][nodeNum];
			initGraph(graph);
			int vertexNum = Integer.parseInt(reader.readLine());
			
			for(int j = 0; j < vertexNum; j++) {
				String temp = reader.readLine();
				String[] vertexStr = temp.split(" ");
				int from = Integer.parseInt(vertexStr[0]);
				int to = Integer.parseInt(vertexStr[1]);
				int weight = Integer.parseInt(vertexStr[2]);
				graph[from][to] = weight;
				graph[to][from] = weight;
			}
			// # step 2 : 각각의 최단거리 산정
			makeShotestPath(graph);
			
			//# step 3 : 최소 노드 산출
			getShortestNode(graph);
			
		}
		reader.close();
	}
	
	static class ShortestNode {
		int nodeId;
		int vertexSum;
		
		public ShortestNode() {
			// TODO Auto-generated constructor stub
			nodeId = -1;
			vertexSum = Integer.MAX_VALUE;
					
		}
		
		public ShortestNode(int nodeId, int vertexSum) {
			// TODO Auto-generated constructor stub
			this.nodeId = nodeId;
			this.vertexSum = vertexSum;
		}
	}
	
	private static ShortestNode getShortestNode(int graph[][]) {
		int length = graph.length;
		ShortestNode node = new ShortestNode();
		for(int i = 0; i < length; i++) {
			int sum = 0;
			for(int j = 0; j < length; j++) {
				sum += graph[i][j];
			}
			if(node.vertexSum > sum) {
				node.nodeId = i;
				node.vertexSum = sum;
			}
		}
		return node;
	}
	
	
	private static void initGraph(int graph[][]) {
		for(int i = 0; i< graph.length;i++) {
			for(int j = 0; j < graph[i].length; j++) {
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	private static void makeShotestPath(int graph[][]) {
		int length = graph.length;
		for(int k = 0; k < length; k++) {
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j]) graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
	}

}
