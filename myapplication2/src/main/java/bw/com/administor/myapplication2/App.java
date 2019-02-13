package bw.com.administor.myapplication2;

import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qy.channel.ChannelActivity;
import com.qy.channel.app.ChannelApplication;

import java.io.File;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 09:57:00
 * @Description:
 */
public class App extends ChannelApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        String path=Environment.getExternalStorageDirectory().getPath()+"/RiKao14";
        File file = new File(path);
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(200,200)
                .memoryCacheSize(2*1024*1024)
                .threadPriority(1000)
                .threadPoolSize(3)
                .diskCacheSize(50*1024*1024)
                .diskCache(new UnlimitedDiskCache(file))
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheFileCount(50)
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
