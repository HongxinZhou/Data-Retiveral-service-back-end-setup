package au.edu.sydney.agapp.service.services
import au.edu.sydney.agapp.service.models.User
import au.edu.sydney.agapp.service.repositories.UserRepository
import jakarta.inject.Singleton
import jakarta.inject.Inject

@Singleton // 在Micronaut中用于标识一个单例bean
class UserService(@Inject val userRepository: UserRepository) { // 使用@Inject进行依赖注入

    fun createUser(name: String, email: String, password: String): User {
        // 加密密码、验证等操作
        val user = User(name = name, email = email, password = password)
        return userRepository.save(user)
    }
}