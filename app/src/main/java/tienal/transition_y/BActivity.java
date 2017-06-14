package tienal.transition_y;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class BActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
//		getWindow().setEnterTransition(new Explode());
		ImageView imageView = (ImageView) findViewById(R.id.iv_icon);
		TextView textView = (TextView) findViewById(R.id.tv);
		//设置共享元素，注意："123"必须和MainActivity中的一致
		ViewCompat.setTransitionName(imageView, "123");
		ViewCompat.setTransitionName(textView, "222");
	}
}
