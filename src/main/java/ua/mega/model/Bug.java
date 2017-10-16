package ua.mega.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Bug.getAll", query = "select bug from Bug bug join fetch bug.assignee assignee join fetch  bug.reporter reporter"),
        @NamedQuery(name = "Bug.getById", query = "select bug from Bug bug left join fetch bug.assignee assignee left join fetch  bug.reporter reporter where bug.id = :id"),
        @NamedQuery(name = "Bug.getAllByAssignee", query = "select bug from Bug bug join fetch bug.assignee assignee join fetch  bug.reporter reporter where assignee.id = :id"),
        @NamedQuery(name = "Bug.getAllByReporter", query = "select bug from Bug bug join fetch bug.assignee assignee join fetch  bug.reporter reporter where reporter.id = :id")
})

@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @Enumerated(EnumType.STRING)
    private Resolution resolution;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "BUG_STATUS")
    private BugStatus bugStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private Person assignee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporter_id")
    private Person reporter;

    public Bug() {
    }

    public Bug(String name, Resolution resolution, Priority priority, BugStatus bugStatus, Person assignee, Person reporter) {
        this.name = name;
        this.resolution = resolution;
        this.priority = priority;
        this.bugStatus = bugStatus;
        this.assignee = assignee;
        this.reporter = reporter;
    }

    public Bug(Integer id, String name, Resolution resolution, Priority priority, BugStatus bugStatus, Person assignee, Person reporter) {
        this(name, resolution, priority, bugStatus, assignee, reporter);
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bug bug = (Bug) o;

        if (id != null ? !id.equals(bug.id) : bug.id != null) return false;
        if (name != null ? !name.equals(bug.name) : bug.name != null) return false;
        if (resolution != bug.resolution) return false;
        if (priority != bug.priority) return false;
        if (bugStatus != bug.bugStatus) return false;
        if (assignee != null ? !assignee.equals(bug.assignee) : bug.assignee != null) return false;
        return reporter != null ? reporter.equals(bug.reporter) : bug.reporter == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (resolution != null ? resolution.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (bugStatus != null ? bugStatus.hashCode() : 0);
        result = 31 * result + (assignee != null ? assignee.hashCode() : 0);
        result = 31 * result + (reporter != null ? reporter.hashCode() : 0);
        return result;
    }
}
