package tienal.transition_y;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void bt1(View view) {
		startActivity(new Intent(this, AActivity.class));
	}

	public void bt2(View view) {
		startActivity(new Intent(this, RippleDrawableActivity.class));
	}

	public void bt3(View view) {
		startActivity(new Intent(this, CircularRevealActivity.class));
	}
}
