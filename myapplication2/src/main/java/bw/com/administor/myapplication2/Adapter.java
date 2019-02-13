package bw.com.administor.myapplication2;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qy.channel.bean.ChannelItem;

import java.util.ArrayList;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 09:33:32
 * @Description:
 */
public class Adapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list1;
    private ArrayList<ChannelItem> channelItems;
    public Adapter(FragmentManager fm, ArrayList<Fragment> list1, ArrayList<ChannelItem> channelItems) {
        super(fm);
        this.list1 = list1;
        this.channelItems=channelItems;
    }

    @Override
    public Fragment getItem(int i) {
        return list1.get(i);
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return channelItems.get(position).name;
    }
}
