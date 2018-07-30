package org.baldogru.imagegallery.model.dto;

import lombok.*;
import org.baldogru.imagegallery.constants.RequestType;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestData {
    private final MultipartFile imageFile;
    @NonNull
    private final RequestType requestType;
}
