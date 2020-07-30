import java.util.*;
import java.lang.Integer;

public class Graph<V> implements GraphInterface<V>  {

	/** Construct an empty */
	public Graph() {
	}


	/** Create and returns an adjacency lists from edge arrays */
	public List<List<Edge>> createWeightedGraph(List<V> vertices, int[][] edges) {

		List<List<Edge>> neighbors = new ArrayList<>();

	

		for(int j =0; j< edges.length; j++) 
		{
			Edge instantEdge= new Edge(edges[j][0],edges[j][1],edges[j][2]);
			//push instantEdge in neighbors[edges[j][0]]
			
			boolean flag1=true;
			//from edges[j][0] to edges[j][1] cost edges[j][2]
			
			int i1=0;
			if(edges[j][0] < neighbors.size())
			{
				for (; i1 < neighbors.get(edges[j][0]).size(); i1++) {
					
					if (instantEdge.v < neighbors.get(edges[j][0]).get(i1).v) {
						break;//now we found where instantEdge must go.
					}
				}
				neighbors.get(edges[j][0]).add(i1,instantEdge);// put it between ione and ione-1
			}
			else
			{
				if(edges[j][0]==neighbors.size())//only work if edges[j][0] start with 1,2,3
				{
					List<Edge> edgeList= new ArrayList<Edge>();
					neighbors.add(edgeList);
					neighbors.get(edges[j][0]).add(i1, instantEdge);//ione is 0
				}
				else
				{
					System.out.println("not ordered edges error");
					System.exit(1);
				}
			}

		}
		for(int i=0; i< vertices.size(); i++)
		{
			neighbors.get(i).add(0,new Edge(i,i,0));
		}

		return neighbors;
	}




	/** Find single source shortest paths */
	public Tree getShortestPath(V sourceVertex,List<V> vertices,List<List<Edge>> neighbors) {


		int root = ((String)sourceVertex).charAt(0)-'A';
		int[] parent = new int[vertices.size()];
		double[] cost = new double[vertices.size()];
		Tree answer = new Tree(root, parent, cost);

		for (int i = 0; i < cost.length; i++) {
			cost[i] = Double.POSITIVE_INFINITY;
		}

		cost[root] = 0; // Cost of source is 0

		// parent[v] stores the previous vertex of v in the path
		parent[root] = -1; // The parent of source is set to -1


		List<Integer> T = new ArrayList<>();
		int nowIamhere = root;
		T.add(nowIamhere);

		boolean areWeDone = false;
		while (!areWeDone) {

			for (int i = 0; i < neighbors.get(nowIamhere).size(); i++)
			{
				
				if (cost[nowIamhere] + neighbors.get(nowIamhere).get(i).weight < cost[neighbors.get(nowIamhere).get(i).v]) {
					cost[neighbors.get(nowIamhere).get(i).v] = cost[nowIamhere] + neighbors.get(nowIamhere).get(i).weight;
					parent[neighbors.get(nowIamhere).get(i).v] = nowIamhere;
				}
			}
			double smallest = Double.POSITIVE_INFINITY;
			double whatisthesmallest = root;

			//check all the cost and find the smallest cost.
			//the vertice that has the smallest cost will be nowIamhere



			boolean flag = true;// if there is any vertices still left, it becomes false

			for(int i = 0;i < vertices.size();i++) {
				if (cost[i] < smallest && !T.contains(i)) {
					smallest = cost[i];
					whatisthesmallest = i;
					flag = false;
				}
			}
			if (flag)
				return answer;
			else {
				nowIamhere = (int)whatisthesmallest;
				T.add(nowIamhere);
			}
		}
		System.out.println("Error");
		return answer;
	}




	/** Edge inner class inside the Graph class */
	/*EDGE CLASS STORES THE EDGE SUCH THAT u AND v ARE THE TWO VERTEX CONNECTED BY THE EDGE AND
	 * weight IS THE WEIGHT OF THE EDGE
	 * */
	public class Edge {
		public int u; // Starting vertex of the edge
		public int v; // Ending vertex of the edge
		public double weight; //Weight of the edge
		/** Construct an edge for (u, v, weight) */
		public Edge(int u, int v, double weight) {
			this.u = u; //Important
			this.v = v;
			this.weight=weight;
		}


	}


	/** Tree inner class inside the Graph class */
	/*TREE CLASS STORES THE TREE SUCH THAT root IS THE ROOT NODE OF TREE (i.e. sourceVertex FOR SHORTEST DISTANCE TREE)
	 * parent[i] STORES THE PARENT OF NODE i IN THE TREE
	 * NOTE: PARENT OF root is -1 (i.e. parent[root]=-1
	 * cost[i] is COST OF PATH FROM root (i.e. sourceVertex) to Node i
	 * */
	public class Tree {
		private int root; // The root of the tree
		private int[] parent; // Store the parent of each vertex, Parent of root node is -1
		private double[] cost; // cost of each vertex from root i.e. source


		/** Construct a tree with root, parent, cost */
		public Tree(int root, int[] parent,double[] cost) {
			this.root = root;//Important
			this.parent = parent;
			this.parent[root]=-1;
			this.cost = cost;
		}

		/** Return the root of the tree */
		public int getRoot() {
			return root;//Important
		}


		/** Return the path of vertices from a vertex to the root */
		public List<V> getPath(int index,List<V> vertices) {
			ArrayList<V> path = new ArrayList<>();//Important

			do {
				path.add(vertices.get(index));
				index = parent[index];
			}
			while (index != -1);

			return path;
		}

		/** Print a path from the root to vertex v */
		public void printPath(int index,List<V> vertices) {
			List<V> path = getPath(index,vertices); //Important
			System.out.print("A path from " + vertices.get(root) + " to " +
					vertices.get(index) + ": ");
			for (int i = path.size() - 1; i >= 0; i--)
				System.out.print(path.get(i) + " ");
		}


		/** Print paths from all vertices to the source */
		public void printAllPaths(List<V> vertices) {
			System.out.println("All shortest paths from " +
					vertices.get(getRoot()) + " are:");//Important
			for (int i = 0; i < cost.length; i++) {
				printPath(i,vertices); // Print a path from i to the source
				System.out.println("(cost: " + cost[i] + ")"); // Path cost
			}
		}

	}


}