console.log "### START Part2 ###"

history = {}

writeHistory = (values, neededSteps)->
  if history[values.join '-']?
    return history[values.join '-']
  else
    history[values.join '-'] = neededSteps
    return -1

value =[5,1,10,0,1,7,13,14,3,12,8,10,7,12,0,6]
#value = [0, 2, 7, 0] # test input
steps = 0
while writeHistory(value,steps)<0
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


console.log "RESULT PART2: ", steps-writeHistory(value,steps)
