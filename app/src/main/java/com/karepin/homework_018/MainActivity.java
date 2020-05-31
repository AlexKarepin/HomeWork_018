package com.karepin.homework_018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    protected RadioGroup radioGroup;
    protected Spinner spinner;
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        initSpinnerCountries();
        onClickMy();
    }

    private void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this,
                R.array.styleTheme, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterCountries);
    }

    private void onClickMy() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                switch (selectedId) {
                    case R.id.radioButtonRus: {
                        switchLokale("ru");
                        break;
                    }
                    case R.id.radioButtonEng: {
                        switchLokale("en");
                        break;
                    }
                }
                int selected = spinner.getSelectedItemPosition();
                switch (selected) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN_ONE);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN_TWO);
                        break;
                    case 3:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MARGIN_THREE);
                        break;
                }
                recreate();
            }
        });

    }

    public void switchLokale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
