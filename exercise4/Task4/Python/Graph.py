import unittest
"""
Class representing Graph structure. 
"""

class Graph(object):
	def __init__(self):
		#data structure representing vertices and their respective edges
		self.__vertex_edge_map = {}

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

