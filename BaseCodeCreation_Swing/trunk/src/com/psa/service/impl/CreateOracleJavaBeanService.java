/*
 * Creation : Nov 7, 2016
 */
package com.psa.service.impl;

import com.psa.dto.SwingInputDto;
import com.psa.service.ICreateJavaBeanService;

public class CreateOracleJavaBeanService implements ICreateJavaBeanService {

    @Override
    public void createServiceCode(SwingInputDto swingInputDto) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createDaoCode(SwingInputDto swingInputDto) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createModelCode(SwingInputDto swingInputDto) {
        // TODO Auto-generated method stub

        // get fields and field type
        // select * from user_tab_columns where table_name='PCBQTCPN';
        // GET PK and FK
        // SELECT * from user_constraints where constraint_type in ('P','R')
        // AND TABLE_NAME='PCBQTCPN';
    }

    @Override
    public boolean validateInputParameters(SwingInputDto swingInputDto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void prepareCreation(SwingInputDto swingInputDto) {
        // TODO Auto-generated method stub

    }

}
