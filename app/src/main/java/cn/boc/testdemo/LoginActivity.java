package cn.boc.testdemo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText phone,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = (EditText) findViewById(R.id.phoneEditText);
        password = (EditText) findViewById(R.id.codeEditText);

//        ImageView imageView = (ImageView) findViewById(R.id.logo);
//
//        imageView.setImageBitmap(BitmapFactory.decodeFile("/sdcard/small.jpg"));


        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phone.getText().toString().equals("13951855385") && password.getText().toString().length() > 6 ){
                    Intent intent = new Intent(LoginActivity.this,ListActivity.class);
                    intent.putExtra("phone",phone.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }

            }
        });


        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(phone.getText().toString().equals("13951855385") && password.getText().toString().length() > 6 ){
                    Intent intent = new Intent(LoginActivity.this,Html5Activity.class);
                    intent.putExtra("phone",phone.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
