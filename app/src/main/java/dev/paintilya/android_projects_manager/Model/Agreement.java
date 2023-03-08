package dev.paintilya.android_projects_manager.Model;

public class Agreement {
    private int id, projectId;
    private String subject, content;

    public Agreement() {}

    public Agreement(int id, int projectId, String subject, String content) {
        this.id = id;
        this.projectId = projectId;
        this.subject = subject;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
