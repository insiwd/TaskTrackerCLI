package org.example.model;

public enum TaskStatus {

    TODO("todo"),
    IN_PROGRESS("in progress"),
    DONE("done");

    private final String label;

    private TaskStatus(String label) {
        this.label = null;
    }

    public String getLabel() {
        return label;
    }
}
