package bw.com.administor.myapplication2;

import java.util.ArrayList;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 13:41:52
 * @Description:
 */
public class er {
//    {
//        "burden": "葱,适量;小辣椒,适量;盐,1勺;鸡精,0.25勺",
//            "id": "2582",
//            "imtro": "绿的菜心碧绿，红的小辣椒鲜艳，看了这样的一道菜在餐桌上，是不是感觉配碗白米饭吃吃就很香？ 很多人说鱼鱼做的菜漂亮，其实所有人做出的这样的炒蔬菜都是一个味道 只不过，鱼鱼更用心地去摆了摆盘子，整个餐桌就显得秀丽起来 我们生活，不止是为了吃 我们吃，也不仅仅就是为了品尝味道 现在大多数人不担心温饱问题，那就花上不到1分钟的时间 把炒好的菜菜在盘子里摆一下 让家人的心情都愉悦起来，让春天的气息也跑到餐桌上去吧",
//            "ingredients": "菜心,100g",
//
//        "tags": "家常菜;热菜;咸;10分钟内;炒;简单;干辣椒;孕妇;青少年;素菜;白菜薹;全菜系;1-2人;炒锅;中等难度",
//            "title": "素炒菜心"
//    }
private ArrayList<String> albums;
private  String burden;
    private  String id;
    private  String imtro;
    private  String ingredients;
    private ArrayList<yi> steps;
    private  String tags;
    private  String title;

    public er() {
    }

    public er(ArrayList<String> albums, String burden, String id, String imtro, String ingredients, ArrayList<yi> steps, String tags, String title) {
        this.albums = albums;
        this.burden = burden;
        this.id = id;
        this.imtro = imtro;
        this.ingredients = ingredients;
        this.steps = steps;
        this.tags = tags;
        this.title = title;
    }

    public ArrayList<String> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<String> albums) {
        this.albums = albums;
    }

    public String getBurden() {
        return burden;
    }

    public void setBurden(String burden) {
        this.burden = burden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImtro() {
        return imtro;
    }

    public void setImtro(String imtro) {
        this.imtro = imtro;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<yi> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<yi> steps) {
        this.steps = steps;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "er{" +
                "albums=" + albums +
                ", burden='" + burden + '\'' +
                ", id='" + id + '\'' +
                ", imtro='" + imtro + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", steps=" + steps +
                ", tags='" + tags + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
