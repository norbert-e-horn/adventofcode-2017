import sys
l = sys.argv[1]
n = len(l)
print(sum([int(l[i]) for i in range(0,n) if l[i]==l[(i+1)%n]]))
print(sum([int(l[i]) for i in range(0,n) if l[i]==l[(i+n//2)%n]]))
