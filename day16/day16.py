import sys
o=[chr(97+k)for k in range(16)]
for j in range(1000000000%36):
	for i in sys.argv[1].split(","):
		p=i[1:].split("/")
		if i[0]=="s":
			t=int(p[0])
			o=o[-t:]+o[:-t]
		else:
			s,t=map(int if i[0]=="x"else o.index,p)
			o[s],o[t]=o[t],o[s]
	if not j:print("".join(o))
print("".join(o))
