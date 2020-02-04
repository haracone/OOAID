package com.example.table.ActionFunctional;
import com.example.table.StudyInfo;

import java.io.Serializable;
import java.util.ArrayList;

public class StudyAction implements Action, Serializable {

    private TimeInterval timeInterval;
    private StudyInfo infoSubject;
    private ArrayList<String> homeTasks;
    private ArrayList<String> notes;

     public StudyAction(StudyInfo studyInfo, String time)
     {
         infoSubject = studyInfo;
         studyInfo.setTime(time);
         homeTasks = new ArrayList<>();
         notes = new ArrayList<>();
         String[] time_ = time.split("-");
         timeInterval = new TimeInterval(TimeInterval.timeToMinutes(time_[0]),
                 TimeInterval.timeToMinutes(time_[1]));
     }

    public void setHomeTasks(String homeTask){homeTasks.add(homeTask);}

    public void setNotes(String note){notes.add(note);}

     public ArrayList<String> getHomeTasks(){return homeTasks;}

    public ArrayList<String> getNotes(){return notes;}

    @Override
    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public String getTutor() { return infoSubject.getTutor(); }

    public String getRoom() { return infoSubject.getRoom();}

    public String getType(){return  infoSubject.getType();};

    @Override
    public String getName() { return infoSubject.getName(); }

    @Override
    public String getTime() { return infoSubject.getTime(); }
}
