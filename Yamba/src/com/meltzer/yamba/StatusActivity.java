package com.meltzer.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class StatusActivity extends Activity {
	
	private Button buttonUpdate;
	private EditText editStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
    }


}
