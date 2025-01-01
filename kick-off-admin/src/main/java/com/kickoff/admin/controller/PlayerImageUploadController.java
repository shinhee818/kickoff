package com.kickoff.admin.controller;

import com.kickoff.admin.service.PlayerAdminService;
import com.kickoff.admin.service.upload.PlayerImageUploadService;
import com.kickoff.admin.service.upload.S3ImageUploadServiceImpl;
import com.kickoff.core.soccer.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/image")
public class PlayerImageUploadController {
    private final PlayerImageUploadService playerImageUploadService;
    private final PlayerAdminService playerAdminService;
    private final PlayerService playerService;

    @Autowired
    public PlayerImageUploadController(
            S3ImageUploadServiceImpl playerImageUploadService,
            PlayerAdminService playerAdminService,
            PlayerService playerService
    ) {
        this.playerImageUploadService = playerImageUploadService;
        this.playerAdminService = playerAdminService;
        this.playerService = playerService;
    }

    @PostMapping("/upload/{playerId}")
    public ResponseEntity<String> uploadFiles(@PathVariable Long playerId,  @RequestPart(value = "file") MultipartFile multipartFile)
    {
        if(multipartFile.isEmpty()){
            return ResponseEntity.badRequest().body("파일이 없습니다.");
        }
        try{
            String savePath = playerImageUploadService.upload(multipartFile);

            playerAdminService.addPlayerImage(playerId,savePath);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/admin/all-players/" + playerId);
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("업로드 실패: IO 오류");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("업로드 실패: 기타 오류");
        }
    }
}
