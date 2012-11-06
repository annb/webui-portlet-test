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
import javax.portlet.PortletPreferences;

import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.application.portlet.PortletRequestContext;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;
import org.exoplatform.webui.form.UIForm;
import org.exoplatform.webui.form.UIFormStringInput;

/**
 * Created by The eXo Platform SAS
 * Author : Canh Pham Van
 *          canhpv@exoplatform.com
 * Sep 14, 2012  
 */
public class UITestConfig extends UIForm{
  
  public static final String TEXT_STRING_INPUT = "UITestPortletTextStringInput";
  
  public UITestConfig() {
    PortletRequestContext pContext = WebuiRequestContext.getCurrentInstance();
    PortletPreferences preferences = pContext.getRequest().getPreferences();
    String text = preferences.getValue(UITestPortlet.TEXT_PREFERENCE, null);
    addChild(new UIFormStringInput(TEXT_STRING_INPUT,text));
  }

  
  public static class SaveActionListener extends EventListener<UITestConfig>{
    public void execute(Event<UITestConfig> event) throws Exception{
      UITestConfig basicConfig = event.getSource();
      
      UIFormStringInput textStringInput = basicConfig.getUIStringInput(TEXT_STRING_INPUT);
      
      PortletRequestContext pContext = WebuiRequestContext.getCurrentInstance();
      PortletPreferences preferences = pContext.getRequest().getPreferences();
      preferences.setValue(UITestPortlet.TEXT_PREFERENCE, textStringInput.getValue());
      preferences.store();
      
      PortletRequestContext context = (PortletRequestContext)event.getRequestContext();
      context.setApplicationMode(PortletMode.VIEW);
      
    }
  }
  
  public static class CancelActionListener extends EventListener<UITestConfig>{
    public void execute(Event<UITestConfig> event) throws Exception{
      PortletRequestContext context = (PortletRequestContext)event.getRequestContext();
      context.setApplicationMode(PortletMode.VIEW);
    }
  }
}
