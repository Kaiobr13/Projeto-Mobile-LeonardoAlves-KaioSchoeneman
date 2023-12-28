package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MMActivity extends AppCompatActivity {

    String[] modality = {"Soccer","Futsal", "Padel", "Tennis", "Volleyball", "Golf", "Cycling", "Athletics",
            "Rugby", "Gym", "Basketball", "Handball", "Swimming"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmactivity);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, modality);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String item = adapterItems.getItem(i).toString();
                Toast.makeText (MMActivity.this, "You have choosed " + item + " modality!", Toast.LENGTH_SHORT).show();
            }
        });

        setupComponents();
    }

    private void setupComponents() {

       ImageButton btnbacktomain = findViewById(R.id.MM_backtomain);
       SeekBar rangeseekbar = findViewById(R.id.range_seekbar);
       TextView rangetext = findViewById(R.id.range_text);

       rangeseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int range, boolean b){
               rangetext.setText("Your range is " + range + "KM");
           }
           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
           }
           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
           }
       });

        btnbacktomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MMActivity.this, MainActivity.class));
            }
        });
    }
}

