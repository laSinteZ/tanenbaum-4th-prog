/*assuming we have a concrete number of prcesses.
id of every process is one of the nubers from 0 to number of processes.*/
void processDoWork(int id, int n_pocesses, int *turn){
	while(TRUE){
		while(turn!=id)
			critical_region();
		if(id<n_pocesses)
			(*turn) = id;
		else 
			(*turn) = 0;
		noncritical_region();
	}
}

void critical_region(){
	sleep(1);
}

void noncritical_region(){
	sleep(10);
}