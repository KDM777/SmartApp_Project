package kr.ac.kumoh.ce.s20200124.project

import retrofit2.http.GET
import retrofit2.http.Query

interface IIAApi {
    @GET("iia")
    suspend fun getIIA(
        @Query("apikey") apiKey: String=IIAApiConfig.API_KEY
    ): List<IIA>
}