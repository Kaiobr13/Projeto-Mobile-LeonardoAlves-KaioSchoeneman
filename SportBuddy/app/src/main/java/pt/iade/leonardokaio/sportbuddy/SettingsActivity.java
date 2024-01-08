package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setupComponents();
    }

    private void setupComponents() {

        ImageButton btnbackprof = findViewById(R.id.settings_backbut);
        Button btngotoacc = findViewById(R.id.settings_accbut);
        ImageButton btncloseacc = findViewById(R.id.account_close);
        Button btngotonotif = findViewById(R.id.settings_notifbut);
        ImageButton btnclosenotif = findViewById(R.id.notifications_close);
        Button btndelete = findViewById(R.id.settings_deleteacc);
        ImageButton btnclosedelete = findViewById(R.id.delete_close);
        Button btndeleteacc = findViewById(R.id.delete_but);

        btnbackprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(SettingsActivity.this, ProfileActivity.class));
            }
        });

        btngotoacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout settings_main = findViewById(R.id.settings_main);
                ConstraintLayout settings_account = findViewById(R.id.settings_account);
                settings_main.setVisibility(View.GONE);
                settings_account.setVisibility(View.VISIBLE);
            }
        });

        btncloseacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout settings_account = findViewById(R.id.settings_account);
                ConstraintLayout settings_main = findViewById(R.id.settings_main);
                settings_account.setVisibility(View.GONE);
                settings_main.setVisibility(View.VISIBLE);
            }
        });

        btngotonotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout settings_main = findViewById(R.id.settings_main);
                ConstraintLayout settings_notifications = findViewById(R.id.settings_notifications);
                settings_main.setVisibility(View.GONE);
                settings_notifications.setVisibility(View.VISIBLE);
            }
        });

        btnclosenotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout settings_notifications = findViewById(R.id.settings_notifications);
                ConstraintLayout settings_main = findViewById(R.id.settings_main);
                settings_notifications.setVisibility(View.GONE);
                settings_main.setVisibility(View.VISIBLE);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout settings_main = findViewById(R.id.settings_main);
                ConstraintLayout settings_delete = findViewById(R.id.settings_delete);
                settings_main.setVisibility(View.GONE);
                settings_delete.setVisibility(View.VISIBLE);
            }
        });

        btnclosedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout settings_delete = findViewById(R.id.settings_delete);
                ConstraintLayout settings_main = findViewById(R.id.settings_main);
                settings_delete.setVisibility(View.GONE);
                settings_main.setVisibility(View.VISIBLE);
            }
        });
    }
}