/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curempesasmsdaemon;

import TEST.MPESA_C2B_Generate_Token_TEST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
//how to fix this 
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author nips
 */
public class MPESA_C2B_Process_Request {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //new MPESA_C2B_Process_Request_TEST().GenerateAuthentication("174379","254725974097","1");
        new MPESA_C2B_Process_Request().GenerateAuthentication("622317","254741155054","10");

    }

    public String GenerateAuthentication(String business_no,String msisdn,String amount) {
        String data = "";
        String url = "";

        //url = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";//test
        url="https://api.safaricom.co.ke/mpesa/stkpush/v1/processrequest";//live
        try {

            HttpClient client = new DefaultHttpClient();
            HttpPost request = new HttpPost(url);
            request.addHeader("Content-type", "application/json");
            request.addHeader("Authorization", "Bearer " + new MPESA_C2B_Generate_Token_TEST().GenerateAuthentication11());

            String json = "{\n  \"BusinessShortCode\" : \""+business_no+"\",\n  \"Password\" : \"NjIyMzE3NDg1ZWI0OTI0YzVlMkjdjhdfkjdshfdsfkjd0YTM3ZWY2NWY5ZTkzsdfdsfdsTQxNDM4\",\n  \"Timestamp\" : \"20180810141438\",\n  \"TransactionType\" : \"CustomerPayBillOnline\",\n  \"Amount\" : \""+amount+"\",\n  \"PartyA\" : \""+msisdn+"\",\n  \"PartyB\" : \""+business_no+"\",\n  \"PhoneNumber\" : \""+msisdn+"\",\n  \"CallBackURL\" : \"https://c8febd61.ngrok.io\",\n  \"AccountReference\" : \""+msisdn+"\",\n  \"TransactionDesc\" : \"DS\"\n}";
             System.out.println("\nJSON::::::::::::: " + json);
            StringEntity entity = new StringEntity(json);
            request.setEntity(entity);

           

            HttpResponse response = client.execute(request);
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            //String token=data.substring(data.indexOf("\"access_token\": \"")+17,data.indexOf("\","));
            //data=token;
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;

    }

}
