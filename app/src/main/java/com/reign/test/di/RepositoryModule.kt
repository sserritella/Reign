package com.reign.test.di

import android.content.Context
import com.reign.test.data.ArticleDao
import com.reign.test.data.repositories.ArticleRemoteDataSource
import com.reign.test.data.repositories.ArticlesRepository
import org.koin.dsl.module


val repositoryModule = module {

    fun provideArticleRepository(
        api: ArticleRemoteDataSource,
        local: ArticleDao,
        context: Context
    ): ArticlesRepository {
        return ArticlesRepository(api, local, context)
    }

    single { provideArticleRepository(get(), get(), get()) }
    single { ArticleRemoteDataSource(get()) }

}