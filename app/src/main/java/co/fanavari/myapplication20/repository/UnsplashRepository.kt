package co.fanavari.myapplication20.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import co.fanavari.myapplication20.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(
    private val unsplashApi: UnsplashApi
){
    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                maxSize = 40,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
              UnsplashPagingSource(
                  unsplashApi,
                  query
              )
            }
        ).liveData
}