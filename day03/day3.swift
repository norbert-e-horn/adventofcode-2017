let target = 277678
var z:Int = 1, i=0
out: while(true) {
    i += 1
    z+=1
    if (z==target) {
        print(2*i-1)
        break out
    }
    let p = (i+1)*2-1
    for x in 1..<p/2+i {
        z+=1
        if (z==target) {
            print(2*i-1-x)
            break out
        }
    }
    let x = p/2+i-1
    for y in 1..<p {
        z+=1
        if (z==target) {
            print(2*i-1-x-y)
            break out
        }
    }
    let y = p-1
    for x2 in 1..<p{
        z+=1
        if (z==target) {
            print(2*i-1-x-y+x2)
            break out
        }
    }
    let x2 = p-1
    for y2 in 1..<p {
        z+=1
        if (z==target) {
            print(2*i-1-x-y+x2+y2)
            break out
        }
    }
}
let max = 11
var s=[max/2-1,max/2]
var m = Array(repeating: Array(repeating: 0, count:max), count: max)
m[s[0]+1][s[1]] = 1
func arround(x:Int,y:Int) -> Int {
    var z = 0
    for i in -1...1 {
        for j in -1...1 {
            z += m[x-i][y-j]
        }
    }
    m[x][y] = z
    return z
}
i = 0
out: while(true) {
    i += 1
    s[0] += 1
    var k = arround(x:s[0],y:s[1]+i)
    if (k>target) {
        print(k)
        break out
    }
    let p = (i+1)*2-1
    for x in 1..<p/2+i {
        k = arround(x:s[0]-x,y:s[1]+i)
        if (k>target) {
            print(k)
            break out
        }
    }
    let x = p/2+i-1
    for y in 1..<p {
        k = arround(x:s[0]-x,y:s[1]+i-y)
        if (k>target) {
            print(k)
            break out
        }
    }
    let y = p-1
    for x2 in 1..<p{
        k = arround(x:s[0]-x+x2,y:s[1]+i-y)
        if (k>target) {
            print(k)
            break out
        }
    }
    let x2 = p-1
    for y2 in 1..<p {
        k = arround(x:s[0]-x+x2,y:s[1]+i-y+y2)
        if (k>target) {
            print(k)
            break out
        }
    }
}

