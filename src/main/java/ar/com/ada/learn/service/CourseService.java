package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.model.entity.Company;
import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.entity.CourseMode;
import ar.com.ada.learn.model.entity.TypeOfCourse;
import ar.com.ada.learn.model.mapper.CourseMapper;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.CompanyRepository;
import ar.com.ada.learn.model.repository.CourseModelRepository;
import ar.com.ada.learn.model.repository.CourseRepository;
import ar.com.ada.learn.model.repository.TypeOfCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("courseService")
public class CourseService implements Services<CourseDTO>{

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("typeOfCourseRepository")
    private TypeOfCourseRepository typeOfCourseRepository;

    @Autowired @Qualifier("courseModelRepository")
    private CourseModelRepository courseModelRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courseEntityList = courseRepository.findAll();
        List<CourseDTO> coursesDtoList = courseMapper.toDto(courseEntityList, context);
        return coursesDtoList;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        Long companyId = dto.getCompanyId();
        Company company = companyRepository
                .findById(companyId).orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("Company", companyId));

        Long typeOfCourseId = dto.getTypeOfCourseId();
        TypeOfCourse typeOfCourse = typeOfCourseRepository.findById(typeOfCourseId)
                .orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("TypeOfCourse", typeOfCourseId));

        Long courseModeId = dto.getCourseModeId();
        CourseMode courseMode = courseModelRepository.findById(courseModeId)
                .orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("CourseMode", courseModeId));

        Course courseToSave = courseMapper.toEntity(dto, context);
        courseToSave.setCompany(company);
        courseToSave.setTypeOfCourse(typeOfCourse);
        courseToSave.setCourseMode(courseMode);

        courseToSave.setCourseMode(courseMode);
        courseToSave.setCompany(company);
        courseToSave.setTypeOfCourse(typeOfCourse);

        int directPurchaseCounter = dto.getCapacity() - dto.getScholarships();
        courseToSave.setDirectPurchaseCounter(directPurchaseCounter);
        courseToSave.setScholarships(dto.getScholarships());

        Course courseSaved = courseRepository.save(courseToSave);
        CourseDTO courseDTOSaved = courseMapper.toDto(courseSaved, context);

        return courseDTOSaved;
    }



    @Override
    public void delete(Long id) {
    }

    public CourseDTO findCourseById(Long id){

        Optional<Course> byIdOptional = courseRepository.findById(id);

        CourseDTO courseDTO = null;

        if (byIdOptional.isPresent()){
            Course courseById = byIdOptional.get();
            courseDTO = courseMapper.toDto(courseById, context);
        }else {
            businessLogicExceptionComponent.throwExceptionEntityNotFound("Course", id);

        }
        return courseDTO;
    }

    public List<CourseDTO> getAllCoursesByCategory(Long categoryId, Integer page) {
        Page<Course> courseByCategoryList = courseRepository
                .findAllByCategory(categoryId, PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allByCategory = courseByCategoryList.getContent();
        List<CourseDTO> courseByCategoryListDTO = courseMapper.toDto(allByCategory, context);
        return courseByCategoryListDTO;
    }



    public List<CourseDTO> getAllCoursesByCompany(Long companyId, Integer page){
        Page<Course> courseByCompany = courseRepository
                .findAllByCompany(companyId, PageRequest.of(page, 5, Sort.Direction.ASC, "id"));
        List<Course> allByCompany = courseByCompany.getContent();
        List<CourseDTO> courseByCompanyDTO = courseMapper.toDto(allByCompany, context);
        return courseByCompanyDTO;
    }


    public List<CourseDTO> getAllCoursesByCompanyAndCategory(Long companyId, Long categoryId, Integer page){
        Page<Course> coursesByCompanyAndCategory = courseRepository.
                findAllByCompanyAndCategory(companyId, categoryId, PageRequest.of(page, 5, Sort.Direction.ASC, "id"));

        List<Course> allByCompanyCategory = coursesByCompanyAndCategory.getContent();
        List<CourseDTO> coursesByCompanyAndCategoryDTO = courseMapper.toDto(allByCompanyCategory, context);
        return coursesByCompanyAndCategoryDTO;
    }


    public List<CourseDTO> getAllCoursesByStudentAndStatus(Boolean finished, Integer page){
        Page<Course> courseByStudentAndStatus = courseRepository.
                findAllByStudentAndStatus(Boolean.valueOf(finished), PageRequest.of(page, 5, Sort.Direction.ASC, "id"));
        List<Course> courseByStudentStatus = courseByStudentAndStatus.getContent();
        List<CourseDTO> courseByStudentStatusDTO = courseMapper.toDto(courseByStudentStatus, context);
        return courseByStudentStatusDTO;
    }

}
