package Resourses;

import Process.Task;

import java.util.ArrayList;

public class ResourceManager {
    private static ResourceManager resourceManager = new ResourceManager();
    private ArrayList<Resource> resources = new ArrayList<>();
    private int R1AvailableCount = 0;
    private int R2AvailableCount = 0;
    private int R3AvailableCount = 0;

    public static ResourceManager getInstance(){
        return resourceManager;
    }

    private ResourceManager(){

    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void printResource(){
        System.out.println("available -> R1 :"+ R1AvailableCount+ " R2 :"+R2AvailableCount+" R3 :"+R3AvailableCount);
    }

    public void countingResources() {
        for (Resource resource : resources) {
            switch (resource.getResourceType()) {
                case R1:
                    R1AvailableCount++;
                    break;
                case R2:
                    R2AvailableCount++;
                    break;
                case R3:
                    R3AvailableCount++;
                    break;
            }
        }
    }
    // if resource hast
    public synchronized boolean assignResources(Task task) {
        int aR = 0;
        int bR = 0;
        int cR = 0;
        for (ResourceType resourceType : task.getResources()) {
            switch (resourceType) {
                case R1:
                    aR++;
                    if (R1AvailableCount == 0) {
                        return false;
                    }
                    break;
                case R2:
                    bR++;
                    if (R2AvailableCount == 0) {
                        return false;
                    }
                    break;
                case R3:
                    cR++;
                    if (R3AvailableCount == 0) {
                        return false;
                    }
                    break;
            }
        }

        if(R1AvailableCount - aR>=0 && R2AvailableCount - bR>=0 && R3AvailableCount - cR>=0){
            R1AvailableCount -= aR;
            R2AvailableCount -= bR;
            R3AvailableCount -= cR;
            return true;
        }
        return false;

    }

    public synchronized void freeResources(Task task){
        int aR = 0;
        int bR = 0;
        int cR = 0;
        for (ResourceType resourceType : task.getResources()) {
            switch (resourceType) {
                case R1:
                    aR++;
                    break;
                case R2:
                    bR++;
                    break;
                case R3:
                    cR++;
                    break;
            }
        }
        R1AvailableCount += aR;
        R2AvailableCount += bR;
        R3AvailableCount += cR;
    }
    // age hast , faqat check
    public synchronized boolean canBeAssign(Task task) {
        int aR = 0;
        int bR = 0;
        int cR = 0;
        for (ResourceType resourceType : task.getResources()) {
            switch (resourceType) {
                case R1:
                    aR++;
                    if (R1AvailableCount == 0) {
                        return false;
                    }
                    break;
                case R2:
                    bR++;
                    if (R2AvailableCount == 0) {
                        return false;
                    }
                    break;
                case R3:
                    cR++;
                    if (R3AvailableCount == 0) {
                        return false;
                    }
                    break;
            }
        }

        return R1AvailableCount - aR >= 0 && R2AvailableCount - bR >= 0 && R3AvailableCount - cR >= 0;
    }
}
