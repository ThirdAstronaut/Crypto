package com.project.crypto.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Rafał on 2017-09-02.
 */

public interface EmailService {

    void sendEmail(SimpleMailMessage email);

}
