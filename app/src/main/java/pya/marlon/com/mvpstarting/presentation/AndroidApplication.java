package pya.marlon.com.mvpstarting.presentation;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import pya.marlon.com.mvpstarting.domain.ro.RetrofitService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marlonpya on 21/06/17.
 */

public class AndroidApplication extends Application {
    private static AndroidApplication instance;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);
        Realm.setDefaultConfiguration(getRealmConfiguration());
    }

    private RealmConfiguration getRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .name("startingMVP.db")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    public RetrofitService getService(){
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(getRequestHeader())
                    .build();
        }

        return retrofit.create(RetrofitService.class);
    }

    private OkHttpClient getRequestHeader() {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.newBuilder().readTimeout(5000, TimeUnit.SECONDS);
        httpClient.newBuilder().connectTimeout(5000, TimeUnit.SECONDS);
        return httpClient;
    }


    public static AndroidApplication getInstance() {
        return instance;
    }
}
