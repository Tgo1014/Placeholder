package tgo1014.placeholder.data.network


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tgo1014.placeholder.BuildConfig
import tgo1014.placeholder.data.network.services.AnyService

object RestClient {

    private val anyService: AnyService

    init {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor)
        }

        val client = okHttpBuilder.build()

        val retrofit = Retrofit.Builder().baseUrl("") //TODO
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        anyService = retrofit.create(AnyService::class.java)
    }

}