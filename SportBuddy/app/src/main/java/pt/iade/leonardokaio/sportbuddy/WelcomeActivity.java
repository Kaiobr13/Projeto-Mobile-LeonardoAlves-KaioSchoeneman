package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnlogin;
    private Button btnregister;
    private ImageButton btnresback1;
    private ImageButton btnresnext1;
    private ImageButton btnresback2;
    private Button btncreateaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        setupComponents();
    }

    private void setupComponents() {
        btnlogin = findViewById(R.id.welcome_login_button);
        btnregister = findViewById(R.id.welcome_register_button);
        btnresback1 = findViewById(R.id.register_backbut1);
        btnresnext1 = findViewById(R.id.register_nextbut1);
        btnresback2 = findViewById(R.id.register_backbut2);
        btncreateaccount = findViewById(R.id.register_button_create2);

        btnregister.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout welcome_page = findViewById(R.id.welcome_page);
                ConstraintLayout register_part1 = findViewById(R.id.register_part1);
                welcome_page.setVisibility(View.GONE);
                register_part1.setVisibility(View.VISIBLE);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            }
        });

        btnresback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout welcome_page = findViewById(R.id.welcome_page);
                ConstraintLayout register_part1 = findViewById(R.id.register_part1);
                welcome_page.setVisibility(View.VISIBLE);
                register_part1.setVisibility(View.GONE);
            }
        });

        btnresnext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout register_part1 = findViewById(R.id.register_part1);
                ConstraintLayout register_part2 = findViewById(R.id.register_part2);
                register_part1.setVisibility(View.GONE);
                register_part2.setVisibility(View.VISIBLE);
            }
        });

        btnresback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout register_part1 = findViewById(R.id.register_part1);
                ConstraintLayout register_part2 = findViewById(R.id.register_part2);
                register_part2.setVisibility(View.GONE);
                register_part1.setVisibility(View.VISIBLE);
            }
        });

        btncreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            }
        });

    }
}