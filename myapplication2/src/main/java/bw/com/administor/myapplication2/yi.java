package bw.com.administor.myapplication2;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 13:38:30
 * @Description:
 */
public class yi {
//    {
//        "img": "http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/26/2582_6fca0e2abb581d3f.jpg",
//            "step": "1.菜心洗净，沥干水分。辣椒和葱切碎备用"
//    }
    private  String img;
    private  String step;

    public yi(String img, String step) {
        this.img = img;
        this.step = step;
    }

    public yi() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "yi{" +
                "img='" + img + '\'' +
                ", step='" + step + '\'' +
                '}';
    }
}
