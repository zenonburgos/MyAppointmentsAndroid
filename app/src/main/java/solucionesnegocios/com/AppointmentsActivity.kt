package solucionesnegocios.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_appointments.*
import solucionesnegocios.com.model.Appointment

class AppointmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        val appointments = ArrayList<Appointment>()
        appointments.add(
            Appointment(1, "Médico Test", "12/12/2020", "3:00 PM")
        )
        appointments.add(
            Appointment(2, "Médico BB", "15/12/2020", "4:30 PM")
        )
        appointments.add(
            Appointment(3, "Médico CC", "17/12/2020", "7:00 AM")
        )

        rvAppointments.layoutManager = LinearLayoutManager(this)
        rvAppointments.adapter = AppointmentAdapter(appointments)
    }
}