package tgo1014.placeholder.data.network.services

import retrofit2.Call
import retrofit2.http.GET

interface AnyService {

    @GET("")
    fun get(): Call<List<Any>>
}