package solucionesnegocios.com.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_appointments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import solucionesnegocios.com.R
import solucionesnegocios.com.io.ApiService
import solucionesnegocios.com.model.Appointment
import solucionesnegocios.com.util.PreferenceHelper
import solucionesnegocios.com.util.PreferenceHelper.get
import solucionesnegocios.com.util.toast

class AppointmentsActivity : AppCompatActivity() {

    private val apiService: ApiService by lazy {
        ApiService.create()
    }

    private val preferences by lazy{
        PreferenceHelper.defaultPrefs(this)
    }

    private val appointmentAdapter =
        AppointmentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        loadAppointments()

        rvAppointments.layoutManager = LinearLayoutManager(this)
        rvAppointments.adapter = appointmentAdapter
    }

    private fun loadAppointments(){
        val jwt = preferences["jwt", ""]
        val call = apiService.getAppointments("Bearer $jwt")
        call.enqueue(object: Callback<ArrayList<Appointment>> {
            override fun onResponse(
                call: Call<ArrayList<Appointment>>,
                response: Response<ArrayList<Appointment>>
            ) {
                if(response.isSuccessful){
                    val appointments = response.body()
                    response.body()?.let {
                        appointmentAdapter.appointments = it
                        appointmentAdapter.notifyDataSetChanged()
                    }

                }
            }

            override fun onFailure(call: Call<ArrayList<Appointment>>, t: Throwable) {
                toast(t.localizedMessage)
            }

        })
    }
}