import org.junit.jupiter.api.Test;
import org.scaler.JSONPlaceholderAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PhotosAPITests {

    @Test
    public void testGetPhotos() throws IOException {


        var api= JSONPlaceholderAPI.getInstance();
        var photos=api.getPhotos().execute().body();

        assertEquals(5000,photos.size());


    }
}
