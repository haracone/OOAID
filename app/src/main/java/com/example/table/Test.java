package com.example.table;

import android.app.Activity;
import android.os.Bundle;

import com.example.table.ActionFunctional.Action;

public class Test extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Day day = getIntent().getParcelableExtra("param");
        String name = getIntent().getStringExtra("str");
        System.out.println("************************************************************" + name);
        for (Action act : day.getActions())
        {
            System.out.println(act.getTimeInterval().getTimeStart());
            System.out.println(act.getTimeInterval().getTimeEnd());
            System.out.println(act.getName());
            System.out.println(act.getTime());
        }
    }
}
