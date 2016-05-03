#!/bin/bash                                                                       

#run 2 programs at same time and see race condition
sh 257_race.sh &
sh 257_race.sh
