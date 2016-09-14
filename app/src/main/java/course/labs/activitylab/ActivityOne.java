package course.labs.activitylab;

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

		// lifecycle counts	
		//TODO:
		//Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		// You will need to increment these variables' values when their corresponding lifecycle methods get called.  
		private int onCreateCounter = 0;
		private int onStartCounter = 0;
		private int onResumeCounter = 0;
		private int onPauseCounter = 0;
		private int onStopCounter = 0;
		private int onRestartCounter = 0;
		private int onDestroyCounter = 0;

	@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);
			
			//Log cat print out
			Log.i(TAG, "onCreate called");
			
			//TODO:
			//update the appropriate count variable
				onCreateCounter++;
			//update the view
			TextView createTxtView = (TextView)findViewById(R.id.create);
			createTxtView.setText(createTxtView.getText() +"" + onCreateCounter);
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
			startTxtView.setText(startTxtView.getText() +"" + onStartCounter);
		}
		@Override
		public void onResume(){
			super.onResume();
			//Log cat print out
			Log.i(TAG, "onResume called");
			onResumeCounter++;
			//update the view
			TextView resumeTxtView = (TextView)findViewById(R.id.resume);
			resumeTxtView.setText(resumeTxtView.getText() +"" + onResumeCounter);
		}
		@Override
		public void onRestart(){
			super.onRestart();
			//Log cat print out
			Log.i(TAG, "onRestart called");
			onRestartCounter++;
			//update the view
			TextView restartTxtView = (TextView)findViewById(R.id.restart);
			restartTxtView.setText(restartTxtView.getText() +"" + onRestartCounter);

		}
		@Override
		public void onPause(){
			super.onPause();
			//Log cat print out
			Log.i(TAG, "onPause called");
			onPauseCounter++;
			//update the view
			TextView pauseTxtView = (TextView)findViewById(R.id.pause);
			pauseTxtView.setText(pauseTxtView.getText() +"" + onPauseCounter);

		}
		@Override
		public void onStop(){
			super.onStop();
			//Log cat print out
			Log.i(TAG, "onStop called");
			onStopCounter++;
			//update the view
			TextView stopTxtView = (TextView)findViewById(R.id.stop);
			stopTxtView.setText(stopTxtView.getText() +"" + onStopCounter);

		}
		@Override
		public void onDestroy(){
			super.onDestroy();
			//Log cat print out
			Log.i(TAG, "onDestroy called");
			onDestroyCounter++;
			//update the view
			TextView destroyTxtView = (TextView)findViewById(R.id.destroy);
			destroyTxtView.setText(destroyTxtView.getText() +"" + onDestroyCounter);

		}
	    // TODO: implement 5 missing lifecycle callback methods

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			//TODO:
			// save state information with a collection of key-value pairs
			// save all  count variables
		}
		
		public void launchActivityTwo(View view) {
			//TODO:
			// This function launches Activity Two. 
			// Hint: use Context’s startActivity() method.
		}
		

}
