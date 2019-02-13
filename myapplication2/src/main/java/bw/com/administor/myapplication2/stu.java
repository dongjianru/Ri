package bw.com.administor.myapplication2;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 16:27:04
 * @Description:
 */
public class stu {
    private String zhu_name;
    private int zh_img ;

    public stu(String zhu_name, int zh_img) {
        this.zhu_name = zhu_name;
        this.zh_img = zh_img;
    }

    public String getZhu_name() {
        return zhu_name;
    }

    public void setZhu_name(String zhu_name) {
        this.zhu_name = zhu_name;
    }

    public int getZh_img() {
        return zh_img;
    }

    public void setZh_img(int zh_img) {
        this.zh_img = zh_img;
    }

    @Override
    public String toString() {
        return "stu{" +
                "zhu_name='" + zhu_name + '\'' +
                ", zh_img=" + zh_img +
                '}';
    }
}
