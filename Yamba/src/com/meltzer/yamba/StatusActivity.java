package com.meltzer.yamba;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

public class StatusActivity extends Activity {

	private static final String TAG = "StatusActivity";
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
				String status = editStatus.getText().toString();
				Log.d(TAG, "onClicked with status: " + status);
				
				// needs to do the actual cloud communication outside of the UI thread - could take a while
				new PostTask().execute(status);
			} 
		});
    }

    private static class PostTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			YambaClient yamba = new YambaClient("student", "password");
			try {
				yamba.postStatus(params[0]);
				return "Successfully posted!";
			} catch (YambaClientException e) {
				Log.e(TAG, "Failed to post", e);
				return "Failed to post";
			}
			
		}
    	
    }
}
