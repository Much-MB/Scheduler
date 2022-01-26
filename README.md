# Scheduler of process
## implementaion of the project:


##### our project has four packages  :
#### CPU - Process  - Resourses - scheduler

### CPU : 
this packages we have four classes one of them is CPU . in this class we manage the things that about cpu and cores .in procesing function we make some cores and we distribute the tasks between the cores .in this class we check the busy threads and we can execute the cores .

### Cores :
in this class we manage the things about cores .we set the core with the schedul algorthm that we want to use it. in _doTask()_ function we set it .if our algorithm is RR we should set a quantum but in outhe algoritm we dont set.in  _checkTaskStatus()_ we check the status of the tasks and if there is a task which is done we can free the resourses and in RR if its quantum isfinished we can put it in the waiting queue .and we have some functions manage the core such as : _getIdleTime()  setIdleTime(int idleTime) isFree()  assignTask(Task task)   SchedulerAlgorithm getAlgorithm()    setAlgorithm(SchedulerAlgorithm algorithm)    setQuantum(int quantum)  getActiveTask()_ . with these functions we can set and get the idle times and we can check is the core free or not and we can assign the task to the core and get the schedule algorithm .with last tow function we can set the quantom for RR schedule and we can get the active Tasks .
### printInfo :
this class is in the CPU package .in this class we print some information about our project .for example we can print the situation of queues .

### time :
this class is in the CPU package .in this class we mange the time we can get the current time and increse the time .
### QueueManager :
this class is in the CPU package .in this class we have some function to mamnage waiting and redy queues .in this class we some get and set function to do som jobs like set and get the time or set and get the tasks from queues etc. 

### Task :
this class is in the process package. int this class we some get and set functiona about its name , arrival time , burst time .we should set the its priority beacuse in the schuedule we should give a priority to our task .we have set and get function about the resourses each task will get .we have afunction that give us the time that the task have waited in wating queue and than thre is function that told us is the task is done or not and give us the status of the task .

### X , Y , Z : 
these classes are in the process package .we have 3 clasess that that expand Task .we have three type of task :X , Y , Z. each type of task beside the general functions have some special functions .each type of task can get some special resurses.x Tasks can only get R1 & R2.
Y Tasks : R2 & R3 . Z Tasks : R1 & R3 .
### Resources : 
in this class we represent the feacthers of each resourse . each resurce has a name , type . and we have get and set function for this class.
### R1 , R2 , R3 : 
these classes expand the resource class .they have jast a constractor that get us the type of resource.
 ### ResourceManager : 
in this class we mannage the resources.we have the number of each resource and this class we can add some resources , we can assign the resourses to the tasks , we canfree some resources and when we do these the affect of these function will be manage by this class .
### Resource Type : 
it is enum that represent the type of resources between R1 , R2 , R3 .
## Scheduler Package :
in this package we have a class its name is waiting forscheduling this class prapre the tasks .we have enum to represent the name of the algorithms .
and than we have schedule algorithms ._FCFS SJF HRRN RR_ are the algorithms that we use .

## How to work with the project?
if we want to run the project at first we should choose the schedul algorithm .and than we should enter the number of each resource.after  that we should detemine number of tasks . 
for each task we should enter its information .at first we should enter name of task and than type of the task and than number of resources the it wants .and than the program give us the information of processing.


