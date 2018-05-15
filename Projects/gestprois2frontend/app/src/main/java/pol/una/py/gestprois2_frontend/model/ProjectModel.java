package pol.una.py.gestprois2_frontend.model;


/**
 * Created by Diego on 14/05/2018.
 */

public class ProjectModel{

    private String projectId;
    private String projectName;
    private String projectInitDate;
    private String projectEndDate;

    public ProjectModel() {
    }

    public ProjectModel(String projectId, String projectName, String projectInitDate, String projectEndDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectInitDate = projectInitDate;
        this.projectEndDate = projectEndDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectInitDate() {
        return projectInitDate;
    }

    public void setProjectInitDate(String projectInitDate) {
        this.projectInitDate = projectInitDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectInitDate='" + projectInitDate + '\'' +
                ", projectEndDate='" + projectEndDate + '\'' +
                '}';
    }
}
