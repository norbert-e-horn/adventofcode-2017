import Foundation
let a=CommandLine.arguments[1]
let n = 256
var k = a.split(separator: ",").map {Int($0)!}
var l = Array(0..<n)
var p = 0
var s = 0
func d() {
    for i in k {
        l = Array(l.suffix(l.count-p)) + Array(l.prefix(p))
        l = Array(l.prefix(i).reversed()) + Array(l.suffix(l.count-i))
        l = Array(l.suffix(p)) + Array(l.prefix(l.count-p))
        p = (p+s+i)%n
        s += 1
    }
}
d()
print(l[0]*l[1])
k = a.unicodeScalars.map{Int($0.value)}
k += [17,31,73,47,23]
l = Array(0..<n)
p = 0
s = 0
for _ in 0..<64 {
    d()
}
var nums = Array(0..<16)
nums = nums.map{l[$0*16..<($0+1)*16].reduce(0, {x,y in x^y})}
print(nums.map{String(format:"%02x", $0)}.reduce("",{x,y in x + y}))
