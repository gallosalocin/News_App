package com.gallosalocin.newsapp.repository

import com.gallosalocin.newsapp.api.RetrofitInstance
import com.gallosalocin.newsapp.db.ArticleDatabase
import com.gallosalocin.newsapp.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, languageCode: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, languageCode, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}