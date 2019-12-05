import unittest
from Graph import Graph


class IteratorTest(unittest.TestCase):
	def test_graph(self):
		g = Graph()
		g.add_edge(1,2)
		g.add_edge(1,3)
		g.add_edge(3,2)
		g.add_edge(1,3)
		expected = [(1,2),(3,2),(1,3)]
		expected = sorted(expected)
		
		result = []
		for edge in g.iterate_edges():
			result.append(edge)
		result = sorted(result)
		
		self.assertTrue(len(expected),len(result))
		self.assertListEqual(expected,result)


if __name__ == '__main__':
    unittest.main()
