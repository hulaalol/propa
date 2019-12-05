package IteratorTask;

public class Edge implements Comparable<Edge>{
	private int source;
	private int destination;
	
	public Edge(int vert1,int vert2)
	{
		source = vert1;
		destination = vert2;
	}
	
	public int getSource() {
		return source;
	}
	
	public int getDestination() {
		return destination;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o ==  null){
			return false;
		}
		
		if (!(o instanceof Edge) ) {
			return false;
		}
		
		Edge  other = (Edge) o;
		boolean edgesEqual =(this.source == other.source && this.destination == other.destination);
		return edgesEqual;
		
	}

	@Override
	public int compareTo(Edge o) {
		int c= Integer.compare(this.source, o.source);
				
		if (c!=0) {
			return c;
		}
		return Integer.compare(this.destination, o.destination);
		
	}
	
}
