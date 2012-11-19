/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.portal.webui.image.crop;

import java.util.regex.Matcher;


import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          annb@exoplatform.com
 * Nov 16, 2012  
 */

//@Test: make test case
//@Before, @After: run before,after EVERY test cases
//@BeforeClass, @AfterClass: run for ONE TIME before and after all test cases
//Exception handling: @Test(expected = ArithmeticException.class)
//@Ignore("not ready to run") ignore test
//@Test(timeout = 1000) timeout

public class ImageCroppingAttacmentTest {

  private static final Logger LOG = LoggerFactory.getLogger(ImageCroppingAttacmentTest.class);

   
  @BeforeClass
  public static void displayBeforeClass() throws Exception {
    LOG.info("displayBeforeClass");
  }
  
  @AfterClass
  public static void displayAfterClass() throws Exception{
    LOG.info("displayAfterClass");
  }

  @Test
  public void verifyTest() throws Exception{   
   LOG.info("verifyTest");
   Assert.assertEquals("", "");

  }
  
  
 }


