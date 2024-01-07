package pt.iade.leonardokaio.sportbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import pt.iade.leonardokaio.sportbuddy.models.LobbyItem;

public class LobbyActivity extends AppCompatActivity {
    protected EditText editTitle;
    protected int PositionList;
    private LobbyItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        Intent intent = getIntent();
        PositionList = intent.getIntExtra("position", -1);
        item = (LobbyItem) intent.getSerializableExtra("item");

        setupComponents();
    }


    private void setupComponents() {

        ImageButton btngotoMM = findViewById(R.id.lobby_backtoMM);
        editTitle = (EditText) findViewById(R.id.note_title);
        populatingView();

        btngotoMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LobbyActivity.this, MMActivity.class));
            }
        });
    }

    protected void populatingView(){
        editTitle.setText(item.getTitle());
    }
}