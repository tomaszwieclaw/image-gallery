package org.baldogru.imagegallery.service.wrapper;

import org.baldogru.imagegallery.model.dto.ImageUploadData;
import org.baldogru.imagegallery.model.dto.RequestData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
final class RequestWrappingServiceImpl implements RequestWrappingService {

    private final UploadRequestWrappingService uploadRequestWrappingService;

    RequestWrappingServiceImpl(UploadRequestWrappingService uploadRequestWrappingService) {
        this.uploadRequestWrappingService = uploadRequestWrappingService;
    }

    @Override
    public RequestData wrapUploadData(MultipartFile file, ImageUploadData uploadData) {
        return uploadRequestWrappingService.wrapUploadData(file, uploadData);
    }
}
