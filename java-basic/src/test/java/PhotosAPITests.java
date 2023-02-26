import org.junit.jupiter.api.Test;
import org.scaler.JSONPlaceholderAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotosAPITests {

    @Test
    public void testGetPhotos() throws IOException {
        Retrofit retrofit= new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        var api= retrofit.create(JSONPlaceholderAPI.class);
        var photos=api.getPhotos().execute().body();

        assertEquals(5000,photos.size());


    }
}
