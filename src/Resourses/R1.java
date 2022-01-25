package Resourses;

public class R1 extends Resource {
    public R1(){
        super();
        setName(this.getClass().getName());
        setResourceType(ResourceType.R1);
    }
}
