package fi.qvik.androidkehitys.ouya.activity;

import tv.ouya.console.api.OuyaController;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import fi.qvik.androidkehitys.ouya.R;
import fi.qvik.androidkehitys.ouya.view.BattleGround;

public class MainActivity extends Activity {

	private final String TAG = "MainActivity";
	private BattleGround bg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		OuyaController.init(this);

		setContentView(R.layout.main_activity);
		
		bg = (BattleGround) findViewById(R.id.main_battle_ground);
	}

	@Override
	public boolean onKeyDown(final int keyCode, KeyEvent event) {
		// Get the player #
		boolean handled = false;

		// Handle the input
		switch (keyCode) {
			case OuyaController.BUTTON_O:
				Log.d(TAG, "OUYA button O");
				break;
			case OuyaController.BUTTON_U:
				Log.d(TAG, "OUYA button U");
				break;
			case OuyaController.BUTTON_Y:
				Log.d(TAG, "OUYA button Y");
				break;
			case OuyaController.BUTTON_A:
				Log.d(TAG, "OUYA button A");
				// You now have the key pressed and the player # that pressed it
				// doSomethingWithKey();
				handled = true;
				break;
		}
		return handled || super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onGenericMotionEvent(final MotionEvent event) {
	    // Joystick
		if ((event.getSource() & InputDevice.SOURCE_CLASS_JOYSTICK) != 0) {
			float LS_X = event.getAxisValue(OuyaController.AXIS_LS_X);
			float LS_Y = event.getAxisValue(OuyaController.AXIS_LS_Y);
			bg.move(LS_X, LS_Y);
		}

		return true;
	}

}
