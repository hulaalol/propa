import unittest
"""
Class representing Graph structure. 
"""

class Graph(object):

	def __init__(self):
		#data structure representing vertices and their respective edges
		self.__vertex_edge_map = {}
		self.sources = []
		self.destinations = []
		self.nextSource = -1

	def __iter__(self):
		for k,v in self.__vertex_edge_map.items():
			self.sources.append(k)
		return self

	def __next__(self):
		if len(self.sources) ==0 and len(self.destinations) == 0:
			raise StopIteration
		while len(self.destinations) == 0:
			self.nextSource = self.sources.pop()
			self.destinations = self.__vertex_edge_map[self.nextSource]
		return (self.nextSource, self.destinations.pop())

	def iterate_edges(self):
		return self

	def add_vertex(self,vertex):
		""" adds a new vertex to the graph"""
		if vertex not in self.__vertex_edge_map:
			self.__vertex_edge_map[vertex] = []

	def add_edge(self,source,destination):
		""" creates a new edge between"""
		self.add_vertex(source)
		self.add_vertex(destination)
		if destination not in self.__vertex_edge_map[source]:
			self.__vertex_edge_map[source].append(destination)

