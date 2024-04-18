package com.example.assignmentone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText passEditText;
    private CheckBox rememberChk;
    private Button enterBtn;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public static final String NAME = "NAME";
    public static final String PASS = "PASS";
    public static final String FLAG = "FLAG";
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        setUp();
        setupSharedPrefs();
        checkPrefs();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void setUp(){
        nameEditText = findViewById(R.id.nameEditText);
        passEditText = findViewById(R.id.passEditText);
        rememberChk = findViewById(R.id.rememberChk);
        enterBtn = findViewById(R.id.enterBtn);
    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG, false);

        if(flag){
            String name = prefs.getString(NAME, "");
            String password = prefs.getString(PASS, "");
            nameEditText.setText(name);
            passEditText.setText(password);
            rememberChk.setChecked(true);
        }
    }

    public void btnLoginOnClick(View view) {
        String name = nameEditText.getText().toString();
        String password = passEditText.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);

        if (rememberChk.isChecked()) {
            if (!flag) {
                editor.putString(NAME, name);
                editor.putString(PASS, password);
                editor.putBoolean(FLAG, true);
                editor.commit();
            }

        }
        startActivity(intent);
    }
}