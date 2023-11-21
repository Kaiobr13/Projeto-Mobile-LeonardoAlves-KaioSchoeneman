package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MMActivity extends AppCompatActivity {

    private ImageButton btnbacktomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmactivity);

        setupComponents();
    }

    private void setupComponents() {

        btnbacktomain = findViewById(R.id.MM_backtomain);

        btnbacktomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MMActivity.this, MainActivity.class));
            }
        });
    }
}