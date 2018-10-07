package cn.edu.nc.music.Fragment;

import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.edu.nc.music.R;

public class FragmentYueguan extends android.support.v4.app.Fragment implements View.OnClickListener {
    private LinearLayout song;
    private LinearLayout singer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_yueguan, container, false);

        return view;
    }
    @Override
    public void onClick(View v) {

    }
}
