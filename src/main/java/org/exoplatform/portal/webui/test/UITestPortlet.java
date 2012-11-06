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
package org.exoplatform.portal.webui.test;

import javax.portlet.PortletMode;

import org.exoplatform.webui.application.WebuiApplication;
import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIPopupWindow;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;

/**
 * Created by The eXo Platform SAS
 * Author : Canh Pham Van
 *          canhpv@exoplatform.com
 * Sep 14, 2012  
 */

@ComponentConfig(
       lifecycle=UIApplicationLifecycle.class
    )
public class UITestPortlet extends UIPortletApplication {

  public static final String TEXT_PREFERENCE = "text";
  
  public UITestPortlet() throws Exception{
    super();
    
  }
  
  public void processRender(WebuiApplication app, WebuiRequestContext context) throws Exception{
    //getChildren().clear();
    
    
    PortletRequestContext pContext = (PortletRequestContext) context;
    PortletMode currentMode = pContext.getApplicationMode();
    
    if (PortletMode.VIEW.equals(currentMode)){
      if (this.getChild(UITestForm.class)==null)
        this.addChild(UITestForm.class,null,null);
      
    }else{
      if(this.getChild(UITestConfig.class)==null)
        this.addChild(UITestConfig.class,null,null);
    }
    super.processRender(app,context);
  }
  
}
