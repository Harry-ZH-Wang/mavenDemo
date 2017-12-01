package com.test;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("log4jTest")
public class Log4jTest {

	static Logger log=Logger.getLogger(Log4jTest.class);
	public void log4j()
	{
        log.debug("===========debug信息===============");
        log.info("===========info信息===============");
        log.error("===========error信息===============");
	}
}
