let l = CommandLine.arguments[1]
var sum = 0;
for i in 0..<l.count {
    if (l[l.index(l.startIndex, offsetBy: i)] == l[l.index(l.startIndex, offsetBy: (i+1)%l.count)]) {
        sum  += Int(String(l[l.index(l.startIndex, offsetBy: i)]))!
    }
}
print(sum)

sum = 0;
for i in 0..<l.count {
    if (l[l.index(l.startIndex, offsetBy: i)] == l[l.index(l.startIndex, offsetBy: (i+l.count/2)%l.count)]) {
        sum  += Int(String(l[l.index(l.startIndex, offsetBy: i)]))!
    }
}
print(sum)
