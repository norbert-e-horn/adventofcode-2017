var a = CommandLine.arguments[1].split(separator: "\n")

var d = [String: Int]()
var m = 0
for l in a {
    let c = l.split(separator: " ")
    
    let val = d[String(c[4])] ?? 0
    let comp = Int(c[6])!
    var isval = false
    switch c[5] {
    case "<":
        if val < comp {
            isval = true
        }
    case "<=":
        if val <= comp {
            isval = true
        }
    case ">":
        if val > comp {
            isval = true
        }
    case ">=":
        if val >= comp {
            isval = true
        }
    case "==":
        if val == comp {
            isval = true
        }
    case "!=":
        if val != comp {
            isval = true
        }
    default:
        isval = false
    }
    if (isval) {
         let target = String(c[0])
        if c[1] == "inc" {
            d[target] = (d[target] ?? 0) + Int(c[2])!
        }
        else {
            d[target] = (d[target] ?? 0) - Int(c[2])!
        }
        if d[target]! > m {
            m = d[target]!
        }
    }
}
print(d.max{ a, b in a.value < b.value }!.value)
print(m)
