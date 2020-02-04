package com.example.table;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;

import com.example.table.ActionFunctional.Action;
import com.example.table.ActionFunctional.StudyAction;
import com.example.table.ActionFunctional.TimeInterval;
import com.example.table.ActionFunctional.UserAction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TableActivity extends Activity
{
    private String group;
    private Loader loader = new Loader();
    private HashMap<String, Day> table;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        table = new HashMap<String, Day>();
        group = getIntent().getStringExtra("group");
    }

    @Override
    public void onStart() {

        super.onStart();

        Thread net = new Thread(new Connection());
        net.start();
        synchronized (table)
        {
            try {
                table.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printTable();

        table.get("Monday").setAction(new UserAction("eat", "14:40-15:30"));
        table.get("Saturday").setAction(new UserAction("sleep", "8:30-9:20"));
        table.get("Saturday").setAction(new UserAction("sleep", "11:00-12:00"));

        Intent i = new Intent(this.getBaseContext(), Test.class);
        i.putExtra("param", table.get("Monday"));
        i.putExtra("str", "Monday");
        startActivity(i);
    }

    private void printTable()
    {
        for (Map.Entry<String, Day> table_ : table.entrySet())
        {
            System.out.println(table_.getKey());
            for (Action day : table_.getValue().getActions())
            {
                System.out.println("START OF STUDY: " + day.getTimeInterval().getTimeStart());
                System.out.println("END OF STUDY: " + day.getTimeInterval().getTimeEnd());
                System.out.println(day.getName());
            }
            System.out.println("\n____________________________________________________-");
        }
    }
    class Connection implements Runnable
    {
        @Override
        public void run()
        {
            loader.loadTable(group);
            HashMap<String, ArrayList<StudyInfo>> info;
            info = loader.parseTable();

            for (Map.Entry<String, ArrayList<StudyInfo>> subj : info.entrySet())
            {
                Day day = new Day();
                for (int i = 0; i  < subj.getValue().size(); i++)
                {
                    StudyInfo st = subj.getValue().get(i);
                    if (st.getName().equals("-"))
                        continue;
                    if (i + 1 < subj.getValue().size()) {
                        StudyInfo st_ = subj.getValue().get(i+1);
                        day.setAction(new StudyAction(st, st.getTime()+"-"+st_.getTime()));
                    }
                }

                table.put(subj.getKey(), day);
            }

            synchronized (table)
            {
                table.notify();
            }
        }
    }
}
