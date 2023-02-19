package org.scaler;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpLib {
    OkHttpClient client;

    public HttpLib()
    {
        client = new OkHttpClient();

    }

    String getExampleDotCom()
    {
        var request= new Request.Builder()
                .url("https://example.com")
                .build();

        try(Response response= client.newCall(request).execute())
        {
            return response.body().string();
        }
        catch(Exception ex)
        {
             return ex.getMessage();
        }
    }

}
