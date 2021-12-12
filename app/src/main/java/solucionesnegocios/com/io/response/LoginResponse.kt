package solucionesnegocios.com.io.response

import solucionesnegocios.com.model.User

class LoginResponse(val success: Boolean, val user: User, val jwt: String)