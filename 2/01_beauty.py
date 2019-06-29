string = input()
q = int(input())
res = []

for _ in range(q):
    u, v = (int(x)-1 for x in input().split(" "))
    l = v-u
    for i, ch in enumerate(string[u: v]):
        print(ch == string[i])
