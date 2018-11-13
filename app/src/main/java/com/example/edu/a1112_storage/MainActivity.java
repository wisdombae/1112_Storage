package com.example.edu.a1112_storage;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4, button5, button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        File file = null;
        String filename = editText.getText().toString();

        try {
            switch (v.getId()) {
                case R.id.button1:
                    fileInputStream = openFileInput(filename);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    editText2.setText(new String(buffer));
                    fileInputStream.close();
                    break;

                case R.id.button2:
                    fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    fileOutputStream.write(filename.getBytes());
                    editText2.setText("");
                    fileOutputStream.close();
                    break;
                case R.id.button3:
                    file = new File(getExternalFilesDir(null), filename);
                    fileInputStream = new FileInputStream(file);
                    buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    editText2.setText(new String(buffer));
                    fileInputStream.close();
                    break;
                case R.id.button4:
                    file = new File(getExternalFilesDir(null), filename);
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(filename.getBytes());
                    editText2.setText("");
                    fileOutputStream.close();
                    break;
                case R.id.button5:
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), filename);
                    fileInputStream = new FileInputStream(file);
                    buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    editText2.setText(new String(buffer));
                    fileInputStream.close();
                    break;
                case R.id.button6:
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), filename);
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(filename.getBytes());
                    editText2.setText("");
                    fileOutputStream.close();
                    break;
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}