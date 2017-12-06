console.log "### START Part1 ###"

history = {}

writeHistory = (values)->
  if history[values.join '-']?
    return false
  else
    history[values.join '-'] = true
    return true

value =[5,1,10,0,1,7,13,14,3,12,8,10,7,12,0,6]
#value = [0, 2, 7, 0] # test input
steps = 0
while writeHistory(value)
  steps++
  maxValue = Math.max.apply(null, value)
  maxIndex = value.indexOf(maxValue)
  #console.log maxValue, " in ", value, " at pos ", maxIndex
  # reset value to 0
  value[maxIndex] = 0
  while maxValue>0
    maxIndex= ++maxIndex%value.length
    value[maxIndex]++
    maxValue--
  #console.log "Steps: ", steps, " - > ", maxValue, " in ", value, " at pos ", maxIndex


console.log "RESULT PART1: ", steps
