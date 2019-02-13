package bw.com.administor.myapplication2;

import java.util.ArrayList;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 13:48:08
 * @Description:
 */
public class result {
    private ArrayList<er> data;
    private String pn;
    private String rn;
    private String totalNum;

    public result() {
    }

    public result(ArrayList<er> data, String pn, String rn, String totalNum) {
        this.data = data;
        this.pn = pn;
        this.rn = rn;
        this.totalNum = totalNum;
    }

    public ArrayList<er> getData() {
        return data;
    }

    public void setData(ArrayList<er> data) {
        this.data = data;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "result{" +
                "data=" + data +
                ", pn='" + pn + '\'' +
                ", rn='" + rn + '\'' +
                ", totalNum='" + totalNum + '\'' +
                '}';
    }
}
