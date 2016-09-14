package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";
		private SharedPreferences prefs;
		// lifecycle counts	
		//TODO:
		//Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		// You will need to increment these variables' values when their corresponding lifecycle methods get called.  
		private int onCreateCounter, onStartCounter,onResumeCounter,onPauseCounter;
		private int onStopCounter , onRestartCounter, onDestroyCounter;

	@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);



			if(savedInstanceState != null)
			{
				onCreateCounter = savedInstanceState.getInt("onCreateCounter");
				onStartCounter = savedInstanceState.getInt("onStartCounter");
				onResumeCounter = savedInstanceState.getInt("onResumeCounter");
				onPauseCounter = savedInstanceState.getInt("onPauseCounter");
				onStopCounter = savedInstanceState.getInt("onStopCounter");
				onRestartCounter = savedInstanceState.getInt("onRestartCounter");
				onDestroyCounter = savedInstanceState.getInt("onDestroyCounter");
			}
			else {
				onCreateCounter =0;
				onStartCounter =0;
				onResumeCounter = 0;
				onPauseCounter =0;
				onStopCounter=0;
				onRestartCounter=0;
				onDestroyCounter=0;
			}
		prefs = getPreferences(MODE_PRIVATE);
		onCreateCounter = prefs.getInt("onCreateCounter",0);
		onStartCounter = prefs.getInt("onStartCounter",0);
		onResumeCounter = prefs.getInt("onResumeCounter",0);
		onPauseCounter = prefs.getInt("onPauseCounter",0);
		onRestartCounter = prefs.getInt("onRestartCounter",0);
		onStopCounter = prefs.getInt("onStopCounter",0);
		onDestroyCounter = prefs.getInt("onDestroyCounter",0);

			//Log cat print out
			Log.i(TAG, "onCreate called");
			
			//TODO:
			//update the appropriate count variable
				onCreateCounter++;
			//update the view
			TextView createTxtView = (TextView)findViewById(R.id.create);
			createTxtView.setText("onCreate() calls: "+ onCreateCounter);
			TextView startTxtView = (TextView)findViewById(R.id.start);
			startTxtView.setText("onStart() calls: " + onStartCounter);
			TextView resumeTxtView = (TextView)findViewById(R.id.resume);
			resumeTxtView.setText("onResume() calls: " + onResumeCounter);
			TextView restartTxtView = (TextView)findViewById(R.id.restart);
			restartTxtView.setText("onRestart() calls: " + onRestartCounter);
			TextView pauseTxtView = (TextView)findViewById(R.id.pause);
			pauseTxtView.setText("onPause() calls: " + onPauseCounter);
			TextView stopTxtView = (TextView)findViewById(R.id.stop);
			stopTxtView.setText("onStop() calls: "+ onStopCounter);
			TextView destroyTxtView = (TextView)findViewById(R.id.destroy);
			destroyTxtView.setText("onDestroy() calls: " + onDestroyCounter);
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();
			
			//Log cat print out
			Log.i(TAG, "onStart called");
			
			//TODO:
			//update the appropriate count variable
			onStartCounter++;
			//update the view
			TextView startTxtView = (TextView)findViewById(R.id.start);
			startTxtView.setText("onStart() calls: " + onStartCounter);

		}
		@Override
		public void onResume(){
			super.onResume();
			//Log cat print out
			Log.i(TAG, "onResume called");
			onResumeCounter++;
			//update the view
			TextView resumeTxtView = (TextView)findViewById(R.id.resume);
			resumeTxtView.setText("onResume() calls: " + onResumeCounter);

		}
		@Override
		public void onRestart(){
			super.onRestart();
			//Log cat print out
			Log.i(TAG, "onRestart called");
			onRestartCounter++;
			//update the view
			TextView restartTxtView = (TextView)findViewById(R.id.restart);
			restartTxtView.setText("onRestart() calls: " + onRestartCounter);

		}
		@Override
		public void onPause(){
			super.onPause();
			//Log cat print out
			Log.i(TAG, "onPause called");
			onPauseCounter++;
			//update the view
			TextView pauseTxtView = (TextView)findViewById(R.id.pause);
			pauseTxtView.setText("onPause() calls: " + onPauseCounter);
			prefs = getPreferences(MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();

			// set the key/value pairs
			editor.putInt("onDestroyCounter",onDestroyCounter);
			editor.putInt("onCreateCounter", onCreateCounter);
			editor.putInt("onResumeCounter", onResumeCounter);
			editor.putInt("onPauseCounter", onPauseCounter);
			editor.putInt("onRestartCounter", onRestartCounter);
			editor.putInt("onStopCounter", onStopCounter);
			editor.putInt("onCreateCounter", onCreateCounter);

			// don't forget to commit the changes
			editor.commit();

		}
		@Override
		public void onStop(){
			super.onStop();
			//Log cat print out
			Log.i(TAG, "onStop called");
			onStopCounter++;
			//update the view
			TextView stopTxtView = (TextView)findViewById(R.id.stop);
			stopTxtView.setText("onStop() calls: "+ onStopCounter);



		}
		@Override
		public void onDestroy(){
			super.onDestroy();
			//Log cat print out
			Log.i(TAG, "onDestroy called");
			onDestroyCounter++;
			//update the view
			TextView destroyTxtView = (TextView)findViewById(R.id.destroy);
			destroyTxtView.setText("onDestroy() calls: " + onDestroyCounter);

		}
	    // TODO: implement 5 missing lifecycle callback methods

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			//TODO:
			// save state information with a collection of key-value pairs
			// save all  count variables
			savedInstanceState.putInt("onCreateCounter", onCreateCounter);
			savedInstanceState.putInt("onStartCounter", onStartCounter);
			savedInstanceState.putInt("onResumeCounter", onResumeCounter);
			savedInstanceState.putInt("onPauseCounter", onPauseCounter);
			savedInstanceState.putInt("onRestartCounter", onRestartCounter);
			savedInstanceState.putInt("onStopCounter", onStopCounter);
			savedInstanceState.putInt("onDestroyCounter", onDestroyCounter);
			super.onSaveInstanceState(savedInstanceState);

		}
		
		public void launchActivityTwo(View view) {
			//TODO:
			// This function launches Activity Two. 
			// Hint: use Context’s startActivity() method.
			Intent intent =  new Intent(this,ActivityTwo.class);
			startActivity(intent);
		}

	/* public void saveActivityInfo(View view) {

		// SharedPreferences prefs = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();

		// set the key/value pairs
		 editor.putInt("onDestroyCounter",onDestroyCounter);
		 editor.putInt("onCreateCounter", onCreateCounter);
		 editor.putInt("onResumeCounter", onResumeCounter);
		 editor.putInt("onPauseCounter", onPauseCounter);
		 editor.putInt("onRestartCounter", onRestartCounter);
		 editor.putInt("onStopCounter", onStopCounter);
		 editor.putInt("onCreateCounter", onCreateCounter);

		// don't forget to commit the changes
		editor.commit();
	}*/
}
