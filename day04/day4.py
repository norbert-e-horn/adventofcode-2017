import sys,itertools
s=lambda x:len([z for z in sys.argv[1].split("\n")if len([i for i in itertools.permutations(z.split(" "),2)if x(i[0])==x(i[1])])==0])
print(s(lambda x:x))
print(s(sorted))
