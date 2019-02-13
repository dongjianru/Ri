package bw.com.administor.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 16:29:57
 * @Description:
 */
public class M_Adapter extends BaseAdapter {
    private ArrayList<stu> list;
    private Context context;
    private ViewHolder holder;

    public M_Adapter(ArrayList<stu> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView=LayoutInflater.from(context).inflate(R.layout.zhu_item,null);
            holder = new ViewHolder();
            holder.m_img = convertView.findViewById(R.id.m_img);
            holder.m_name = convertView.findViewById(R.id.m_name);
            convertView.setTag(holder);
        }else{
           holder= (ViewHolder) convertView.getTag();
        }
        holder.m_name.setText(list.get(position).getZhu_name());
        holder.m_img.setImageResource(list.get(position).getZh_img());
        return convertView;
    }
    class  ViewHolder{
        ImageView m_img;
        TextView m_name;
    }
}
