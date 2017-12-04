const fs = require('fs')
const rl = require('readline')
const readStream = fs.createReadStream('./input.txt')
const readOptions = {
  input: readStream,
  output: null,
  console: false
}
let finalResultCount = 0
let lineCount = 0
rl.createInterface(readOptions)
  .on('line', onLine)
  .on('close', onClose)

function onClose () {
  console.log(`Result: ${finalResultCount} of ${lineCount} lines match.`)
}

function onLine (line) {
  let pws = {}
  let fail = false

  let words = line.split(' ')
  lineCount++
  for (word of words) {
    if (pws[word]) {
      fail = true
      break
    } else {
      pws[word] = true
    }
  }
  if (!fail) {
    finalResultCount++
  }
}
