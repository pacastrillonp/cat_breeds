package co.pacastrillonp.catbreeds.network

import co.pacastrillonp.catbreeds.enviroment.Constants
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(Constants.Api.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(get<Converter.Factory>())
            .addCallAdapterFactory(get<CallAdapter.Factory>())
            .build()
    }

    single {
        OkHttpClient.Builder().apply {
            addInterceptor(get<HttpHeadersInterceptor>())
        }.build()
    }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single<ApiProvider> { get<Retrofit>().create(ApiProvider::class.java) }

    single<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }

    factory<HttpHeaderSigner> { CryptoHttpHeaderSigner() }

    factory { HttpHeadersInterceptor(get()) }
}