package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    public static final  String EXTRA_STRING_USERNAME = "userName";
    public static final  String EXTRA_STRING_USERBio = "userBio";
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult activityResult) {
            int result = activityResult.getResultCode();
            Intent data = activityResult.getData();
            if(result == RESULT_OK && data != null){
                String userName = data.getStringExtra(EXTRA_STRING_USERNAME);
                String userBio =data.getStringExtra(EXTRA_STRING_USERBio);
                TextView textView =findViewById(R.id.main_userName_tv);
                textView.setText(userName);
                TextView textView2 = findViewById(R.id.main_userBioTv);
                textView2.setText(userBio);
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CheckBox androidSkills = findViewById(R.id.main_android_cb);
        androidSkills.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"Android Skills is Checked !",Toast.LENGTH_LONG).show();
            }
        });

        CheckBox DeepLearninSkills = findViewById(R.id.main_deepLearning_cb);
        DeepLearninSkills.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"DeepLearning Skills is Checked !",Toast.LENGTH_LONG).show();
            }
        });

        CheckBox uiSkills = findViewById(R.id.main_ui_cb);
        uiSkills.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"UI/UX Skills is Checked !",Toast.LENGTH_LONG).show();
            }
        });

        Button saveInformationBtn = findViewById(R.id.main_saveInformatin_btn);
        saveInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Informations saved !",Toast.LENGTH_LONG).show();
            }
        });

        RadioGroup radioGroup =findViewById(R.id.main_radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.main_tehran_rb:
                        Toast.makeText(MainActivity.this,"Thran is Selected !",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.main_gilan_rb:
                        Toast.makeText(MainActivity.this,"Gilan is Selected !",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.main_alborz_rb:
                        Toast.makeText(MainActivity.this,"Alborz is Selected !",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        Button editProfileBtn =findViewById(R.id.main_editProfile_btn);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,EditProfile.class);
                TextView userNaeTv =findViewById(R.id.main_userName_tv);
                TextView userBioTv =findViewById(R.id.main_userBioTv);
                intent.putExtra(EXTRA_STRING_USERNAME,userNaeTv.getText());
                intent.putExtra(EXTRA_STRING_USERBio,userBioTv.getText());
//                startActivityForResult(intent,44);
                activityResultLauncher.launch(intent);
            }
        });

        Button ViewWebBtn = findViewById(R.id.main_viewWeb_btn);
        ViewWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://digikala"));
                startActivity(intent);
            }
        });
        ImageView profileIv = findViewById(R.id.main_profile_image);
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMsiTwIo6vwc9046_WC4K0_e4LlTOjDDmiAA&usqp=CAU")
                .placeholder(R.drawable.profile_image)
                .error(R.drawable.batman)
                .into(profileIv);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 44 && resultCode == Activity.RESULT_OK && data != null){
//            String userName = data.getStringExtra(EXTRA_STRING_USERNAME);
//            String userBio =data.getStringExtra(EXTRA_STRING_USERBio);
//            TextView textView =findViewById(R.id.main_userName_tv);
//            textView.setText(userName);
//            TextView textView2 = findViewById(R.id.main_userBioTv);
//            textView2.setText(userBio);
//        }
//    }
}