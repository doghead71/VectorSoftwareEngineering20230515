package com.jamteach.testapp;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FilesDemo extends AppCompatActivity {

    EditText enteredText;
    TextView retrievedText;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.files_demo);

        enteredText = findViewById(R.id.editTextFilesDemo);
        retrievedText = findViewById(R.id.filesDemoTextView);

        setupButtonSaveToDevice();
        setupButtonSaveToSDCard();
        setupButtonLoadFromDevice();
        setupButtonLoadFromSDCard();
    }


    private void setupButtonSaveToDevice() {
        Button buttonSaveDevice = findViewById(R.id.buttonSaveDevice);
        buttonSaveDevice.setOnClickListener(view -> {
            try {
                FileOutputStream fileOutputStream = openFileOutput("savedText.txt", MODE_PRIVATE); //opens the named file for writing
                saveFile(fileOutputStream);
            } catch (IOException error) {
                error.printStackTrace();
            }

        });
    }

    private void setupButtonLoadFromDevice() {
        Button buttonLoadDevice = findViewById(R.id.buttonLoadDevice);
        buttonLoadDevice.setOnClickListener(view -> {
            loadFromDevice();
        });
    }


    private void setupButtonSaveToSDCard() {
        Button buttonSaveSDCard = findViewById(R.id.buttonSaveSDCard);
        buttonSaveSDCard.setOnClickListener(view -> {
            try {
                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath());
                directory.mkdirs();
                File file = new File(directory, "sdText.txt");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                saveFile(fileOutputStream);
            } catch (IOException error) {
                error.printStackTrace();
            }
        });
    }


    private void setupButtonLoadFromSDCard() {
        Button buttonLoadSDCard = findViewById(R.id.buttonLoadSDCard);
        buttonLoadSDCard.setOnClickListener(view -> {

        });
    }

    private void saveFile(FileOutputStream fileOutputStream) {

        String data = enteredText.getText().toString();

        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream); // converts char stream to byte stream

            outputStreamWriter.write(data); // write string to file
            outputStreamWriter.flush(); // ensures all bytes are written to file
            outputStreamWriter.close(); // closes the file
            enteredText.setText("");

            Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();
        }
        catch (IOException error){
            error.printStackTrace();
        }
    }



    private void loadFromDevice() {
        try {
            FileInputStream fileInputStream = openFileInput("savedText.txt"); // selects the file to be read
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);// reads the selected file
            char[] inputBuffer = new char[READ_BLOCK_SIZE]; // sets a limit to the amount of chars to be read in each iteration
            String data = "";
            int charRead;

            while ((charRead=inputStreamReader.read(inputBuffer)) > 0){ // returns the number of characters read or -1 if the end of the file is reached
                String readString = String.copyValueOf(inputBuffer,0,charRead);// ??
                data+=readString;
                inputBuffer = new char[READ_BLOCK_SIZE];
            }
            retrievedText.setText(data);
            Toast.makeText(this, "Data loaded from device", Toast.LENGTH_SHORT).show();

        }catch (IOException error){
            error.printStackTrace();
        }
    }


}
