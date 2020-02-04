package com.example.table;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.table.ActionFunctional.Action;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Day implements Parcelable
{
     private ArrayList<Action> actions;

     Day()
     {
         actions = new ArrayList<>();
     }

    protected Day(Parcel in)
    {
        actions = (ArrayList<Action>)in.readSerializable();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };


     public boolean setAction(Action act)
     {
         boolean possibleAction = true;
        for (Action act_ : actions)
        {
            if ((act_.getTimeInterval().getTimeStart() < act.getTimeInterval().getTimeStart()
            && act_.getTimeInterval().getTimeEnd() > act.getTimeInterval().getTimeStart())
            || (act_.getTimeInterval().getTimeStart() < act.getTimeInterval().getTimeEnd() &&
                    act_.getTimeInterval().getTimeEnd() > act.getTimeInterval().getTimeEnd() ))
                possibleAction = false;
        }

        if (possibleAction)
        {
            System.out.println("----------------------------put this action: " + act.getName());
            actions.add(act);
            Collections.sort(actions, new Comparator<Action>(){
            @Override
            public int compare(Action o1, Action o2) {

                if (o1.getTimeInterval().getTimeStart() < o2.getTimeInterval().getTimeStart())
                    return -1;
                if (o1.getTimeInterval().getTimeStart() == o2.getTimeInterval().getTimeStart())
                    return 0;
                return 1;
            }});

            return true;
        }

            System.out.println("----------------------------Can't put this action" + act.getName());
            return false;
     }

     public ArrayList<Action> getActions()
     {
         return actions;
     }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeSerializable(actions);
    }
}
