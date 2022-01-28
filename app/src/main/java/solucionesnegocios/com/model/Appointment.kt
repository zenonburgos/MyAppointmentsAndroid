package solucionesnegocios.com.model

import com.google.gson.annotations.SerializedName

data class Appointment (
    val id: Int,
    val description: String,
    val type: String,
    val status: String,

    val doctorName: String,
    @SerializedName("scheduled_date") val scheduledDate: String,
    @SerializedName("scheduled_time_12") val scheduledTime: String,
    @SerializedName("created_at") val createdAt: String,

    val specialty: Specialty,
    val doctor: Doctor
    )