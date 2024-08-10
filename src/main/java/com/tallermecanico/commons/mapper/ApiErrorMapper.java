package com.tallermecanico.commons.mapper;

import com.tallermecanico.commons.domain.BaseException;
import com.tallermecanico.commons.model.ApiError;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = { LocalDateTime.class })
public interface ApiErrorMapper {
    @Mappings({ @Mapping(target = "timestamp", expression = "java(LocalDateTime.now().toString())"),
            @Mapping(source = "errorCode", target = "error"), @Mapping(source = "errorMessage", target = "message"),
            @Mapping(source = "exc.message", target = "detailedMessage") })
    ApiError toApiError(String errorCode, Exception exc, String errorMessage, String path);

    @Mappings({ @Mapping(target = "timestamp", expression = "java(LocalDateTime.now().toString())"),
            @Mapping(source = "errorCode", target = "error"), @Mapping(source = "exc.message", target = "message") })
    ApiError toApiError(String errorCode, Exception exc, String path);

}
