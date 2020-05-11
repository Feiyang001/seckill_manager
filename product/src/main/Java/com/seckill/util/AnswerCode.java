package com.seckill.util;

import java.util.HashMap;

public class AnswerCode extends HashMap{
    public static  String SUCCESS_CODE="200";
    public static String ERROR_CODE="500";
    public static String DATA_KEY = "data";
    public static String MSG_KEY = "msg";

    private AnswerCode(){

    }

    public AnswerCode set(String key, Object object){
        super.put(key,object);
        return  this;
    }

    private  static AnswerCode ok(){
        return new AnswerCode();
    }

    public static AnswerCode success(){

        return AnswerCode.ok().set("code", AnswerCode.SUCCESS_CODE).set(AnswerCode.MSG_KEY,"操作成功");
    }

    public static AnswerCode success(String msg){

        return AnswerCode.ok().set("code", AnswerCode.SUCCESS_CODE).set(AnswerCode.MSG_KEY,msg);
    }

    public static AnswerCode success(String msg, Object object){

        return AnswerCode.ok().set("code", AnswerCode.SUCCESS_CODE).set(AnswerCode.MSG_KEY,msg).set(AnswerCode.DATA_KEY,object);
    }

    public AnswerCode data(Object obj){
        return this.set("data",obj);
    }

    public static AnswerCode error(){
        return AnswerCode.ok().set(AnswerCode.MSG_KEY,"操作失败").set("code", AnswerCode.ERROR_CODE);
    }

    public static AnswerCode error(String msg){
        return AnswerCode.ok().set(AnswerCode.MSG_KEY,msg).set("code", AnswerCode.ERROR_CODE);
    }

    public static AnswerCode error(String msg, Object object){
        return AnswerCode.ok().set(AnswerCode.MSG_KEY,msg).set(AnswerCode.DATA_KEY,object).set("code", AnswerCode.ERROR_CODE);
    }

}
