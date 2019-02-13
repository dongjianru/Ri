package bw.com.administor.myapplication2;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private RadioGroup group;
    private FragmentManager manager;
    private ImageView imageView;
    private DrawerLayout drawerLayout;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.main_img);
        drawerLayout = findViewById(R.id.draw);
        listView = findViewById(R.id.listview);
        ArrayList<stu> list = new ArrayList<>();
        list.add(new stu("分类",R.drawable.kjh));
        list.add(new stu("我的",R.drawable.kk));
        list.add(new stu("个人",R.drawable.kkk));
        list.add(new stu("时间",R.drawable.kl));
        list.add(new stu("钱包",R.drawable.kll));
        listView.setAdapter(new M_Adapter(list,MainActivity.this));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(MainActivity.this,"侧栏正在打开",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(MainActivity.this,"侧栏正在关闭",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .displayer(new CircleBitmapDisplayer())
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoader.getInstance().displayImage("https://img-blog.csdnimg.cn/20190116193812274.jpg",imageView,options);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        transaction.add(R.id.frame,frag1);
        transaction.add(R.id.frame,frag2);
        transaction.add(R.id.frame,frag3);
        transaction.add(R.id.frame,frag4);
        transaction.show(frag1).hide(frag2).hide(frag3).hide(frag4).commit();
        group = findViewById(R.id.group);
        group.check(group.getChildAt(0).getId());
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.r1:
                        transaction.show(frag1).hide(frag2).hide(frag3).hide(frag4).commit();
                        break;
                    case R.id.r2:
                        transaction.show(frag2).hide(frag1).hide(frag3).hide(frag4).commit();
                        break;

                    case R.id.r3:
                        transaction.show(frag3).hide(frag1).hide(frag2).hide(frag4).commit();
                        break;
                    case R.id.r4:
                        transaction.show(frag4).hide(frag1).hide(frag2).hide(frag3).commit();
                        break;
                }
            }
        });
    }
}
