package com.example.produck.util;

import com.example.produck.dto.Resoult;
import com.example.produck.enums.exceptionEnum;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/22 12:44
 * @description：
 */
public class ResoultUtil {

    //成功
    public static Resoult success(Object data){
        Resoult resoult=new Resoult();
        resoult.setCode(200);
        resoult.setMsg("成功");
        resoult.setData(data);
        return resoult;
    }

    public static Resoult success(){
        return success(null);
    }

    //失败
    public static Resoult error(Integer code,String msg){
        Resoult resoult=new Resoult();
        resoult.setCode(code);
        resoult.setMsg(msg);
        return resoult;
    }

    public static Resoult error(exceptionEnum emuns){
        return error(emuns.getCode(),emuns.getMsg());
    }
}
