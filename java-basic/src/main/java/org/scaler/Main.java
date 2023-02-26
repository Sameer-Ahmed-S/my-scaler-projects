package org.scaler;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(Lib.getGreeting());

        if(args.length>0  && args[0].equals("example"))
        {
            var httpLib= new HttpLib();
            System.out.print(httpLib.getExampleDotCom());
        }
        else if(args.length>0 && args[0].equals("posts"))
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build();

            JSONPlaceholderAPI service= retrofit.create(JSONPlaceholderAPI.class);

            Call<List<Post>> posts = service.getPosts();

            posts.execute().body().forEach(data->{
                System.out.println(data.getTitle());
            });
        }
        else if(args.length>0 && args[0].equals("photos"))
        {

            Retrofit retrofit= new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build();

            JSONPlaceholderAPI service= retrofit.create(JSONPlaceholderAPI.class);
            Call<List<Photo>> photos= service.getPhotos();

            photos.execute().body().forEach(data->{
               System.out.println(data.toString());
            });
        }






    }
}