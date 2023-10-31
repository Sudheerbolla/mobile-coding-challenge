package com.audiobookstask.utils.network

import com.audiobookstask.data.repo.PodcastsRepository
import com.audiobookstask.data.repo.PodcastsRepositoryImpl
import com.audiobookstask.utils.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

object RetrofitInstance {

    fun GetRetrofitInstance(): Retrofit {
        val client = OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
        return Retrofit.Builder()
            .baseUrl(Const.WEB_API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun providePodcastsService(
        retrofit: Retrofit
    ): PodcastsService = retrofit.create(PodcastsService::class.java)

    fun provideGamesRepository(
        podcastsService: PodcastsService,
        @Named("PAGE_SIZE") pageSize: Int,
    ): PodcastsRepository = PodcastsRepositoryImpl(
        podcastsService = podcastsService,
        pageSize = pageSize
    )

}
