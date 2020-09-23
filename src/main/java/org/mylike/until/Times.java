package org.mylike.until;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 时间类
 * Created by Administrator on 2020/9/22.
 */
public class Times {

    /**
     * date类型转换
     * @param date Java date类
     * @return 数据库date类型
     */
    public static Timestamp dateTosql(Date date){
                if (date==null)return null;
                return new Timestamp(date.getTime());
    }

}
