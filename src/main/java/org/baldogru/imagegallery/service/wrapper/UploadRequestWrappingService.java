package org.baldogru.imagegallery.service.wrapper;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.springframework.web.multipart.MultipartFile;

public interface UploadRequestWrappingService {

    RequestData wrapUploadData(MultipartFile file, ImageUploadData uploadData);

}
