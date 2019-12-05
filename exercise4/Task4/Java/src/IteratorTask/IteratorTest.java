package IteratorTask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class IteratorTest {

	@Test
	void test() {
		Graph g = new Graph();
			
		ArrayList<Edge> actual = new ArrayList<Edge>();
		actual.add(new Edge(0, 1));
		actual.add(new Edge(0, 2));
		actual.add(new Edge(2, 1));
		actual.add(new Edge(3, 1));
		actual.add(new Edge(2, 3));
		
		for (Edge e : actual) {
			g.addEdge(e);
		}
		
		Collections.sort(actual);
		
		
		ArrayList<Edge> expected = new ArrayList<Edge>();
		for(Edge e : g) {
			expected.add(e);
		}
		
		Collections.sort(expected);
		
		assertEquals(actual.size(),expected.size());
		assertArrayEquals(actual.toArray(),expected.toArray());
		 
		
		
	}

}
