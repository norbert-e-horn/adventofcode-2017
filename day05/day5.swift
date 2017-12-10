var a = CommandLine.arguments[1].split(separator: "\n").map {Int($0)!}
var i = 0, s = 0
while i<a.count {
    let n = a[i]
    a[i] += 1
    i += n
    s += 1
}
print(s)

a = CommandLine.arguments[1].split(separator: "\n").map {Int($0)!}
i = 0
s = 0
while i<a.count {
    let n = a[i]
    a[i] += (n<3 ? 1 : -1)
    i += n
    s += 1
}
print(s)
