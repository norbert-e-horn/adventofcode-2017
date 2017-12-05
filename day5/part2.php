<?php
/**
 * Created by PhpStorm.
 * User: Norbert E. Horn
 * Date: 05.12.17
 * Time: 09:40
 */
$filename = "./input.txt";
$lines = file($filename, FILE_IGNORE_NEW_LINES);
$currentPosition = 0;
$step = 0;
$hasFinished = false;
while(!$hasFinished){
    if(!array_key_exists($currentPosition,$lines)) {
        $hasFinished = true;
        break;
    }
    $steps = $lines[$currentPosition];
    if($steps>=3)
        $increaser = -1;
    else
        $increaser = 1;
    $lines[$currentPosition]+=$increaser;
    $currentPosition += $steps;
    $step++;

}
echo "## Steps needed: $step ## ";
