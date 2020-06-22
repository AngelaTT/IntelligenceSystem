package com.manage.intelligence.bean;

import java.io.Serializable;
import java.util.List;

/**
* 功能菜单
* */
public class FunctionManageBean implements Serializable {

    private String title;

    private List<FunctionItem> functionItems;

    public FunctionManageBean(String title, List<FunctionItem> functionItems) {
        this.title = title;
        this.functionItems = functionItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FunctionItem> getFunctionItems() {
        return functionItems;
    }

    public void setFunctionItems(List<FunctionItem> functionItems) {
        this.functionItems = functionItems;
    }

    @Override
    public String toString() {
        return "FunctionManageBean{" +
                "title='" + title + '\'' +
                ", functionItems=" + functionItems +
                '}';
    }

    public FunctionManageBean() {
        super();
    }
    //    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public List<FunctionItem> getFunctionItems() {
//        return functionItems;
//    }
//
//    public void setFunctionItems(List<FunctionItem> functionItems) {
//        this.functionItems = functionItems;
//    }

    public static class FunctionItem {

        private int id;
        private String name;
        private String icon;
        private int num;//未处理的消息

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }


}
