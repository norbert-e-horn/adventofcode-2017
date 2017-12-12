import Foundation
let a=CommandLine.arguments[1]
let m = a.split(separator: "\n")//.map{String($0)}
var k: [[Int]] = []
for i in m {
    let c = i.split(separator: " ")
    var p = [Int(c[0])!]
    for j in 2..<c.count {
        p.append(Int(String(c[j]).replacingOccurrences(of: ",", with: ""))!)
    }
    k.append(p)
}
var r:[Set<Int>] = []
while k.count>0 {
    var l = Set(k[0])
    var c = true
    while c {
        c = false
        var j = 0
        while j<k.count {
            var add = false
            for g in k[j] {
                if l.contains(g){
                    add = true
                }
            }
            if !add {
                j+=1
                continue
            }
            l.formUnion(k[j])
            k.remove(at: j)
            c = true
            
        }
    }
    r.append(l)
}
for i in r {
    if i.contains(0) {
        print(i.count)
        break
    }
}
print(r.count)
