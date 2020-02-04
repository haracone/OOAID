package com.example.table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickNote extends AppCompatActivity {

    private EditText edit;
    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_note);

        edit = (EditText) findViewById(R.id.editText2);
        txtShow = (TextView) findViewById(R.id.textView2);
    }

    public void read(View view) {
        try {
            FileInputStream fileInputStream = openFileInput("data.txt");
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines).append("\n");
            }
            txtShow.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(View view) {
        String myTxt = edit.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("data.txt", MODE_PRIVATE);
            fileOutputStream.write(myTxt.toString().getBytes());
            fileOutputStream.close();
            edit.setText("");
            Toast.makeText(QuickNote.this, "Текст успешно сохранен", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
