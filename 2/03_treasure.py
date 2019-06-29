import queue
n, q = (int(x) for x in input().split(" "))

flags = [True for _ in range(n)]
connections = {i: [] for i in range(n)}
res = list()
stack = queue.LifoQueue(maxsize=n)

for j in range(n-1):
    u, v = (int(x)-1 for x in input().split(" "))

    connections[u].append(v)
    connections[v].append(u)


for k in range(q):
    u, v = (int(x)-1 for x in input().split(" "))
    if flags[u]:
        connections[u].remove(v)
        connections[v].remove(u)
        stack.put(u)

        while not stack.empty():
            w = stack.get()
            flags[w] = False
            for a in connections[w]:
                connections[a].remove(w)
                stack.put(a)
            connections[w] = set()
    res.append(sum(flags))

for r in res:
    print(r)
