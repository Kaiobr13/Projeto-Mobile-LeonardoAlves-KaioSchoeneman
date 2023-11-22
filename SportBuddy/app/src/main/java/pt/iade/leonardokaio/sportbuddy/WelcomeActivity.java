package pt.iade.leonardokaio.sportbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnlogin;
    private Button btnregister;
    private ImageButton btnresback1;
    private ImageButton btnresnext1;
    private ImageButton btnresback2;
    private Button btncreateaccount;
    private EditText registerusername;
    private EditText registeremail;
    private EditText registereditPass;
    private EditText registerverifyPass;
    private EditText registerbirthday;
    private EditText registerphone;
    private EditText registernation;

    public boolean CheckEntrysP1(View view) {
        registerusername = (EditText)findViewById(R.id.register_edit_user);
        registeremail = (EditText)findViewById(R.id.register_edit_email);
        registereditPass = (EditText)findViewById(R.id.register_edit_pass);
        registerverifyPass = (EditText)findViewById(R.id.register_verify_pass);
        registerbirthday = (EditText)findViewById(R.id.register_birthday);

        if (registerusername.getText().toString().equals("")||registeremail.getText().toString().equals("")||registereditPass.getText().toString().equals("")
                ||registerverifyPass.getText().toString().equals("")||registerbirthday.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    public boolean CheckEntrysP2(View view){
        registerphone = (EditText)findViewById(R.id.register_insert_phone);
        registernation = (EditText)findViewById(R.id.register_nationality);

        if (registerphone.getText().toString().equals("")||registernation.getText().toString().equals("")){
            return false;
        }
        return true;
    }

    public boolean VerifyPass(View view) {
        registereditPass = (EditText) findViewById(R.id.register_edit_pass);
        registerverifyPass = (EditText) findViewById(R.id.register_verify_pass);
        if (!registerverifyPass.getText().toString().equals(registereditPass.getText().toString()))
        {
            return false;
        }
        return true;
    }
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
                if(!CheckEntrysP1(v)){
                    Toast.makeText(getApplicationContext(), "Preencha as informações que faltam!", Toast.LENGTH_LONG).show();
            } else if(!VerifyPass(v)) {
                    Toast.makeText(getApplicationContext(), "Suas senhas não são iguais!", Toast.LENGTH_LONG).show();
                } else {
                    ConstraintLayout register_part1 = findViewById(R.id.register_part1);
                    ConstraintLayout register_part2 = findViewById(R.id.register_part2);
                    register_part1.setVisibility(View.GONE);
                    register_part2.setVisibility(View.VISIBLE);
                }
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

                if(!CheckEntrysP2(v)){
                    Toast.makeText(getApplicationContext(), "Preencha as informações que faltam!", Toast.LENGTH_LONG).show();
                } else {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                }
            }
        });
    }
}