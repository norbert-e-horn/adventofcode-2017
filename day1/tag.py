f = open("input.txt")
l = f.read()
print( sum([int(l[i]) for i in range (0,len(l)) if l[i]==l[(i+1)%len(l)]]))
print( sum([int(l[i]) for i in range (0,len(l)) if l[i]==l[(i+len(l)/2)%len(l)]]))