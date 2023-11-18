package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton gotomainbtn;
    private ImageButton statsbtn;
    private ImageButton closestats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupComponents();
    }

    private void setupComponents() {

        gotomainbtn = findViewById(R.id.profile_homebut);
        statsbtn = findViewById(R.id.profile_statsbut);
        closestats = findViewById(R.id.stats_closepage);

        gotomainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

        statsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout profile_constraint = findViewById(R.id.profile_constraint);
                ConstraintLayout stats_constraint = findViewById(R.id.stats_constraint);
                profile_constraint.setVisibility(View.GONE);
                stats_constraint.setVisibility(View.VISIBLE);
            }
        });

        closestats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout stats_constraint = findViewById(R.id.stats_constraint);
                ConstraintLayout profile_constraint = findViewById(R.id.profile_constraint);
                stats_constraint.setVisibility(View.GONE);
                profile_constraint.setVisibility(View.VISIBLE);
            }
        });
    }
}