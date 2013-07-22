package com.meltzer.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StatusActivity extends Activity {
	
	private Button buttonUpdate;
	private EditText editStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        
        editStatus = (EditText) findViewById(R.id.edit_status);
        buttonUpdate = (Button) findViewById(R.id.button_update);
        buttonUpdate.setOnClickListener( new OnClickListener() {

			@Override
			/** 
			 * What we want to do when the "update" button is clicked
			 */
			public void onClick(View view) {
				Log.d("StatusActivity", "onClicked!");
				
			} 
		});
    }


}
