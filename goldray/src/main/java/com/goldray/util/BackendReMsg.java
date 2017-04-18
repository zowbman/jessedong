package com.goldray.util;

/**
 * Created by zwb on 2017/4/11.
 */
public class BackendReMsg {
    public static String SUCCESS = "SUCCESS";
    public static String PARAM_ERROR = "参数错误,";
    public static String TYPE_ERROR = PARAM_ERROR + "type参数值非'add'或'edit'";
    public static String ID_ERROR = PARAM_ERROR + "id参数值error,值为0";
    public static String SERVER_ERROR = "错误,";
    public static String CATREGORIESSAVE_ERROR = SERVER_ERROR + "产品分类内容编辑保存失败";
    public static String CATREGORIESDELETE_ERROR = SERVER_ERROR + "产品分类删除失败";
    public static String BANNERFILEIO_ERROR = SERVER_ERROR + "banner图片文件保存失败";
    public static String BANNERSAVE_ERROR = SERVER_ERROR + "banner内容编辑保存失败";
    public static String BANNERDELETE_ERROR = SERVER_ERROR + "banner删除失败";
    public static String IMGEMPTY_ERROR = SERVER_ERROR + "图片不允许为空";
    public static String RICHTYPE_ERROR = SERVER_ERROR + "richType参数值非'0'或'1'或'2'";
    public static String RICHTEXTSAVE_ERROR = SERVER_ERROR + "richText保存失败";
    public static String UEDITORUPLOAD_ERROR = SERVER_ERROR + "上传文件失败";
}