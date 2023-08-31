package com.app.replace.controller;

import com.app.replace.dao.FileDAO;
import com.app.replace.vo.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/file/*")
public class FileController {
    private final FileDAO fileDAO;

    private final String projectPath = System.getProperty("user.dir").replace("\\","/");
    private final String imageFilePath = "/src/main/resources/static/images/";

    private final long session = 2L;

    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("uploadFile")MultipartFile uploadFile, @RequestParam("memberId")long memberId) throws IOException {
        String path = projectPath + imageFilePath + getPath();

        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "_" + uploadFile.getOriginalFilename();
        File file = new File(path);
        FileVO fileVO = new FileVO();
        if (!file.exists()){
            file.mkdirs();
        }

        uploadFile.transferTo(new File(path, fileName));

        fileVO.setFileName(uploadFile.getOriginalFilename());
        fileVO.setFilePath(getPath());
        fileVO.setFileSize(uploadFile.getSize());
        fileVO.setFileUuid(uuid);
        fileVO.setFileType(uploadFile.getContentType());
        fileVO.setMemberId(memberId);

        log.info("file info : {}......", fileVO);

        try{
            if (fileDAO.getFile(fileVO.getMemberId()).isPresent()){
                fileDAO.update(fileVO);
            }
        }catch (NoSuchElementException e){
            fileDAO.save(fileVO);
        }


        if (uploadFile.getContentType().startsWith("image")){
//            FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuid + "_" + uploadFile.getOriginalFilename()));
//            Thumbnailator.createThumbnail(uploadFile.getInputStream(),out,100,100);
//            out.close();
            log.info("making Thumbnail.......");
        }

        return uuid;
    }

    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    @GetMapping("display")
    @ResponseBody
    public byte[] display(String memberId) throws IOException{
        log.info("display entered");


        Optional<FileVO> fileVO = fileDAO.getFile(Long.parseLong(memberId));

        if (fileVO.isPresent())
        {
            return FileCopyUtils.copyToByteArray(new File(projectPath + imageFilePath, fileVO.get().getFilePath()+ "/" + fileVO.get().getFileUuid() + "_" + fileVO.get().getFileName()));
        }else{
            return FileCopyUtils.copyToByteArray(new File(projectPath + imageFilePath, "defaultProfileImg.jpg"));

        }

//        return FileCopyUtils.copyToByteArray(new File(projectPath + imageFilePath, fileName));
    }
}
