package bw.com.administor.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qy.channel.ChannelActivity;
import com.qy.channel.bean.ChannelItem;
import com.qy.channel.db.DBUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 08:51:18
 * @Description:
 */
public class Frag1 extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<ChannelItem> channelItems;
    private ArrayList<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.pager);
        channelItems = DBUtil.getTabData(getActivity());
        fragments = new ArrayList<>();
        fragments.add(new Frag1_1());
        fragments.add(new Frag1_2());
        fragments.add(new Frag1_1());
        fragments.add(new Frag1_2());
        fragments.add(new Frag1_1());
        fragments.add(new Frag1_2());
        fragments.add(new Frag1_1());
        viewPager.setAdapter(new Adapter(getActivity().getSupportFragmentManager(),fragments,channelItems));
        tabLayout.setupWithViewPager(viewPager);
        view.findViewById(R.id.img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChannelActivity.class);
                startActivityForResult(intent,0);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==0){
             channelItems = DBUtil.getTabData(getActivity());
             for (int i=0;i<channelItems.size();i++){
                 String name = channelItems.get(i).getName();
                 tabLayout.addTab(tabLayout.newTab().setText(name));
             }

        }
        viewPager.setAdapter(new Adapter(getActivity().getSupportFragmentManager(),fragments,channelItems));
        tabLayout.setupWithViewPager(viewPager);
    }
}
