package dev.fahd.user.mapper;

import dev.fahd.user.dto.UserDTO;
import dev.fahd.user.entity.User;
import dev.fahd.user.mapper.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<User, UserDTO> {
}
