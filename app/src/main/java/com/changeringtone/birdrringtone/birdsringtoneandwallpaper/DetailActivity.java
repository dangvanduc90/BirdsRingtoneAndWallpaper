package com.changeringtone.birdrringtone.birdsringtoneandwallpaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton ibtnBack, ibtnSetAs, ibtnPlay, ibtnAlarm, ibtnSetWallPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int position = bundle.getInt("position");
        Log.d("position", position + "");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibtnBack:
                startActivity(new Intent(DetailActivity.this, MainActivity.class));
                break;
            case R.id.ibtnSetAs:

                break;
        }
    }
}
