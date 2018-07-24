package org.baldogru.imagegallery.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestData {
    private final MultipartFile imageFile;
}
