package com.example.table.ActionFunctional;

import java.io.Serializable;
import java.util.ArrayList;

public class UserAction implements Action, Serializable
{
    private String name;
    private String time;
    private ArrayList<String> notes;
    private TimeInterval timeInterval;

    public UserAction(String name, String time)
    {
        this.name = name;
        this.time = time;
        notes = new ArrayList<>();
        String[] time_ = time.split("-");
        timeInterval = new TimeInterval(TimeInterval.timeToMinutes(time_[0]),
                TimeInterval.timeToMinutes(time_[1]));
    }

    public void setNotes(String note)
    {
        notes.add(note);
    }

    public ArrayList<String> getNotes()
    {
        return notes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public TimeInterval getTimeInterval() {
        return timeInterval;
    }
}
