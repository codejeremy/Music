package cn.edu.nc.music;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.List;

import javax.microedition.khronos.opengles.GL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private ImageView main_search;
    private FrameLayout singers;
    private fragment_yueguan fragmentyueguan;
    private fragment_paihang fragmentPaihang;
    private fragment_challenge fragmentChallenge;
    private FrameLayout yueguan;
    private FrameLayout paihang;
    private FrameLayout tiaozhan;
    private LinearLayout navHeaderLl;
    private ImageView headerImg;
    private ListView mListView;
    private List<Song>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yueguan = findViewById(R.id.yueguan);
        paihang = findViewById(R.id.paihang);
        tiaozhan = findViewById(R.id.tiaozhan);
        main_search = findViewById(R.id.main_search);
        singers = findViewById(R.id.singer);

        /*
        * 查找跳转*/
        main_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, search.class);
                startActivity(intent);
            }
        });
        /*播放界面跳转*/
        singers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayPage.class);
                startActivity(intent);
            }
        });

        initDate();
        Clickyg();
        //侧滑
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /*glide渲染将侧滑的图片添加进去*/
        navHeaderLl = (LinearLayout) navigationView.inflateHeaderView(R.layout.nav_header_main);
        headerImg = navHeaderLl.findViewById(R.id.header_img);
        Glide.with(this).load(R.mipmap.slide_user).into(headerImg);
        Glide.with(this).load(R.mipmap.slide_back).centerCrop().into(new ViewTarget<View, GlideDrawable>
                (navHeaderLl) {

            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                this.view.setBackground(resource.getCurrent());
            }
        });
    }


    //碎片数据的获取
    public void initDate() {
        yueguan.setOnClickListener((View.OnClickListener) this);
        paihang.setOnClickListener((View.OnClickListener) this);
        tiaozhan.setOnClickListener((View.OnClickListener) this);
    }
    /*点击切换碎片界面*/
    public void Clickyg() {
        fragmentyueguan = new fragment_yueguan();
        android.support.v4.app.FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_framecontent, fragmentyueguan);
        fragmentTransaction.commit();
        yueguan.setSelected(true);
    }

    public void Clickph() {
        fragmentPaihang = new fragment_paihang();
        android.support.v4.app.FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_framecontent, fragmentPaihang);
        fragmentTransaction.commit();
        yueguan.setSelected(true);
    }

    public void Clicktz() {
        fragmentChallenge = new fragment_challenge();
        android.support.v4.app.FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_framecontent, fragmentChallenge);
        fragmentTransaction.commit();
        yueguan.setSelected(true);
    }

    /*侧滑*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /*侧滑内容点击事件*/
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.local_music) {
            // Handle the camera action
        } else if (id == R.id.dowland) {

        } else if (id == R.id.nearly_play) {

        } else if (id == R.id.I_like) {

        } else if (id == R.id.Messsage) {

        } else if (id == R.id.challenge) {
            Intent intent = new Intent(MainActivity.this, search.class);
            startActivity(intent);

        } else if (id == R.id.info) {

        } else if (id == R.id.settings) {

        }

        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*界面点击事件*/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yueguan:
                Clickyg();
                break;
            case R.id.paihang:
                Clickph();
                break;
            case R.id.tiaozhan:
                Clicktz();
                break;
        }
    }
    private void initView(){

    }
}
