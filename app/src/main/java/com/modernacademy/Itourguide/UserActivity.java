package com.modernacademy.Itourguide;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {

    Button btncam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btncam=(Button) findViewById(R.id.btn_link_camera);
        btncam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this,DetectorActivity.class));
            }
        });
//        Button btnsignout;
//
//        btnsignout=(Button) findViewById(R.id.btn_signout);
//        btnsignout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(UserActivity.this,LoginActivity.class));
//            }
//        });


}
}