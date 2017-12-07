import Foundation
var a = CommandLine.arguments[1].split(separator: "\n")
class Element {
    var value:Int
    var tops:[String]
    init(v:Int,t:[String]) {
        self.value=v
        self.tops=t
    }
}
var d = [String: Element]()
var m = [String]()
for l in a {
    let c = l.split(separator: " ")
    var r = [String]()
    if c.count>3 {
        for i in 3..<c.count {
            r.append(String(c[i]).replacingOccurrences(of: ",", with: ""))
        }
    }
    d[String(c[0])] = Element(v:Int(c[1].replacingOccurrences(of: "[()]", with: "",options: .regularExpression))!,t:r)
    m.append(contentsOf:r)
    
}
for k in d {
    if !(m.contains(k.key)) {
        print(k.key)
    }
}
var all = [String: Int]()
end: while true {
    out: for l in d {
        for i in l.value.tops {
            if !all.contains{$0.key==i} {
                continue out
            }
        }
        all[l.key] = l.value.value
        var sums:[Int] = []
        for i in l.value.tops {
            all[l.key] = all[l.key]! + all[i]!
            sums.append(all[i]!)
        }
        if Set(sums).count>1 {
            theOne: for i in l.value.tops {
                var dif = 0
                for j in l.value.tops {
                    if i != j {
                        if all[i] == all[j] {
                            continue theOne
                        }
                        dif = all[j]! - all[i]!
                    }
                }
                print(d[i]!.value + dif)
                break end
            }
        }
    }
}
