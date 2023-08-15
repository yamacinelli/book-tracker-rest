package yamacinelli.booktracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yamacinelli.booktracker.dto.UserDto;
import yamacinelli.booktracker.model.User;
import yamacinelli.booktracker.repository.UserRepository;
import yamacinelli.booktracker.utils.ParseUtils;

import java.util.List;

@Service
public class UserService implements GenericService<UserDto> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto dto) {
        return ParseUtils.parse(
                userRepository.saveAndFlush(ParseUtils.parse(dto, User.class)),
                UserDto.class);
    }

    @Override
    public List<UserDto> saveAll(List<UserDto> dtos) {
        return ParseUtils.parse(
                userRepository.saveAllAndFlush(ParseUtils.parse(dtos, User.class)),
                UserDto.class);
    }

    @Override
    public UserDto findById(Integer id) {
        return ParseUtils.parse(
                userRepository.findById(id),
                UserDto.class);
    }

    @Override
    public List<UserDto> findAll() {
        return ParseUtils.parse(
                userRepository.findAll(),
                UserDto.class);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto update(UserDto dto) {
        return ParseUtils.parse(
                userRepository.saveAndFlush(ParseUtils.parse(dto, User.class)),
                UserDto.class);
    }

    public UserDto findByCredentials(UserDto dto) {
        return ParseUtils.parse(
                userRepository.findUserByEmailAndPassword(dto.getEmail(), dto.getPassword()),
                UserDto.class);
    }
}
