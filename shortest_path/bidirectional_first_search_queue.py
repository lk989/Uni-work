# Class definition for node to
class AdjacentNode:

    def __init__(self, vertex):
        self.vertex = vertex
        self.next = None


# BidirectionalSearch implementation
class BidirectionalSearch:

    def __init__(self, vertices):

        # Initialize vertices and
        # graph with vertices
        self.vertices = vertices
        self.graph = [None] * self.vertices

        # Initializing queue for forward
        # and backward search
        self.src_queue = list()
        self.dest_queue = list()

        # Initializing source and
        # destination visited nodes as False
        self.src_visited = [False] * self.vertices
        self.dest_visited = [False] * self.vertices

        # Initializing source and destination
        # parent nodes
        self.src_parent = [None] * self.vertices
        self.dest_parent = [None] * self.vertices

    # Function for adding undirected edge
    def add_edge(self, src, dest):

        # Add edges to graph

        # Add source to destination
        node = AdjacentNode(dest)
        node.next = self.graph[src]
        self.graph[src] = node

        # Since graph is undirected add
        # destination to source
        node = AdjacentNode(src)
        node.next = self.graph[dest]
        self.graph[dest] = node

    # Function for Breadth First Search
    def bi_fs(self, direction='forward'):

        if direction == 'forward':

            # Bi-FS in forward direction
            current = self.src_queue.pop(0)
            connected_node = self.graph[current]

            while connected_node:
                vertex = connected_node.vertex

                if not self.src_visited[vertex]:
                    self.src_queue.append(vertex)
                    self.src_visited[vertex] = True
                    self.src_parent[vertex] = current

                connected_node = connected_node.next
        else:

            # Bi-FS in backward direction
            current = self.dest_queue.pop(0)
            connected_node = self.graph[current]

            while connected_node:
                vertex = connected_node.vertex

                if not self.dest_visited[vertex]:
                    self.dest_queue.append(vertex)
                    self.dest_visited[vertex] = True
                    self.dest_parent[vertex] = current

                connected_node = connected_node.next

    # Check for intersecting vertex
    def is_intersecting(self):

        # Returns intersecting node
        # if present else -1
        for i in range(self.vertices):
            if (self.src_visited[i] and
                    self.dest_visited[i]):
                return i

        return -1

    # Print the path from source to target
    def print_path(self, intersecting_node, src, dest):

        # Print final path from
        # source to destination
        path = list()
        path.append(intersecting_node)
        i = intersecting_node

        while i != src:
            path.append(self.src_parent[i])
            i = self.src_parent[i]

        path = path[::-1]
        i = intersecting_node

        while i != dest:
            path.append(self.dest_parent[i])
            i = self.dest_parent[i]

        print("*****Path*****")
        path = list(map(str, path))
        print(' '.join(path))

    # Function for bidirectional searching
    def bidirectional_search(self, src, dest):
        # Add source to queue and mark
        # visited as True and add its
        # parent as -1
        self.src_queue.append(src)
        self.src_visited[src] = True
        self.src_parent[src] = -1

        # Add destination to queue and
        # mark visited as True and add
        # its parent as -1
        self.dest_queue.append(dest)
        self.dest_visited[dest] = True
        self.dest_parent[dest] = -1

        while self.src_queue and self.dest_queue and self.is_intersecting() == -1:

            # BFS in forward direction from
            # Source Vertex
            self.bi_fs(direction='forward')

            # BFS in reverse direction
            # from Destination Vertex
            self.bi_fs(direction='backward')

            # Check for intersecting vertex
            intersecting_node = self.is_intersecting()

            # If intersecting vertex exists
            # then path from source to
            # destination exists
            if intersecting_node != -1:
                print(f"A Path does exist between {src} and {dest}")
                print(f"The intersection point is: {intersecting_node}")
                self.print_path(intersecting_node,
                                src, dest)

        return self.is_intersecting()