package fi.qvik.androidkehitys.ouya.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import fi.qvik.androidkehitys.ouya.R;

public class BattleGround extends FrameLayout {

	private final String TAG = "BattleGround";

	private ImageView plane;
	private LayoutParams params;
	private float x = 0;
	private float y = 0;

	public BattleGround(Context context) {
		super(context);
		init();
	}

	public BattleGround(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BattleGround(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		plane = new ImageView(getContext());
		plane.setImageResource(R.drawable.ic_launcher);
		addView(plane);

		params = (LayoutParams) plane.getLayoutParams();
		params.height = 100;
		params.width = 100;
	}

	/**
	 * Move plane on the {@link BattleGround}
	 * 
	 * @param dx
	 * @param dy
	 */
	public void move(float dx, float dy) {
		// give the plane speed
		x += dx * 5;
		y += dy * 5;
		int width = getWidth();
		int height = getHeight();

		if (x > width) {
			x = width;
		} else if (x < 0) {
			x = 0;
		}

		if (y > height) {
			y = height;
		} else if (y < 0) {
			y = 0;
		}

		// move the plane
		params.leftMargin = (int) x;
		params.topMargin = (int) y;
		plane.setLayoutParams(params);
	}

}
