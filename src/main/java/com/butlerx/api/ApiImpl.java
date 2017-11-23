/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2017. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.butlerx.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.butlerx.admin.ApiApiDelegate;

@Component
public class ApiImpl implements ApiApiDelegate {

    public ResponseEntity<String> getAOBpts() {
        return new ResponseEntity<String>("Hello ButlerX team! ", HttpStatus.OK);
    }

}
