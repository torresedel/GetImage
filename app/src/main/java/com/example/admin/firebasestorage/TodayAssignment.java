package com.example.admin.firebasestorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 10/21/2017.
 */

public class TodayAssignment {
    String title;
    String description;
    List<String> linkList;
    Date assignDate;
    Date dueDate;

    public TodayAssignment() {
    }

    public TodayAssignment(String title, String description, Date assignDate, Date dueDate) {
        this.title = title;
        this.description = description;
        this.assignDate = assignDate;
        this.dueDate = dueDate;
        linkList = new ArrayList<>();
    }

    public TodayAssignment(String title, String description, List<String> linkList, Date assignDate, Date dueDate) {
        this.title = title;
        this.description = description;
        this.linkList = linkList;
        this.assignDate = assignDate;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<String> linkList) {
        this.linkList = linkList;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        String value;
        if (linkList.size() == 0) {
            return "TodayAssignment{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", assignDate=" + assignDate +
                    ", dueDate=" + dueDate +
                    '}';
        } else {
            value = "TodayAssignment{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", links='";
            int i = 0;
            for (String str :
                    linkList) {
                if (i != 0) {
                    value = value + str;
                } else {
                    value = value + '\'' + str;
                }
            }
            value = value + ", assignDate=" + assignDate +
                    ", dueDate=" + dueDate +
                    '}';

        }
        return value;
    }
}
