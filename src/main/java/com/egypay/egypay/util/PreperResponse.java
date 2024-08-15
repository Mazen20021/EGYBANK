package com.egypay.egypay.util;


import com.egypay.egypay.Models.GeneralResponse;

public class PreperResponse {


   public static GeneralResponse preperResponse (Object data , String message , String code)
    {
        GeneralResponse response = new GeneralResponse();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }


}
