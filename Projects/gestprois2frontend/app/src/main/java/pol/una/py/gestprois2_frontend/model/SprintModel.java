package pol.una.py.gestprois2_frontend.model;

import java.util.Date;

/**
 * Created by Diego on 19/05/2018.
 */

public class SprintModel {

    private Integer sprintId;
    private Date initDate;
    private Date endDate;
    private String sprintDescription;

    public SprintModel() {
    }

    public SprintModel(Integer sprintId, Date initDate, Date endDate, String sprintDescription) {
        this.sprintId = sprintId;
        this.initDate = initDate;
        this.endDate = endDate;
        this.sprintDescription = sprintDescription;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public void setSprintId(Integer sprintId) {
        this.sprintId = sprintId;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSprintDescription() {
        return sprintDescription;
    }

    public void setSprintDescription(String sprintDescription) {
        this.sprintDescription = sprintDescription;
    }

    @Override
    public String toString() {
        return "SprintModel{" +
                "sprintId=" + sprintId +
                ", initDate=" + initDate +
                ", endDate=" + endDate +
                ", sprintDescription='" + sprintDescription + '\'' +
                '}';
    }
}
