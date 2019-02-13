package bw.com.administor.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView pullToRefreshListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pullToRefreshListView = findViewById(R.id.pull_listview);
        new Thread(){
            @Override
            public void run() {
                super.run();
                boolean b = http.isNet(MainActivity.this);
                if(b){
                    http.qing("");
                }
            }
        }.start();
    }
}
