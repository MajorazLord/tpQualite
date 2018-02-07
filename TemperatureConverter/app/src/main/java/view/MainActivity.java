package view;

import android.content.SharedPreferences;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import model.Converter;
import model.Sharedpref;
import uca.iut.temperatureconverter.R;

public class MainActivity extends AppCompatActivity {

    EditText etC, etF;
    Button btnRetrieveC, btnRetrieveF;
    ListView mListView;
    GridLayout mGrid;


    String oldValueC, oldValueF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRetrieveC = findViewById(R.id.btnRetrieveC);
        btnRetrieveF = findViewById(R.id.btnRetrieveF);
        etC = findViewById(R.id.eTCel);
        etF = findViewById(R.id.eTFar);
        mListView = (ListView) findViewById(R.id.lvItem);




        etC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etC.isFocused())
                    oldValueC = etC.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etC.isFocused()){
                    String newV = etC.getText().toString();
                    if(!oldValueC.equals(newV)){
                        if(newV.equals("")){
                            etF.setText("");
                            return;
                        }
                        if(newV.equals("-")){
                            etF.setText("");
                            return;
                        }
                        Log.d("COUCOU", "OldValueC : "+oldValueC+" -- New : "+etC.getText().toString());
                        Double val = Double.parseDouble(etC.getText().toString());
                        etF.setText(String.format("%.1f", Converter.convertCelToFar(val, getBaseContext())));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etF.isFocused())
                    oldValueF = etF.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(etF.isFocused()){
                    String newV = etF.getText().toString();
                    if(!oldValueF.equals(newV)){
                        if(newV.equals("")){
                            etC.setText("");
                            return;
                        }
                        if(newV.equals("-")){
                            etC.setText("");
                            return;
                        }
                        Log.d("COUCOU", "OldValueF : "+oldValueF+" -- New : "+etF.getText().toString());
                        Double val = Double.parseDouble(etF.getText().toString());
                        etC.setText(String.format("%.1f",Converter.convertFarToCel(val, getBaseContext())));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        btnRetrieveC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> resTot = new ArrayList<>();
                resTot.addAll(Sharedpref.RetrieveCelciusSharedpref());

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, android.R.id.text1, resTot.toArray(new String[resTot.size()]));
                mListView.setAdapter(adapter);
            }
        });

        btnRetrieveF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> resTot = new ArrayList<>();
                resTot.addAll(Sharedpref.RetrieveFarSharedpref());

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, android.R.id.text1, resTot.toArray(new String[resTot.size()]));
                mListView.setAdapter(adapter);
            }
        });
    }
}
