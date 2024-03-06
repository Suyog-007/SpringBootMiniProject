package org.shah.springapp.ems.Domains;

import jakarta.persistence.*;
import lombok.Data;
import org.shah.springapp.ems.Services.SkillConvertor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Table(name = "demands")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private String ProjectId;

    @Column(name = "project_name")
    private String ProjectName;

    @Column(name = "manager_name")
    private String MangerName;

    @Column(name = "manager_id")
    private String Manager_Id;

    @Column(name = "position_level")
    private String level;

    @Column(name = "city")
    private String city;

    @Convert(converter= SkillConvertor.class)
    private Map<String,Integer> Skills = new HashMap<>();

    public void setSkills(Map<String, Integer> skills) {
        Skills = skills;
    }


    @Column(name = "duration")
    private double Duration;

    @Column(name = "start_date")
    private  String StartDate;

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return ProjectId;
    }

    public void setProjectId(String projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getManager_Id() {
        return Manager_Id;
    }

    public void setManager_Id(String manager_Id) {
        Manager_Id = manager_Id;
    }

    public String getMangerName() {
        return MangerName;
    }

    public void setMangerName(String mangerName) {
        MangerName = mangerName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getDuration() {
        return Duration;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public Map<String, Integer> getSkills() {
        return Skills;
    }
}
