package com.example.bilibili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bilibili.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //声明控件
    private Button mBtnLogin;
    private EditText mEtUser;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到控件
        mBtnLogin = findViewById(R.id.btn_login);
        mEtUser = findViewById(R.id.et_user);
        mEtPassword = findViewById(R.id.et_password);

        /*//实现直接跳转——方法一
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity.this,SlideActivity.class);
                startActivity(intent);
            }
        });*/

        //匹配对应的用户名和密码才能进行登录操作
        mBtnLogin.setOnClickListener(this);
    }

    public void onClick(View v){
        //需要获取输入的用户名和密码
        String username = this.mEtUser.getText().toString();
        String password = this.mEtPassword.getText().toString();
        Intent intent = null;
        //弹出内容设置
        String success = "登录成功";
        String fail = "密码或用户名错误";

        //假设正确的账户和密码是：clt、123。
        if (username.equals("clt")&&password.equals("123")){
            //底部弹出
            //Toast.makeText(MainActivity.this,success, Toast.LENGTH_SHORT).show();

            //居中弹出 getApplicationContext()与MainActivity.this一样
            /*Toast toastCenter = Toast.makeText(getApplicationContext(),success,Toast.LENGTH_SHORT);
            toastCenter.setGravity(Gravity.CENTER,0,0);
            toastCenter.show();*/

            //封装类调用底部弹出
            ToastUtil.showMsg(MainActivity.this,success);

            //如果正确的话进行跳转 实现跳转
            intent = new Intent(MainActivity.this, SlideActivity.class);
            startActivity(intent);
        }else{
            //不正确，弹出登录失败
            //完整版的弹出
           /* mBtnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"密码或用户名错误",Toast.LENGTH_SHORT).show();
                }
            });*/
            //底部弹出
            //Toast.makeText(MainActivity.this,fail,Toast.LENGTH_SHORT).show();
            //居中弹出
            Toast toastCenter = Toast.makeText(getApplicationContext(),fail,Toast.LENGTH_SHORT);
            toastCenter.setGravity(Gravity.CENTER,0,0);
            toastCenter.show();
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}