package com.example.edu.a1112_storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            switch (v.getId()) {
                case R.id.button1:
                    fileInputStream = openFileInput(editText.getText().toString());
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    editText2.setText(new String(buffer));
                    fileInputStream.close();
                    break;

                case R.id.button2:
                    fileOutputStream = openFileOutput(editText.getText().toString(), Context.MODE_PRIVATE);
                    fileOutputStream.write(editText.getText().toString().getBytes());
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