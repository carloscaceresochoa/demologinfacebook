package com.usb.appfacebook.modelo;

public class Credencial {

        public int validar(String user,String pass){
            int ret=0;
            if(user.equals("c@hotmail.com")  && pass.equals("123456")){
                ret=1;
            }

            return ret;
        }



}
