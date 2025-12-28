@Service
public class UserServiceImpl implements UserService {

    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return new User();
    }
}
