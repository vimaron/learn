package ar.com.ada.learn.component;

import ar.com.ada.learn.exception.ApiEntityError;
import ar.com.ada.learn.exception.BusinessLogicException;
import ar.com.ada.learn.model.entity.StudentHasCourseId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component("businessLogicExceptionComponent")
public class BusinessLogicExceptionComponent {

    public void throwExceptionEntityNotFound(String entityName, Long id){
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The " + entityName + " with id " + id + "does not exist"
        );

        throw new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }

    public RuntimeException getExceptionEntityNotFound(String entityName, Long id){
        ApiEntityError apiEntityError = new ApiEntityError(
                entityName,
                "NotFound",
                "The " + entityName + " with id " + id + "does not exist"
        );

        return new BusinessLogicException(
                entityName + " does not exist",
                HttpStatus.NOT_FOUND,
                apiEntityError
        );
    }

    public RuntimeException getExceptionApplicationAlreadyExists(StudentHasCourseId id) {
        ApiEntityError apiEntityError = new ApiEntityError(
                "CourseApplication",
                "ApplicationAlreadyExists",
                "The application for course id " + id.getCourseId() + " and participan id "
                        + id.getStudentId() + "already exists"
        );
        return new BusinessLogicException(
                "this application already exists",
                HttpStatus.BAD_REQUEST,
                apiEntityError
        );
    }

    public RuntimeException getExceptionSoldOut(String name) {
        ApiEntityError apiEntityError = new ApiEntityError(
                name,
                "NotAvailable",
                "The course " + name + "is full"
        );
        return new BusinessLogicException(
                "no places available for the course",
                HttpStatus.BAD_REQUEST,
                apiEntityError
        );
    }
}
