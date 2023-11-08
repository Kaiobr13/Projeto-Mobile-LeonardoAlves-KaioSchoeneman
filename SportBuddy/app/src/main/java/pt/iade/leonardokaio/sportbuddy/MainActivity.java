package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupComponents();
    }

    private void setupComponents() {
        // TODO: findVIewbyID(loginbutton)
        // setonclicklistenr do button
        //     Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        //     startActivity(intent);
    }
}