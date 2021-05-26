package com.example.springbootCM.apiServer;

import lombok.*;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {
    @NonNull private T data;
    private String token;
    private List<String> errors;
}
