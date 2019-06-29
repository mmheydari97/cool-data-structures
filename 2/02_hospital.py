import queue

n, k, m = (int(x) for x in input().split(" "))

cost = [None for _ in range(n)]
q = queue.Queue(maxsize=n)
connections = {i: [] for i in range(n)}
hospitals = (int(x)-1 for x in input().split(" "))

for h in hospitals:
    cost[h] = 0
    q.put(h)

for _ in range(m):
    u, v = (int(x)-1 for x in input().split(" "))
    connections[u].append(v)
    connections[v].append(u)

while not q.empty():

    u = q.get()
    for a in connections[u]:

        if u in connections[a]:
            try:
                connections[a].remove(u)
            except:
                pass
        if cost[a] is None:
            cost[a] = cost[u] + 1
            q.put(a)

    connections[u] = []

for i, c in enumerate(cost):
    if c is None:
        cost[i] = n

for i in cost:
    print(i, end=" ")
