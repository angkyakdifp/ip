package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void mark() {
        isDone = true;
    }
    public void unmark() {
        isDone = false;
    }
    public String getInput() {
        return "";
    }
    @Override
    public String toString() {
        return " [" + this.getStatusIcon() + "] " + this.description;
    }
}