/*
 * Creation : Nov 7, 2016
 */
package com.psa.service;

import com.psa.dto.SwingInputDto;

public interface ICreateJavaBeanService {

    public boolean validateInputParameters(SwingInputDto swingInputDto);

    public void prepareCreation(SwingInputDto swingInputDto);

    public void createServiceCode(SwingInputDto swingInputDto);

    public void createDaoCode(SwingInputDto swingInputDto);

    public void createModelCode(SwingInputDto swingInputDto);
}
