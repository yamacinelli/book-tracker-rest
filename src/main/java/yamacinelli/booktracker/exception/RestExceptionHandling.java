package yamacinelli.booktracker.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import yamacinelli.booktracker.dto.ErrorDto;
import yamacinelli.booktracker.dto.ResponseErrorDto;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandling extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<>(responseError(ex, HttpStatus.valueOf(status.value())), HttpStatus.valueOf(status.value()));
    }

    private ResponseErrorDto responseError(MethodArgumentNotValidException e, HttpStatus status) {
        return new ResponseErrorDto(status.value(), status.getReasonPhrase(), e.getBindingResult().getObjectName(), errorDtos(e));
    }

    private List<ErrorDto> errorDtos(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldErrors()
                .stream()
                .map(obj -> new ErrorDto(obj.getDefaultMessage(), obj.getField(), obj.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
