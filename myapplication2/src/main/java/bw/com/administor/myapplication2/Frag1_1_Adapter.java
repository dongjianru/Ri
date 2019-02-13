package bw.com.administor.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 14:52:49
 * @Description:
 */
public class Frag1_1_Adapter extends BaseAdapter {
    private ArrayList<yi> yiArrayList;
    private Context context;
    private ViewHolder holder;

    public Frag1_1_Adapter(ArrayList<yi> yiArrayList, Context context) {
        this.yiArrayList = yiArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return yiArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item,null);
            holder = new ViewHolder();
            holder.i_img=convertView.findViewById(R.id.i_img);
            holder.i_name=convertView.findViewById(R.id.i_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.i_name.setText(yiArrayList.get(position).getStep());
        DisplayImageOptions options=new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoader.getInstance().displayImage(yiArrayList.get(position).getImg(),holder.i_img,options);
        return convertView;
    }
    class ViewHolder{
        ImageView i_img;
        TextView i_name;
    }
}
