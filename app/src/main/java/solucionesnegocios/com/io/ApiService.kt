package solucionesnegocios.com.io

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import solucionesnegocios.com.model.Doctor
import solucionesnegocios.com.model.Specialty

interface ApiService {

    @GET("specialties")
    abstract fun getSpecialties(): Call<ArrayList<Specialty>>

    @GET("specialties/{specialty}/doctors")
    abstract fun getDoctors(@Path("specialty") specialtyId: Int): Call<ArrayList<Doctor>>

    companion object Factory {
        // Local IP to use on an emulator
        // php artisan serve --host=0.0.0.0
        private const val BASE_URL = "http://167.172.253.167/api/"

        // private const val BASE_URL = "http://164.90.143.11/api/"

        fun create(): ApiService {
           val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}