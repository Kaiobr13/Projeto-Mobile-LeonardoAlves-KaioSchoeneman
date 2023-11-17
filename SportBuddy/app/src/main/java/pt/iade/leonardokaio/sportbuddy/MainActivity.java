package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //private ImageButton profilebut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupComponents();
    }

    private void setupComponents() {
            //profilebut = findViewById(R.id.home_profilebut);

            //profilebut.setOnClickListener(new View.OnClickListener() {
               // @Override
                //public void onClick(View v) {
                    //startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                //}
            //});
    }
}