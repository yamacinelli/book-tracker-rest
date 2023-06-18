package yamacinelli.booktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseErrorDto {

    private int errorCode;

    private String errorRequest;

    private String errorInObject;

    private List<ErrorDto> errorDtos;
}
