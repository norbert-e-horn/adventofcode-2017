var a = CommandLine.arguments[1].split(separator: "\t").map {Int($0)!}
var d = [String: Int]()
var z = 0
while d[a.description] == nil {
    d[a.description] = z
    var max = 0
    for i in 0..<a.count {
        if a[i]>a[max] {
            max = i
        }
    }
    let v = a[max]
    a[max] = 0
    for i in 1...v {
        a[(max + i) % a.count] += 1
    }
    z += 1
}
print(z)
print(z - d[a.description]!)
