import sys,itertools
l=sys.argv[1].split("\n")
print(sum([max(k)-min(k)for k in[[int(j)for j in i.split("\t")]for i in l]]))
print(sum([[b[0]/b[1]for b in itertools.permutations([int(j)for j in i.split("\t")],2)if b[0]%b[1]==0][0]for i in l]))
