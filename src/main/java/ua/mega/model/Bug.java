package ua.mega.model;

public class Bug {
    private Integer id;
    private String name;
    private Resolution resolution;
    private Priority priority;
    private BugStatus bugStatus;

    private Person assignee;
    private Person reporter;

    public Bug() {
    }

    public Bug(Integer id, String name, Resolution resolution, Priority priority, BugStatus bugStatus, Person reporter) {
        this.id = id;
        this.name = name;
        this.resolution = resolution;
        this.priority = priority;
        this.bugStatus = bugStatus;
        this.reporter = reporter;
    }

    public Bug(Integer id, String name, Resolution resolution, Priority priority, BugStatus bugStatus, Person assignee, Person reporter) {
        this(id, name, resolution, priority, bugStatus, reporter);
        this.assignee = assignee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public BugStatus getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(BugStatus bugStatus) {
        this.bugStatus = bugStatus;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public Person getReporter() {
        return reporter;
    }

    public void setReporter(Person reporter) {
        this.reporter = reporter;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resolution=" + resolution +
                ", priority=" + priority +
                ", bugStatus=" + bugStatus +
                ", assignee=" + assignee +
                ", reporter=" + reporter +
                '}';
    }
}
