package com.tallermecanico.commons.infrastructure.handler;

import com.tallermecanico.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallermecanico.cliente.domain.exception.ClienteNotFoundException;
import com.tallermecanico.commons.application.create_message.ErrorMessageCreator;
import com.tallermecanico.commons.domain.BaseException;
import com.tallermecanico.commons.mapper.ApiErrorMapper;
import com.tallermecanico.commons.model.ApiError;
import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallermecanico.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = {
        "com.tallermecanico.cliente.infrastructure.controller",
        "com.tallermecanico.motocicleta.infrastructure.controller" // Incluye el paquete de motocicletas
})
@RequiredArgsConstructor
public class GeneralExceptionHandler {

    private final ErrorMessageCreator errorMessageCreator;
    private final ApiErrorMapper errorMapper;

    private ApiError buildGeneralResponse(BaseException e, HttpServletRequest request) {
        String exceptionName = e.getClass().getSimpleName();
        String completePath = request.getMethod().concat(":").concat(request.getRequestURI());
        log.error("Unable to run the requested operation: " + completePath, e);

        // Obtiene el mensaje de error
        String errorMessage = errorMessageCreator.getMessage(e.getCode() + "_MESSAGE");
        // Construye el ApiError
        return errorMapper.toApiError(e.getCode(), e, errorMessage, completePath);
    }

    @ExceptionHandler({ClienteDuplicateDniException.class, MotocicletaDuplicatePatenteException.class})
    public ResponseEntity<ApiError> handleBadRequestExceptions(BaseException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildGeneralResponse(e, request));
    }

    @ExceptionHandler({ClienteNotFoundException.class, MotocicletaPatenteNotFoundException.class})
    public ResponseEntity<ApiError> handleNotFoundExceptions(BaseException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildGeneralResponse(e, request));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralException(Exception e, HttpServletRequest request) {
        // Maneja excepciones generales que no extienden BaseException
        log.error("Unhandled exception: " + request.getMethod() + ":" + request.getRequestURI(), e);

        // Construye el ApiError para excepciones generales
        ApiError apiError = errorMapper.toApiError("UNKNOWN_ERROR", e, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}
