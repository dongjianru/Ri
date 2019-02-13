package bw.com.administor.myapplication2;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 08:51:18
 * @Description:
 */
public class Frag1_1 extends Fragment {
    private PullToRefreshListView listView;
    private Dao dao;
    private long l;
    private ArrayList<yi> yiArrayList;
    private Frag1_1_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_1, container, false);
        listView = view.findViewById(R.id.pull_list);
        dao = new Dao(getActivity());
        new Thread(){
            @Override
            public void run() {
                super.run();
                boolean b = Http.isNet(getActivity());
                if (b){
                    String s = Http.qing("http://apis.juhe.cn/cook/query?key=527e2a5b0406daea4e3b3d373c8ac850&menu=%E7%82%92%E9%A5%AD&rn=10&pn=3");
                    Gson gson = new Gson();
                    san san = gson.fromJson(s, san.class);
                    er er = san.getResult().getData().get(0);
                    yiArrayList = er.getSteps();
                    Message message = new Message();
                    message.obj= yiArrayList;
                    message.what=0;
                    handler.sendMessage(message);
                }else {
                    Message message = new Message();
                    message.what=1;
                    handler.sendMessage(message);
                }
            }
        }.start();
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setScrollingWhileRefreshingEnabled(true);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        boolean b = Http.isNet(getActivity());
                        if (b){
                            String s = Http.qing("http://apis.juhe.cn/cook/query?key=527e2a5b0406daea4e3b3d373c8ac850&menu=%E7%82%92%E9%A5%AD&rn=10&pn=3");
                            Gson gson = new Gson();
                            san san = gson.fromJson(s, san.class);
                            er er = san.getResult().getData().get(0);
                            yiArrayList = er.getSteps();
                            Message message = new Message();
                            message.obj=yiArrayList;
                            message.what=2;
                            handler.sendMessage(message);
                        }else {
                           Toast.makeText(getActivity(),"没网啦",Toast.LENGTH_SHORT).show();
                        }
                    }
                }.start();
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        boolean b = Http.isNet(getActivity());
                        if (b){
                            String s = Http.qing("http://apis.juhe.cn/cook/query?key=527e2a5b0406daea4e3b3d373c8ac850&menu=%E7%82%92%E9%A5%AD&rn=10&pn=3");
                            Gson gson = new Gson();
                            san san = gson.fromJson(s, san.class);
                            er er = san.getResult().getData().get(0);
                            ArrayList<yi>  yiArrayList1 = er.getSteps();
                            yiArrayList.addAll(yiArrayList1);
                            Message message = new Message();
                            message.obj=yiArrayList;
                            message.what=3;
                            handler.sendMessage(message);
                        }else {
                            Toast.makeText(getActivity(),"没网啦",Toast.LENGTH_SHORT).show();
                        }
                    }
                }.start();
            }
        });
        return view;
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                yiArrayList= (ArrayList<yi>) msg.obj;
                Cursor query = dao.query("person", null, null, null, null, null, null);
                if (query.moveToFirst()){
                    Toast.makeText(getActivity(),"已存在数据",Toast.LENGTH_SHORT).show();
                }else {
                    ContentValues values = new ContentValues();
                    for (int i=0;i<yiArrayList.size();i++){
                        values.put("img",yiArrayList.get(i).getImg());
                        values.put("step",yiArrayList.get(i).getStep());
                        l = dao.insert("person", null, values);
                    }
                    if (l>0){
                        Toast.makeText(getActivity(),"添加成功",Toast.LENGTH_SHORT).show();
                    }
                }
                adapter=new  Frag1_1_Adapter(yiArrayList,getActivity());
                listView.setAdapter(adapter);
            }else if(msg.what==1){
                ArrayList<yi> yiArrayList = new ArrayList<>();
                Cursor query = dao.query("person", null, null, null, null, null, null);
                if (query.moveToFirst()){
                    do {
                        String img = query.getString(query.getColumnIndex("img"));
                        String step = query.getString(query.getColumnIndex("step"));
                        yiArrayList.add(new yi(img,step));
                    }while (query.moveToNext());
                }
                adapter=new  Frag1_1_Adapter(yiArrayList,getActivity());
                listView.setAdapter(adapter);
            }else  if (msg.what==2){
                yiArrayList= (ArrayList<yi>) msg.obj;
                adapter = new Frag1_1_Adapter(yiArrayList, getActivity());
                listView.setAdapter(adapter);
               listView.onRefreshComplete();
            }
            else  if (msg.what==3){
                yiArrayList= (ArrayList<yi>) msg.obj;
                adapter.notifyDataSetChanged();
                listView.onRefreshComplete();
            }
        }
    };
}
