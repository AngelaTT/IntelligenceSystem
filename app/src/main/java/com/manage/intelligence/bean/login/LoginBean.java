package com.manage.intelligence.bean.login;

import java.io.Serializable;
import java.util.List;

public class LoginBean implements Serializable {
    private String result;

    private List<Data> data;

    public void setResult(String result){
        this.result = result;
    }
    public String getResult(){
        return this.result;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }

    public class Data implements Serializable
    {
        private String P_MENU_CODE;

        private String MENU_NAME;

        private String MENU_CODE;

        private String MENU_NAME1;

        public void setP_MENU_CODE(String P_MENU_CODE){
            this.P_MENU_CODE = P_MENU_CODE;
        }
        public String getP_MENU_CODE(){
            return this.P_MENU_CODE;
        }
        public void setMENU_NAME(String MENU_NAME){
            this.MENU_NAME = MENU_NAME;
        }
        public String getMENU_NAME(){
            return this.MENU_NAME;
        }
        public void setMENU_CODE(String MENU_CODE){
            this.MENU_CODE = MENU_CODE;
        }
        public String getMENU_CODE(){
            return this.MENU_CODE;
        }
        public void setMENU_NAME1(String MENU_NAME1){
            this.MENU_NAME1 = MENU_NAME1;
        }
        public String getMENU_NAME1(){
            return this.MENU_NAME1;
        }
    }
}
