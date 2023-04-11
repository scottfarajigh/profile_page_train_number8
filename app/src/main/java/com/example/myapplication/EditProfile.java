package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        String userName =getIntent().getStringExtra(MainActivity.EXTRA_STRING_USERNAME);
        String userBio = getIntent().getStringExtra(MainActivity.EXTRA_STRING_USERBio);
        EditText editText = findViewById(R.id.editProfile_userName);
        EditText editText2 =findViewById(R.id.editProfile_userBio);

        editText.setText(userName);
        editText2.setText(userBio);
        Button doneBtn =findViewById(R.id.DoneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName =editText.getText().toString();
                String userBio =editText2.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_STRING_USERNAME,userName);
                intent.putExtra(MainActivity.EXTRA_STRING_USERBio,userBio);
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });

    }
}