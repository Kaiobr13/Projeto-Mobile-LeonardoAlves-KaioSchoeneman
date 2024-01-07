package pt.iade.leonardokaio.sportbuddy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

import pt.iade.leonardokaio.sportbuddy.adapters.LobbyItemRowAdapter;
import pt.iade.leonardokaio.sportbuddy.models.LobbyItem;

public class MMActivity extends AppCompatActivity {

    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;
    protected RecyclerView itemsnotesView;
    protected LobbyItemRowAdapter lobbyRowAdapter;
    protected ArrayList<LobbyItem> lobbyList;

    String[] modality = {"Soccer","Futsal", "Padel", "Tennis", "Volleyball", "Golf", "Cycling", "Athletics",
            "Rugby", "Gym", "Basketball", "Handball", "Swimming"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == EDITOR_ACTIVITY_RETURN_ID){
            if(resultCode == AppCompatActivity.RESULT_OK){
                int position = data.getIntExtra("position", -1);
                LobbyItem itemUpdated = (LobbyItem) data.getSerializableExtra("item");

                if(position == -1) {
                    lobbyList.add(itemUpdated);
                    lobbyRowAdapter.notifyItemInserted(lobbyList.size()-1);
                } else {
                    lobbyList.set(position, itemUpdated);
                    lobbyRowAdapter.notifyItemChanged(position);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmactivity);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(this, R.layout.list_item, modality);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String item = adapterItems.getItem(i);
                Toast.makeText (MMActivity.this, "You have choosed " + item + " modality!", Toast.LENGTH_SHORT).show();
            }
        });

        setupComponents();
    }

    private void setupComponents() {

       ImageButton btnbacktomain = findViewById(R.id.MM_backtomain);
       SeekBar rangeseekbar = findViewById(R.id.range_seekbar);
       TextView rangetext = findViewById(R.id.range_text);
       lobbyList = LobbyItem.List();

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

        lobbyRowAdapter = new LobbyItemRowAdapter(this, lobbyList);
        lobbyRowAdapter.setOnClickListener(new LobbyItemRowAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MMActivity.this, LobbyActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("item", lobbyList.get(position));

                startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);            }
        });

        itemsnotesView = (RecyclerView) findViewById(R.id.lobby_list);
        itemsnotesView.setLayoutManager(new LinearLayoutManager(this));
        itemsnotesView.setAdapter(lobbyRowAdapter);
    }
}