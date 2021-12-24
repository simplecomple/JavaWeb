package Utils;

import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

public class IdUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
    //生成商品编号
    public static Integer getProductId(){
        SimpleDateFormat s = new SimpleDateFormat("SS");
        StringBuffer temp = new StringBuffer(s.format(new Date()));
        String p_id = temp.toString();
        return Integer.parseInt(p_id);
    }
    //生成用户编号
    public static Integer getUserId(){
        int index = (int)(Math.random() * 1000);
        return Integer.valueOf(index);
    }

}
