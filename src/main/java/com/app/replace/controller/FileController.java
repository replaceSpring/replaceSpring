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

        fileVO.setFileName(uploadFile.getOriginalFilename());
        fileVO.setFilePath(getPath());
        fileVO.setFileSize(uploadFile.getSize());
        fileVO.setFileUuid(uuid);
        fileVO.setFileType(uploadFile.getContentType());
        fileVO.setMemberId(memberId);

        log.info("file info : {}......", fileVO);

        if (fileDAO.getFileCountById(fileVO.getMemberId())>=1){ // 유저의 파일이 하나 이상일 때....
            fileDAO.update(fileVO);
            uploadFile.transferTo(new File(path, fileName));

        }else {
            fileDAO.save(fileVO);
            uploadFile.transferTo(new File(path, fileName));
        }

        return uuid;
    }

    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    @GetMapping("display")
    @ResponseBody
    public byte[] display(String memberId) throws IOException{


        Optional<FileVO> fileVO = fileDAO.getFile(Long.parseLong(memberId));

        if (fileDAO.getFileCountById(Long.parseLong(memberId)) >= 1)//유저의 파일이 하나 이상일 때....
        {
            log.info("display entered member : {} IMG SEND SUCCESSFUL {}" ,memberId, fileVO.get().getFileName());
            return FileCopyUtils.copyToByteArray(new File(projectPath + imageFilePath, fileVO.get().getFilePath()+ "/" + fileVO.get().getFileUuid() + "_" + fileVO.get().getFileName()));
        }else{
            log.info("display entered member : {} NO PROFILE IMG" ,memberId);
            return FileCopyUtils.copyToByteArray(new File(projectPath + imageFilePath, "defaultProfileImg.jpg"));

        }

//        return FileCopyUtils.copyToByteArray(new File(projectPath + imageFilePath, fileName));
    }
}
