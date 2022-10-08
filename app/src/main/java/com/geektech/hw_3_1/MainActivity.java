package com.geektech.hw_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText sendTo, messageTheme, messageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendTo = findViewById(R.id.sendTo);
        messageTheme = findViewById(R.id.messageTheme);
        messageText = findViewById(R.id.messageText);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{sendTo.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, messageTheme.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, messageText.getText().toString());

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an Email client"));
    }
}