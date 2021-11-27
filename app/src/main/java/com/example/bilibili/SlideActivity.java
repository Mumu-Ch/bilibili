package com.example.bilibili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SlideActivity extends AppCompatActivity {
    //声明控件
    private ImageView mIvHead;
    private SlideMenu slideMenu;
    private Button mBtnStudy;
    private Button mBtnSleep;
    private Button mBtnProgramming;
    private Button mBtnSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        //找到控件
        mIvHead = findViewById(R.id.iv_head);
        slideMenu = findViewById(R.id.slideMenu);

        //找到控件
        mBtnStudy = findViewById(R.id.btn_main_1);
        mBtnSleep = findViewById(R.id.btn_main_4);
        mBtnSport = findViewById(R.id.btn_main_2);
        mBtnProgramming = findViewById(R.id.btn_main_3);


        //实现侧滑的功能,点击加侧滑
        mIvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
            }
        });

        setListener();

    }

    private void setListener(){

        OnClick onClick = new OnClick();

        //现在对每一个按钮进行setOnClickListener
        mBtnStudy.setOnClickListener(onClick);
        mBtnSport.setOnClickListener(onClick);
        mBtnSleep.setOnClickListener(onClick);
        mBtnProgramming.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_main_1:
                    intent = new Intent(SlideActivity.this,StudyActivity.class);
                    break;

                case R.id.btn_main_2:
                    intent = new Intent(SlideActivity.this,SportActivity.class);
                    break;

                case R.id.btn_main_3:
                    intent = new Intent(SlideActivity.this,ProgrammingActivity.class);
                    break;

                case R.id.btn_main_4:
                    intent = new Intent(SlideActivity.this,SleepActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}