#!/bin/bash 

#create the numbers file                                                   
if test ! -f 257_numbers
then
    echo 0 > 257_numbers
fi

#Just locks and don't let others interrupt :)
if ln 257_numbers 257_numbers.lock
	then                                                                    
	#Repeat 100 times to see fun
	for i in `seq 1 100`;
	do
		#Read and increase last number
		LASTNUMBER=`tail -1 257_numbers`
		LASTNUMBER=$((LASTNUMBER+1))

		echo $LASTNUMBER >> 257_numbers
	done

	#Unlock
	rm 257_numbers.lock
fi
