package edu.fsu.cs.mobile.example.dynamic_ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class DynamicUiExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String[] labels = new String[] { "First Name","Last Name","Username" };
        
        String[] countries = new String[]{ "France", "Germany", "Jamaica", "Netherlands", 
        		"United Kingdom", "U.S.A." };
        
        ScrollView scroller = new ScrollView(this);
        TableLayout table = new TableLayout(this);
        TableRow row = null;
        TextView tv = null;
        EditText edit = null;
        RadioGroup group = new RadioGroup(this);
        RadioButton radio = null;
        Spinner spinner = new Spinner(this);
        Button button = null;
        
        for(int i = 0; i < labels.length; i++)
        {
        	row = new TableRow(this);
        	
        	tv = new TextView(this);
	        tv.setText(labels[i]);
	        tv.setEms(7);
	        
	        edit = new EditText(this);
	        edit.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
	        edit.setEms(9);
	        
	        row.addView(tv);
	        row.addView(edit);
	        table.addView(row);
        }
        
        row = new TableRow(this);
        tv = new TextView(this);
        tv.setText(getResources().getString(R.string.gender));
        row.addView(tv);
        
        radio = new RadioButton(this);
        radio.setText(getResources().getString(R.string.female));
        group.addView(radio);
        radio = new RadioButton(this);
        radio.setText(getResources().getString(R.string.male));
        group.addView(radio);
        group.setOrientation(0);
        row.addView(group);
        table.addView(row);
        
        row = new TableRow(this);
        tv = new TextView(this);
        tv.setText(getResources().getString(R.string.country));
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, 
        		android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        row.addView(tv);
        row.addView(spinner);
        table.addView(row);
        
        row = new TableRow(this);
        button = new Button(this);
        button.setText(getResources().getString(R.string.clear));
        row.addView(button);
        button = new Button(this);
        button.setText(getResources().getString(R.string.submit));
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Submit clicked", Toast.LENGTH_SHORT).show();
			}
		});
        
        row.addView(button);
        
        table.addView(row);
       
        scroller.addView(table);
        setContentView(scroller);
        
    }
}