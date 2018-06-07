package pol.una.py.gestprois2_frontend.model;

/**
 * Created by Diego on 20/05/2018.
 */

public class StoryModel {

    private Integer idTask;
    private String taskDescription;
    private String state;
    private SprintModel sprint;
    private ProjectModel project;
    private UserModel user;

    public StoryModel() {
    }

    public StoryModel(Integer idTask, String taskDescription, String state, SprintModel sprint, ProjectModel project, UserModel user) {
        this.idTask = idTask;
        this.taskDescription = taskDescription;
        this.state = state;
        this.sprint = sprint;
        this.project = project;
        this.user = user;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public SprintModel getSprint() {
        return sprint;
    }

    public void setSprint(SprintModel sprint) {
        this.sprint = sprint;
    }

    public ProjectModel getProject() {
        return project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "StoryModel{" +
                "idTask=" + idTask +
                ", taskDescription='" + taskDescription + '\'' +
                ", state='" + state + '\'' +
                ", sprint=" + sprint +
                ", project=" + project +
                ", user=" + user +
                '}';
    }
}
