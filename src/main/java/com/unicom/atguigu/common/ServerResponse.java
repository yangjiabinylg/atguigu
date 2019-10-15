package com.unicom.atguigu.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/13.
 *
 *    这是一个非常通用的服务器 响应对象 写好了
 *
 *    封装通用的返回类型
 *
 *     我们返回的时候会对这个类进行序列化 给前端
 */
//@JsonSerialize 当返回失败的时候，这个data有的时候是null不需要显示要处理一下   智能感知ctrl+空格
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//数据为空不返回json
//保证序列化json的时候，如果是null的对象，key也会消失
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;//T 不可能是String类型  一定是类类型

    //不可外部调用   构造函数全部私有化

    //4种情况返回数据  私有的构造器
    private ServerResponse(int status) {
        this.status = status;
    }
    private ServerResponse(int status, String msg) {//string调用这个函数
        this.status = status;
        this.msg = msg;
    }
    private ServerResponse(int status, T data) {//非stirng调用这个
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * T = String
     *
     private ServerResponse(int status, String msg) {
     this.status = status;
     this.msg = msg;
     }
     private ServerResponse(int status, T data) {
     this.status = status;
     this.data = data;
     }
     */

//    public static void main(String[] args) {
//        ServerResponse sr1 = new ServerResponse(1.txt, new Object());//ctrl+鼠标看调用那个方法
//        ServerResponse sr2 = new ServerResponse(2, "aaa");
//
//        public 对外方法处理
//    }




    /**
     *   判断返回的是不是成功  0是成功的数据返回
     *
     *    我们返回的时候会对这个类进行序列化 给前端
     *    不加处理这个也会出现在json字符串中   @JsonIgnore   这样序列化后不会出现在json字符串中
     * */
    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        //return this.status == 0;
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    /**
     *    下面这3个get开头的方法
     *    都会出现在json字符串中
     *
     */
    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    /**
     *    创建对象成功   表示我们这个响应是ok的
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());//返回一个status
    }


    /**
     *     也是返回一个成功  但是有一个文本 供前端调用
     *
     *      这个方法解决了  调用第2个还是第三个构造器的问题
     *      createBySuccessMessage，createBySuccess
     */
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){//只会调用sring构造函数
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);//返回一个status和msg
    }


    /**
     *     也是返回一个成功
     *     创建一个成功的服务器响应  data也填充进去
     *
     *
     *     这个方法解决了  调用第2个还是第三个构造器的问题
     *      createBySuccessMessage，createBySuccess
     */
    public static <T> ServerResponse<T> createBySuccess(T  data){//只会调用T数据   上面函数和这个函数名不用所以不可能调用出错
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);//返回一个status和data
    }

    /**
     *     也是返回一个成功    msg 和 data 都填充进去
     *     创建一个成功的服务器响应  data也填充进去
     *
     */
    public static <T> ServerResponse<T> createBySuccess(String msg,T  data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);//返回一个status,msg和data
    }


    /**
     *   创建失败
     */
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    /**
     *   创建失败 并 返回提示   注册用户是提示用好用户名已经存在了
     */
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    /*
     *     服务端响应
     */
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode , String errorMessage){
        return new ServerResponse<T>( errorCode , errorMessage);
    }







//    public static void main(String[] args) {
//        ServerResponse serverResponse = new ServerResponse(1.txt, new Object());
//        ServerResponse serverResponse2 = new ServerResponse(1.txt, "abc");
//        System.out.println("console");
//    }


}