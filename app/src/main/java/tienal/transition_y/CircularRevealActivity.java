package tienal.transition_y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

public class CircularRevealActivity extends AppCompatActivity {

	private View targetView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circular_reveal);
		targetView = findViewById(R.id.targetView);

	}

	public void cr1(View view) {
		final int width = targetView.getMeasuredWidth();
		final int height = targetView.getMeasuredHeight();
		final float radius = (float) Math.sqrt(width * width + height * height) / 2;//半径
		Animator animator = ViewAnimationUtils.createCircularReveal(targetView, width / 2, height / 2, radius, 0);
		animator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				targetView.setVisibility(View.GONE);
			}
		});
		animator.setDuration(2000l);
		animator.start();
	}
}
