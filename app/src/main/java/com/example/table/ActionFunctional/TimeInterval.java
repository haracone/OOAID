package com.example.table.ActionFunctional;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class TimeInterval implements Comparable <TimeInterval>, Serializable
{
    private int timeStart;                       //time when action start in minutes
    private int timeEnd;                         //time when action end in minutes

    public TimeInterval(int timeStart, int timeEnd)
    {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
    public static int timeToMinutes(String time)
    {
        String[] time_ = time.split(":");
        int[] minutes = new int[2];
        minutes[0] = Integer.valueOf(time_[0]);
        if (!time_[1].equals("00"))
            minutes[1] = Integer.valueOf(time_[1]);
        return minutes[0]*60+minutes[1];
    }

    public int getTimeStart()
    {
        return timeStart;
    }

    public int getTimeEnd()
    {
        return timeEnd;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int compareTo(TimeInterval o) {
        return Integer.compare(this.timeStart, o.getTimeStart());
    }
}
