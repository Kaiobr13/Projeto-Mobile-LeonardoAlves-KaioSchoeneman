package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterLoginActivity extends AppCompatActivity {

    private Button btnlogin;
   // private Button btnregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerlogin_page);

        setupComponents();
    }

    private void setupComponents() {
        btnlogin = findViewById(R.id.main_login_button);
        //btnregister = findViewById(R.id.main_register_button);

        //btnregister.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //  public void onClick(View v) {
        //startActivity(new Intent(RegisterLoginActivity.this, register_part1.class));
        //    }
        //});

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterLoginActivity.this, LoginActivity.class));
            }
        });
    }
}