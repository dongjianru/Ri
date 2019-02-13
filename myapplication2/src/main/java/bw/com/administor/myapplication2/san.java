package bw.com.administor.myapplication2;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 13:50:42
 * @Description:
 */
public class san {
//    {
//        "error_code": 0,
//            "reason": "Success",
//            "result": {
//////
//////    },
//        "resultcode": "200"
//    }
    private String error_code;
    private String reason;
    private result result;
    private String resultcode;

    public san() {
    }

    public san(String error_code, String reason, bw.com.administor.myapplication2.result result, String resultcode) {
        this.error_code = error_code;
        this.reason = reason;
        this.result = result;
        this.resultcode = resultcode;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public bw.com.administor.myapplication2.result getResult() {
        return result;
    }

    public void setResult(bw.com.administor.myapplication2.result result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    @Override
    public String toString() {
        return "san{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", resultcode='" + resultcode + '\'' +
                '}';
    }
}
