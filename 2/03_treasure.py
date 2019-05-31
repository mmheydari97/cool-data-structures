n, q = (int(x) for x in input().split(" "))

flags = [True for _ in range(n)]
connections = {i: [] for i in range(n)}
res = list()

for j in range(n-1):
    u, v = (int(x)-1 for x in input().split(" "))

    connections[u].append(v)
    connections[v].append(u)


for k in range(q):
    u, v = (int(x)-1 for x in input().split(" "))
    if flags[u]:
        connections[u].remove(v)
        connections[v].remove(u)
        stack = [u]

        while len(stack) != 0:
            w = stack.pop()
            flags[w] = False
            for a in connections[w]:
                connections[a].remove(w)
                stack.append(a)
            connections[w] = set()
    res.append(sum(flags))

for r in res:
    print(r)
