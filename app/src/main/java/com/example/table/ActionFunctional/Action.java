package com.example.table.ActionFunctional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public interface Action {
   String getName();
   String getTime();
   public void setNotes(String note);
   public ArrayList<String> getNotes();
   public TimeInterval getTimeInterval();

}
