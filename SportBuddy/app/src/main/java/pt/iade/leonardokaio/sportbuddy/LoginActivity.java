package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public boolean CheckEntrys(View view){
        EditText textUsername = (EditText)findViewById(R.id.login_username_text);
        EditText textPassword = (EditText)findViewById(R.id.login_password_text);
        if(textPassword.getText().toString().equals("")||textUsername.getText().toString().equals(""))
        {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupComponents();
    }

    private void setupComponents() {
        ImageButton btnbacklog = findViewById(R.id.login_backbut);
        ImageButton btnnextlog = findViewById(R.id.login_nextbut);

        btnbacklog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            }
        });

        btnnextlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!CheckEntrys(v)){
                    Toast.makeText(getApplicationContext(),"Fill in the missing information!", Toast.LENGTH_LONG).show();
                } else {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });
    }
}