package com.colorfrontier.MainApp.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User
{
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private Boolean banned;
    private List<Project> projects;
    private String role;
    private int totalLikes;
    private int totalViews;


    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTotalLikes(int totalLikes)
    {
        this.totalLikes = totalLikes;
    }

    public int getTotalLikes()
    {
        return totalLikes;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public String getUsername() {

        return username;
    }

    public User(String username, String email, String password, Boolean banned, List<Project> projects, String role, int totalLikes, int totalViews)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.banned = banned;
        this.projects = projects;
        this.role = role;
        this.totalLikes = totalLikes;
        this.totalViews = totalViews;
    }

    public String getId() {
        return id;
    }

    public List<Project> getProjects() {

        return projects;
    }

    public void addProject(Project project)
    {
        projects.add(project);
    }

    public void deleteProject(Project project)
    {
        for(int i = 0; i < projects.size(); i++)
        {
            if(project.getName().equals(projects.get(i).getName())
                    && project.getShort_description().equals(projects.get(i).getShort_description())
                    && project.getAuthor().getUsername().equals(projects.get(i).getAuthor().getUsername()))
            {
                projects.remove(i);
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isBanned() {
        return banned;
    }

    public void addView()
    {
        setTotalViews(getTotalViews() + 1);
    }

    public void addLike()
    {
        setTotalLikes(getTotalLikes() + 1);
    }

    public User() {}
}
