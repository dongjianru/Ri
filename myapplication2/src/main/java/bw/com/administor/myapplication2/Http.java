package bw.com.administor.myapplication2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 10:30:48
 * @Description:
 */
public class Http {
    public  static boolean isNet(Context context){
        if (context!=null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info!=null){
                return info.isAvailable();
            }
        }
        return false;
    }
    public  static  String qing (String str){
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream stream = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
            String s="";
            StringBuffer buffer=new StringBuffer();
            while ((s=reader.readLine())!=null){
                buffer.append(s);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
