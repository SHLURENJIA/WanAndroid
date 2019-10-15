package com.shawn.wanandroid.http

import com.shawn.wanandroid.api.ApiService
import com.shawn.wanandroid.app.App
import com.shawn.wanandroid.common.Contanst
import com.shawn.wanandroid.utils.PreferenceUtil
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * 作者：create by @author{ YSH } on 2019/10/11
 * 描述:
 * 修改备注:
 */
object NetManager {
    private var mClient: OkHttpClient? = null
    private var mRetrofit: Retrofit? = null

    val service: ApiService by lazy { getRetrofit()!!.create(ApiService::class.java) }

    private var token: String by PreferenceUtil("token", "")

    private fun getRetrofit(): Retrofit? {
        if (mRetrofit == null) {
            synchronized(NetManager::class.java) {
                if (mRetrofit == null) {
                    //添加一个log拦截器，打印所有的请求
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                    //设置请求的缓存大小和位置
                    val cacheFile = File(App.context.cacheDir, "cache")
                    val cache = Cache(cacheFile, 1024 * 1024 * 50)//50M

                    mClient = OkHttpClient.Builder()
                        .addInterceptor(addQueryParameterInterceptor())
                        .addInterceptor(addHeaderInterceptor())
                        .addInterceptor(httpLoggingInterceptor)
                        .cache(cache)
                        .connectTimeout(60L, TimeUnit.SECONDS)
                        .readTimeout(60L, TimeUnit.SECONDS)
                        .writeTimeout(60L, TimeUnit.SECONDS)
                        .build()

                    mRetrofit = Retrofit.Builder()
                        .baseUrl(Contanst.BASE_URL)
                        .client(mClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
        }
        return mRetrofit
    }

    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originRequest = chain.request()
            val modifyUrl = originRequest.url().newBuilder()
                .addQueryParameter("phoneSystem", "")
                .addQueryParameter("phoneModel", "")
                .build()

            val request = originRequest.newBuilder().url(modifyUrl).build()

            chain.proceed(request)
        }
    }

    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originRequest = chain.request()
            val requestBuilder = originRequest.newBuilder()
                .addHeader("token", token)
                .method(originRequest.method(), originRequest.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }


}
