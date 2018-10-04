package cn.edu.nc.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PlayPage extends AppCompatActivity implements View.OnClickListener {

    private FragmentPlayCi fragmentPlayCi;
    private ImageView playback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_page);
        playback = findViewById(R.id.playback);
        playback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayPage.this.finish();
            }
        });
        fragmentPlayCi = new FragmentPlayCi();
        android.support.v4.app.FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_framecontent2, fragmentPlayCi);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

    }
}
