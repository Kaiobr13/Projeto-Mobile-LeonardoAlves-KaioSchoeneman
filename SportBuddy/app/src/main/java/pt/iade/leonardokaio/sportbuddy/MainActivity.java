package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btngotoprof;
    private ImageButton btngotomap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupComponents();
    }

    private void setupComponents() {

        btngotoprof = findViewById(R.id.home_profilebut);
        btngotomap = findViewById(R.id.home_mapbut);

        btngotoprof.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                }
            });
        btngotomap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
    }
}

