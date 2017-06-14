package tienal.transition_y;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AActivity extends AppCompatActivity {
	private RecyclerView mRecyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
//		getWindow().setEnterTransition(new Explode());
//		getWindow().setExitTransition(new ChangeImageTransform());
		mRecyclerView = (RecyclerView) findViewById(R.id.rv1);
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setAdapter(new NAdapter());
	}

	public class NAdapter extends RecyclerView.Adapter<NAdapter.ViewHolder> {


		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			return new ViewHolder(LayoutInflater.from(AActivity.this).inflate(R.layout.item, parent, false));
		}

		@Override
		public void onBindViewHolder(ViewHolder holder, int position) {
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					ActivityOptionsCompat aop =ActivityOptionsCompat.makeSceneTransitionAnimation(AActivity.this,
							new Pair<View, String>(view.findViewById(R.id.iv_icon), "123"),
							new Pair<View, String>(view.findViewById(R.id.tv), "222"));
//					ActivityOptionsCompat aop = ActivityOptionsCompat.makeSceneTransitionAnimation(AActivity.this,
//							view.findViewById(R.id.iv_icon), "123");
					//指定imageView为共享元素，注意“123”,必须和SecondActivity**中共享的元素名称一致**，此处共享的元素可以是多个，多个元素，查看makeSceneTransitionAnimation的重载方法
					Intent intent = new Intent(getApplicationContext(), BActivity.class);
					ActivityCompat.startActivity(AActivity.this, intent, aop.toBundle());
				}
			});
		}

		@Override
		public int getItemCount() {
			return 10;
		}

		public class ViewHolder extends RecyclerView.ViewHolder {

			public ViewHolder(View itemView) {
				super(itemView);
			}
		}
	}
}
