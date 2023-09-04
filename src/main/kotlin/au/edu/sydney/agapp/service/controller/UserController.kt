package au.edu.sydney.agapp.service.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import au.edu.sydney.agapp.service.repositories.UserRepository
import au.edu.sydney.agapp.service.models.User
import io.micronaut.http.server.cors.CrossOrigin

@Controller("/signup")
class SignupController {

    @Inject
    lateinit var userRepository: UserRepository

    @CrossOrigin(allowedOrigins = ["http://localhost:3000"])
    @Post("/")
    @Consumes(MediaType.APPLICATION_JSON)
    fun signup(@Body signupRequest: SignupRequest): String {
        val user = User(
            name = signupRequest.name,
            email = signupRequest.email,
            password = signupRequest.password // 在实际应用中，请确保密码是加密的
        )

        userRepository.save(user)
        println("Received SignupRequest: $signupRequest")
        return "Signup successful"
    }
}


