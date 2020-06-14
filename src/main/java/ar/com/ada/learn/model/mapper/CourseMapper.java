package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.mapper.circular.DataCycleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CourseMapper extends DataCycleMapper<CourseDTO, Course> {

    Course toEntity(CourseDTO dto);

    CourseDTO toDto(Course entity);

    default Course fromId(Long id){
        if (id == null) return null;
        return new Course(id);
    }
}
