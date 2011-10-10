<%@tag description="Base Template Tag" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="head" fragment="true" %>
<%@attribute name="content_header" fragment="true" %>
<%@attribute name="content_submenu" fragment="true" %>
<%@attribute name="sidebar" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head runat="server">
        <title>Online Auction Site</title>
        
        <link href="${pageContext.request.contextPath}/res/css/base.css" rel="stylesheet" type="text/css" />
    </head>
    <body>  
        <div id="global_wrapper" class="border_glow">
            <div id="global_header_wrapper">
                <div id="header_wrapper">
                    <div id="global_top_bar">
                        <div>
                        	DG & SD present:
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div id="global_title_wrapper">
                        <p>Online Auction Site</p>
                    </div>
                </div>

                <div id="global_menu_wrapper">
                    Menu 1 | Menu 2 | Menu 3
                </div>
            </div>

            <div id="global_sidebar_wrapper">
       			<jsp:invoke fragment="sidebar"/>
            </div>


            <div id="global_content_wrapper">
                <div id="content_header_wrapper">
                	<jsp:invoke fragment="content_header"/>
                </div>

                <div id="content_submenu_wrapper">
					<jsp:invoke fragment="content_submenu"/>
                </div>

                <div id="content_wrapper">
					<jsp:doBody />
                    <div class="clear"></div>
                </div>
            </div>

            <div class="clear"></div>

            <div id="global_footer_wrapper" class="center_text">
 				<jsp:invoke fragment="footer"/>
            </div>
        </div>  
    </body>
</html>