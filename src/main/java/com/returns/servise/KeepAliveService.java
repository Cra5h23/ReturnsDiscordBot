package com.returns.servise;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Nikolay Radzivon
 * @Date 19.08.2024
 */
@Service
public class KeepAliveService {
    @Scheduled(fixedRate = 1 * 1000 * 60)
    public void reportCurrentTime() {
        System.out.println(System.currentTimeMillis());
    }
}
