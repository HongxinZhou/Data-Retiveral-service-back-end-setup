package au.edu.sydney.agapp.service.repositories

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import au.edu.sydney.agapp.service.models.User

@Repository
interface UserRepository : CrudRepository<User, Long>
