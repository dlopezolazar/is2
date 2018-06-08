package pol.una.py.gestprois2_frontend.model;

import java.util.Date;

/**
 * Created by Diego on 19/05/2018.
 */

public class SprintModel {

    private String sprintId;
    private String initDate;
    private String endDate;
    private String sprintDescription;
    private String projectDescription;

    public SprintModel() {
    }

    public SprintModel(String sprintId, String initDate, String endDate, String sprintDescription, String projectDescription) {
        this.sprintId = sprintId;
        this.initDate = initDate;
        this.endDate = endDate;
        this.sprintDescription = sprintDescription;
        this.projectDescription = projectDescription;
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSprintDescription() {
        return sprintDescription;
    }

    public void setSprintDescription(String sprintDescription) {
        this.sprintDescription = sprintDescription;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @Override
    public String toString() {
        return "SprintModel{" +
                "sprintId=" + sprintId +
                ", initDate=" + initDate +
                ", endDate=" + endDate +
                ", sprintDescription='" + sprintDescription + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                '}';
    }
}
