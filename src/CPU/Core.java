package CPU;

import Process.Task;
import Resourses.ResourceManager;
import Scheduler.SchedulerAlgorithm;

public class Core extends Thread {
    public String name;
    int time = 0;
    private int idleTime = 0;
    private Task activeTask;
    private SchedulerAlgorithm algorithm;
    private int quantum = 1;
    private int taskQuantum = 0;
    private ResourceManager resourceManager;

    public Core() {
        resourceManager = ResourceManager.getInstance();
    }

    @Override
    public void run() {
        while (!CPU.finish) {

        }
    }

    void doTask() {
        switch (algorithm) {
            case RR:
                doTaskWithQuantum();
                break;
            case SJF:
            case HRRN:
            case FCFS:
                doTaskWithoutQuantum();
                break;
        }
        checkTaskStatus();
    }

    public void checkTaskStatus() {
        // if the task was IDLE
        if (activeTask == null) {
            return;
        }
        //age RR bud
        if (algorithm == SchedulerAlgorithm.RR) {
            //if its quantum be finished
            if (taskQuantum == quantum) {
                resourceManager.freeResources(activeTask);
                CPU.waitingScheduler.schedule();
                taskQuantum = 0;
                // hala k b quantum resid if done or not
                if (!activeTask.isDone()) {
                    QueueManager.getInstance().addToReadyQueue(activeTask);
                }
                activeTask = null;
            }
        // age RR nabud
        } else if (activeTask.isDone()) {
            resourceManager.freeResources(activeTask);
            CPU.waitingScheduler.schedule();
            activeTask = null;
            taskQuantum = 0;
        }
    }

    private void doTaskWithoutQuantum() {
        activeTask.setProcessTime(activeTask.getProcessTime() + 1);
    }

    private void doTaskWithQuantum() {
        if (!activeTask.isDone()) {
            activeTask.setProcessTime(activeTask.getProcessTime() + 1);
        }
        taskQuantum++;
    }


    public int getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public boolean isFree() {
        return activeTask == null;
    }

    public void assignTask(Task task) {
        this.activeTask = task;
    }

    public SchedulerAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(SchedulerAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

   /* public int getQuantum() {
        return quantum;
    }
*/
    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public Task getActiveTask() {
        return activeTask;
    }

    public void setActiveTask(Task activeTask) {
        this.activeTask = activeTask;
    }

    @Override
    public String toString() {
        String temp = this.name + " : ";
        temp += activeTask == null ? "Idle" : activeTask.getName();
        return temp;
    }

}

